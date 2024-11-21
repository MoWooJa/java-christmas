package christmas;

import christmas.Benefit.Badge;
import christmas.Benefit.Benefit;
import java.util.List;


public class OrderResult {
    private final December visitDay;
    private final int totalPrice;
    private final List<OrderRequestDto> orderRequests;
    private final Benefit benefit;
    private final int discountPrice;
    private final Badge badge;
    private final int finalPrice;


    public OrderResult(Orders orders, Benefit benefit) {
        this.totalPrice = orders.getTotalPrice();
        this.visitDay = orders.getVisitDay();
        this.orderRequests = orders.getOrderRequests();
        this.benefit = benefit;
        this.discountPrice = discountPrice(orders, benefit);
        this.badge = Badge.of(discountPrice);
        this.finalPrice = calculateFinalPrice(discountPrice, totalPrice);
    }

    public int discountPrice(Orders orders, Benefit benefit) {
        if (benefit == null) {
            return 0;
        }
        int specialBenefit = benefit.getSpecialBenefit().getDiscountPrice();
        int weekendBenefit = benefit.getWeekendBenefit().getDiscountPrice();
        int xmasBenefit = benefit.getXmasBenefit().getDiscountPrice();
        int weekDayBenefit = benefit.getWeekDayBenefit().getDiscountPrice();
        int freeBenefit = benefit.getFreeBenefit().getDiscountPrice();
        return specialBenefit + weekendBenefit + xmasBenefit + weekDayBenefit + freeBenefit;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public int calculateFinalPrice(int discountPrice, int totalPrice) {
        return totalPrice - discountPrice;
    }

    public int getFinalPrice() {
        return finalPrice;
    }

    public Badge getBadge() {
        return badge;
    }

    public Benefit getBenefit() {
        return benefit;
    }

    public December getVisitDay() {
        return visitDay;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public List<OrderRequestDto> getOrderRequests() {
        return orderRequests;
    }
}
