package christmas.event;

public class ChristmasEvent {
    /**
     * 2023.12.1 ~ 2023.12.25
     * 1,000원으로 시작하여 크리스마스가 다가올수록 날마다 할인 금액이 100원씩 증가
     * 총주문 금액에서 해당 금액만큼 할인
     * (e.g. 시작일인 12월 1일에 1,000원,2일에 1,100원, ..., 25일엔 3,400원 할인)
     */

    public static int discountPrice(int date) {
        if (canDiscount(date)) {
            int discount = 1000;
            int discountDateCount = date-1;
            int discountUnit = 100;
            return discount + (discountDateCount * discountUnit);
        }
        return 0;

    }
    private static boolean canDiscount(int date) {
        return date >= 1 && date <= 25;
    }


}
