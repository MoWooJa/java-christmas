package christmas;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.Calender;
import christmas.domain.Menu;
import christmas.domain.Order;
import christmas.domain.Orders;
import christmas.domain.Planner;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Application {

    //캘린더,메뉴 생성
    static Calender calender = new Calender();
    static Menu menu = new Menu();
    //Orders 생성
    static Orders orders = new Orders();
    //평일,주말
    static String[] weekAndPrice = new String[2];
    static DecimalFormat df = new DecimalFormat("###,###");
    private static final String SEPARATOR = System.lineSeparator(); // 상수화된 줄바꿈

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        //방문 날짜 계산
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.\n"
                + "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        int day = Integer.parseInt(Console.readLine());



        //메뉴 주문
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        String orderMenu = Console.readLine();
        String[] comaOrder = orderMenu.split(",");
        for (String strOrder : comaOrder) {
            String[] strMenu = strOrder.split("-");
            String food = strMenu[0];
            int quantity = Integer.parseInt(strMenu[1]);
            Order order = new Order(day, food, quantity);
            orders.addOrders(order);
        }

        //할인전 총금액 계산
        int totalPrice = 0;
        for (Order order : orders.getOrders()) {
            Map<String, Integer> menuMap = menu.getMenu();
            if (menuMap.containsKey(order.getFood())) {
                totalPrice += order.getQuantity() * menuMap.get(order.getFood());
            }
        }

        //크리스마스 세일 계산
        int christmatSale = 0;
        if (1 <= day && day <= 31) {
            christmatSale = 1000 + 100 * (day - 1);
        }

        //평일인지 주말인지 체크후 할인금액받기
        Map<Integer, String> chckCalender = calender.getCalender();
        chkDay(chckCalender.get(day));


        //달력에 별이 있으면 할인
        int totalStarSalePrice = 0;
        if (day % 7 == 3 || day == 25) {
            totalStarSalePrice = 1000;
        }

        //증정 이벤트
        String gift = null;
        if (totalPrice >= 120000) {
            gift = "샴페인";
        }

        //주문 리스트 생성
        List<String> orderList = new ArrayList<>();
        for (Order order : orders.getOrders()) {
            String print = order.getFood() +" "+order.getQuantity()+"개";
            orderList.add(print);
        }


        //플래너 클래스에 저장
        Planner planner = new Planner(orderList,totalPrice,gift,christmatSale,weekAndPrice,totalStarSalePrice);

        //출력
        StringBuilder sb = new StringBuilder();
        sb.append("12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!").append(SEPARATOR);
        sb.append("<주문 메뉴>").append(SEPARATOR);
        for (String str : planner.getOrderList()) {
            sb.append(str).append(SEPARATOR);
        }

        sb.append(SEPARATOR).append("<할인 전 총주문 금액>").append(SEPARATOR);
        sb.append(df.format(planner.getTotalPrice())).append("원").append(SEPARATOR);

        if (totalPrice < 10000) {
            sb.append(SEPARATOR).append("<증정 메뉴>").append(SEPARATOR)
                    .append("없음").append(SEPARATOR)
                    .append("<혜택 내역>").append(SEPARATOR)
                    .append("없음").append(SEPARATOR)
                    .append("<총혜택 금액>").append(SEPARATOR)
                    .append("0원").append(SEPARATOR);
        } else {
            sb.append(SEPARATOR).append("<증정 메뉴>").append(SEPARATOR);
            sb.append(planner.getGiftMenu()).append(SEPARATOR);
            sb.append(SEPARATOR).append("<혜택 내역>").append(SEPARATOR);
            sb.append("크리스마스 디데이 할인: -").append(df.format(planner.getChristmasSale())).append("원").append(SEPARATOR);
            sb.append(planner.getWeekSale()).append(": -").append(df.format(planner.getWeekSalePrice())).append("원").append(SEPARATOR);
            sb.append("특별 할인: -").append(df.format(planner.getSpecialSale())).append("원").append(SEPARATOR);
            sb.append("증정 이벤트: -").append(df.format(planner.getGiftEvent())).append("원").append(SEPARATOR);
            sb.append(SEPARATOR).append("<총혜택 금액>").append(SEPARATOR);
            sb.append("-").append(df.format(planner.getTotalSalePrice())).append("원").append(SEPARATOR);
        }

        sb.append(SEPARATOR).append("<할인 후 예상 결제 금액>").append(SEPARATOR);
        sb.append(df.format(planner.getAfterSaleTotalPrice())).append("원").append(SEPARATOR);
        sb.append(SEPARATOR).append("<12월 이벤트 배지>").append(SEPARATOR);
        sb.append(planner.getBadge());

        System.out.println(sb);
    }

    private static void chkDay(String day) {
        //주말 할인
        if (day.contains("토") || day.contains("일")) {
            weekAndPrice[0] = "주말할인";
            weekAndPrice[1] = String.valueOf(weekDaySale(day));
        }
        weekAndPrice[0] = "평일할인";
        weekAndPrice[1] = String.valueOf(weekDaySale(day));
    }

    int weekendSalePrice = 0;

    private static int weekendSale(String day) {
        int weekendTotalSalePrice = 0;
        for (Order order : orders.getOrders()) {
            if (order.getFood().equals("티본스테이크") || order.getFood().equals("바비큐립") || order.getFood()
                    .equals("해산물파스타")) {
                int oneOrderPrice = order.getQuantity() * 2023;
                weekendTotalSalePrice += oneOrderPrice;
            }
        }
        return weekendTotalSalePrice;
    }

    private static int weekDaySale(String day) {
        int weekDayTotalSalePrice = 0;
        for (Order order : orders.getOrders()) {
            if (order.getFood().equals("초코케이크") || order.getFood().equals("아이스크림")) {
                int oneOrderPrice = order.getQuantity() * 2023;
                weekDayTotalSalePrice += oneOrderPrice;
            }
        }
        return weekDayTotalSalePrice;
    }


}
