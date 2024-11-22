package christmas.event;

public class FreeItemEvent {
    //2023.12.1 ~ 2023.12.31 동안 적용

    private static boolean canFreeItem(int sumAllItemsPrice) {
        return sumAllItemsPrice >= 120000;
    }

    public static int discountPrice(int sumAllItemsPrice) {
        if (canFreeItem(sumAllItemsPrice)) {
            return 25000;
        }
        return 0;
    }
}
