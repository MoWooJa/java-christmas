package christmas;

import camp.nextstep.edu.missionutils.Console;
import christmas.event.*;

import java.util.EnumMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Validator validator = new Validator();
        DiscountCalculate discountCalculate = new DiscountCalculate();
        String visitDate = inputView.getVisitDate();
        try{
            validator.parseDate(visitDate);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return;
        }

        int date = Integer.parseInt(visitDate);

        String menu = inputView.getMenu();
        try{
            validator.validateMenu(menu);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return;
        }


        outputView.printDateBenefit(date);
        EnumMap<Menu, Integer> order = Parser.parse(menu);

        int orderItemCount = 0;
        for (Integer value : order.values()) {
            orderItemCount += value;
        }

        boolean allDrink = order.keySet().stream()
                .allMatch(item -> item.getCategory().equals(MenuCategory.DRINK));
        if (allDrink) {
            throw new IllegalArgumentException("ERROR: 모든 주문 메뉴가 음료수는 불가");
        }
        if (orderItemCount > 20) {
            throw new IllegalArgumentException("ERROR: 메뉴 20개 주문 불가");
        }


        outputView.printOrderItems(order);

        int sumAllItemsPrice = discountCalculate.sumAllItemsPrice(order);
        outputView.printSumAllItemsPrice(sumAllItemsPrice);

        //이벤트 적용
        int christmasDiscount = ChristmasEvent.discountPrice(date);
        int freeItemDiscount = FreeItemEvent.discountPrice(sumAllItemsPrice);
        int specialDiscount = SpecialEvent.discountPrice(date);
        int weekdayDiscount = WeekdayEvent.discountPrice(date, order);
        int weekendDiscount = WeekendEvent.discountPrice(date, order);

        int totalBenefitAmount = christmasDiscount + freeItemDiscount
                + specialDiscount + weekdayDiscount + weekendDiscount;
        int payAmount = sumAllItemsPrice - christmasDiscount - specialDiscount - weekdayDiscount - weekendDiscount;
        Badge badge = Badge.receiveBadge(totalBenefitAmount);
        if (sumAllItemsPrice > 10000) {
            outputView.printBenefitAmount(totalBenefitAmount);
            outputView.printPayAmount(payAmount);
            outputView.printBenefitRecord(christmasDiscount, freeItemDiscount, specialDiscount, weekdayDiscount, weekendDiscount);
            outputView.printFreeItem(freeItemDiscount);
            outputView.printBadge(badge);
        } else {
            outputView.printBenefitAmount(0);
            outputView.printPayAmount(0);
            outputView.printBenefitRecord(0, 0, 0, 0, 0);
            outputView.printFreeItem(0);
            outputView.printBadge(Badge.NONE);
        }


        //배지


    }

    static class Validator {
        private static final String DELIMITER = ",";

        public void parseDate(String dateStr) {
            try {
                int date = Integer.parseInt(dateStr);
                validateDateRange(date);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            }
        }

        private void validateDateRange(int date) {
            if (!(date >= 1 && date <= 31)) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            }
        }

        public void validateMenu(String menuStr) {
            String[] orderItems = menuStr.split(",");
            for (String orderItem : orderItems) {
                orderItem = orderItem.trim(); // 공백 제거
                if (!orderItem.matches("^[가-힣]+-\\d+$")) { // 가-1,나-2 형식 확인
                    throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
                }
            }
        }
    }

    static class InputView {
        public String getVisitDate() {
            System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.\n" +
                    "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
            String input = Console.readLine();
            System.out.println();
            return input;
        }

        public String getMenu() {
            System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
            String input = Console.readLine();
            System.out.println();
            return input;
        }
    }

    static class OutputView {

        public void printBadge(Badge badge) {
            System.out.println("<12월 이벤트 배지>\n");
            System.out.println(badge.getName());
        }

        public void printDateBenefit(int date) {
            System.out.printf("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n", date);
        }

        public void printOrderItems(EnumMap<Menu, Integer> order) {
            System.out.println("<주문 메뉴>\n");
            for (Map.Entry<Menu, Integer> entry : order.entrySet()) {
                if (entry.getValue() != 0) {
                    System.out.println(entry.getKey().getName() + " " + entry.getValue() + "개");
                }
            }
            System.out.println();
        }

        public void printSumAllItemsPrice(int sumAllItemsPrice) {
            System.out.println("<할인 전 총주문 금액>");
            System.out.println(sumAllItemsPrice);
        }

        public void printFreeItem(int freeItemDiscount) {
            System.out.println("<증정 메뉴>");
            if (freeItemDiscount == 0) {
                System.out.println("없음");
            } else {
                System.out.println("샴페인 1개");
            }
        }

        public void printBenefitAmount(int benefitAmount) {
            System.out.println("<총혜택 금액>\n");
            if (benefitAmount == 0) {
                System.out.println("0원");
            } else {
                System.out.printf("-%d원", benefitAmount);
            }

        }

        public void printPayAmount(int payAmount) {
            System.out.println("<할인 후 예상 결제 금액>");
            System.out.println(payAmount + "원");
        }

        public void printBenefitRecord(int christmasDiscount, int freeItemDiscount, int specialDiscount, int weekdayDiscount, int weekendDiscount) {
            System.out.println("<혜택 내역>");
            if (christmasDiscount + freeItemDiscount + specialDiscount + weekdayDiscount + weekendDiscount == 0) {
                System.out.println("없음");
                return;
            }
            if (christmasDiscount != 0) {
                System.out.printf("크리스마스 디데이 할인: -%,d원\n", christmasDiscount);
            }
            if (weekdayDiscount != 0) {
                System.out.printf("평일 할인: -%,d원\n", weekdayDiscount);
            }
            if (specialDiscount != 0) {
                System.out.printf("특별 할인: -%,d원\n", specialDiscount);
            }
            if (freeItemDiscount != 0) {
                System.out.printf("증정 이벤트: -%,d원\n", freeItemDiscount);
            }
            if (weekendDiscount != 0) {
                System.out.printf("주말 할인: -%,d원\n", weekendDiscount);
            }


        }
    }

    static class DiscountCalculate {
        public int sumAllItemsPrice(EnumMap<Menu, Integer> items) {
            int totalPrice = 0;
            for (Map.Entry<Menu, Integer> entry : items.entrySet()) {
                totalPrice += entry.getValue() * (entry.getKey().getPrice());
            }
            return totalPrice;
        }
    }
}
