package christmas.Benefit;

public class FreeBenefit {
    private final int discountPrice;

    public FreeBenefit(int totalPrice) {
        this.discountPrice = isFree(totalPrice);
    }

    public int isFree(int totalPrice) {
        if (totalPrice >= 120000) {
            return 25000;
        }
        return 0;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }
}
