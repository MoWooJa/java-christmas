package christmas.Benefit;

import christmas.December;

public class XmasBenefit {
    private final int discountPrice;

    public XmasBenefit(December visitDay) {
        this.discountPrice = calculateDiscountPrice(visitDay.getDay());
    }

    public boolean isInXmasBenefit(int visitDay) {
        return visitDay >= 1 && visitDay <= 25;
    }

    public int calculateDiscountPrice(int visitDay) {
        if (isInXmasBenefit(visitDay)) {
            return 0;
        }
        int discount = 1000;
        for (int i = 1; i <= visitDay; i++) {
            discount += 100;
        }
        return discount;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }
}
