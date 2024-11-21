package christmas.Benefit;

import christmas.December;
import christmas.MenuCategory;
import christmas.OrderRequestDto;
import christmas.Orders;

public class WeekDayBenefit {

    private final int discountPrice;

    public WeekDayBenefit(Orders orders, December visitDay) {
        this.discountPrice = discountPrice(orders, visitDay);
    }

    public int discountPrice(Orders orders, December visitDay) {
        if (!isWeekDay(visitDay)) {
            return 0;
        }
        int discount = 0;
        for (OrderRequestDto orderRequest : orders.getOrderRequests()) {
            if (orderRequest.menu().getMenuCategory() == MenuCategory.DESERT) {
                discount += 2023;
            }
        }
        return discount;
    }


    public boolean isWeekDay(December visitDay) {
        return !visitDay.isWeekendStatus();
    }

    public int getDiscountPrice() {
        return discountPrice;
    }
}
