package christmas.Benefit;

import christmas.December;
import christmas.MenuCategory;
import christmas.OrderRequestDto;
import christmas.Orders;

public class WeekendBenefit {

    private final int discountPrice;

    public WeekendBenefit(Orders orders, December visitDay) {
        this.discountPrice = discountPrice(orders, visitDay);
    }

    public int discountPrice(Orders orders, December visitDay) {
        if (!isWeekend(visitDay)) {
            return 0;
        }
        int discount = 0;
        for (OrderRequestDto orderRequest : orders.getOrderRequests()) {
            if (orderRequest.menu().getMenuCategory() == MenuCategory.MAIN) {
                discount += 2023;
            }
        }
        return discount;
    }

    public boolean isWeekend(December visitDay) {
        return visitDay.isWeekendStatus();
    }

    public int getDiscountPrice() {
        return discountPrice;
    }
}
