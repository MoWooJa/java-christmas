package christmas.model;

import java.util.Set;

public class Date {

    public static final int SATURDAY_MOD = 2;
    public static final int FRIDAY_MOD = 1;
    public static final int WEEKDAY = 7;
    public static final int D_DAY = 25;
    private static final Set<Integer> STAR_DAYS = Set.of(3, 10, 17, 24, 31, 25);

    private final int date;

    public Date(int date) {
        this.date = date;
    }

    public boolean isWeekend() {
        return date % WEEKDAY == FRIDAY_MOD || date % 7 == SATURDAY_MOD;
    }

    public int howMuchDiscountDdayEvent() {
        if (date <= D_DAY) {
            return 1000 + ((date - 1) * 100);
        }
        return 0;
    }

    public int specialDiscount() {
        if (STAR_DAYS.contains(date)) {
            return 1000;
        }
        return 0;
    }
}
