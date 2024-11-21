package christmas.Benefit;

import christmas.December;

public class SpecialBenefit {
    private final int discountPrice;

    public SpecialBenefit(December visitDay) {
        this.discountPrice = discountPrice(visitDay);
    }

    private int discountPrice(December visitDay) {
        if (isSpecialDay(visitDay)) {
            return 1000;
        }
        return 0;
    }

    public boolean isSpecialDay(December visitDay) {
        return visitDay.isStartStatus();
    }

    public int getDiscountPrice() {
        return discountPrice;
    }
}
