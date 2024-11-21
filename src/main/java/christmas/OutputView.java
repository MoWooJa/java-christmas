package christmas;

import java.text.DecimalFormat;
import java.util.List;

public class OutputView {

    private static final DecimalFormat priceFormat = new DecimalFormat("#,###");

    public void print(OrderResult orderResult) {
        printHeader(orderResult);
        printOrderMenu(orderResult);
        printTotalPrice(orderResult);
        printFreeMenu(orderResult);
        printBenefit(orderResult);
        printDiscountPrice(orderResult);
        printFinalPrice(orderResult);
        printBadge(orderResult);
    }

    private void printBadge(OrderResult orderResult) {
        System.out.println("<12월 이벤트 배지>");
        System.out.println(orderResult.getBadge().name());
    }

    private void printFinalPrice(OrderResult orderResult) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(orderResult.getFinalPrice());
    }

    private void printDiscountPrice(OrderResult orderResult) {
        System.out.println("<총혜택 금액>");
        System.out.println(orderResult.getDiscountPrice());
    }

    private void printBenefit(OrderResult orderResult) {
        System.out.println("<혜택 내역>");
        if (orderResult.getBenefit() == null) {
            System.out.println("없음");
            return;
        }

        int specialBenefit = orderResult.getBenefit().getSpecialBenefit().getDiscountPrice();
        int weekendBenefit = orderResult.getBenefit().getWeekendBenefit().getDiscountPrice();
        int xmasBenefit = orderResult.getBenefit().getXmasBenefit().getDiscountPrice();
        int weekDayBenefit = orderResult.getBenefit().getWeekDayBenefit().getDiscountPrice();
        int freeBenefit = orderResult.getBenefit().getFreeBenefit().getDiscountPrice();

        if (xmasBenefit != 0) {
            System.out.printf("크리스마스 디데이 할인: %s", formatPrice(xmasBenefit));
            System.out.println();
        }

        if (weekDayBenefit != 0) {
            System.out.printf("평일 할인: %s", formatPrice(weekDayBenefit));
            System.out.println();
        }

        if (weekendBenefit != 0) {
            System.out.printf("주말 할인: %s", formatPrice(weekendBenefit));
            System.out.println();
        }

        if (freeBenefit != 0) {
            System.out.printf("증정 이벤트: %s", formatPrice(freeBenefit));
            System.out.println();
        }

        if (specialBenefit != 0) {
            System.out.printf("특별 할인: %s", formatPrice(specialBenefit));
            System.out.println();
        }
    }

    private void printFreeMenu(OrderResult orderResult) {
        System.out.println("<증정 메뉴>");
        if (orderResult.getBenefit() == null ||
                orderResult.getBenefit().getFreeBenefit().getDiscountPrice() == 0) {
            System.out.println("없음");
            return;
        }
        System.out.println("샴페인 1개");
    }

    public void printTotalPrice(OrderResult orderResult) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.printf("%d원", orderResult.getTotalPrice());
    }

    private void printOrderMenu(OrderResult orderResult) {
        System.out.println("<주문 메뉴>");
        List<OrderRequestDto> orderRequests = orderResult.getOrderRequests();
        for (OrderRequestDto orderRequest : orderRequests) {
            System.out.printf("%s %d", orderRequest.menu().name(), orderRequest.quantity());
            System.out.println();
        }
    }

    public void printHeader(OrderResult orderResult) {
        System.out.printf("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!", orderResult.getVisitDay().getDay());
        System.out.println();
    }


    private String formatPrice(int price) {
        return priceFormat.format(price);
    }
}
