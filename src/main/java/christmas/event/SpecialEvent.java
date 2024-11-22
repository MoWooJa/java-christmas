package christmas.event;

import java.util.ArrayList;
import java.util.List;

public class SpecialEvent {
    //2023.12.1 ~ 2023.12.31 동안 적용

    private static boolean canDiscount(int date) {
        List<Integer> specialDays = new ArrayList<>(List.of(3,10,17,24,25,31));
        return specialDays.contains(date);
    }

    public static int discountPrice(int date) {
        if (canDiscount(date)) {
            return 1000;
        }
        return 0;
    }
}
