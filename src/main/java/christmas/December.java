package christmas;

import static christmas.Exceptions.INVALID_ORDER;

public enum December {
    ONE(1, false, true, false),
    TWO(2, false, true, false),
    THREE(3, true, false, false),
    FOUR(4, false, false, false),
    FIVE(5, false, false, false),
    SIX(6, false, false, false),
    SEVEN(7, false, false, false),
    EIGHT(8, false, true, false),
    NINE(9, false, true, false),
    TEN(10, true, false, false),
    ELEVEN(11, false, false, false),
    TWELVE(12, false, false, false),
    THIRTEEN(13, false, false, false),
    FOURTEEN(14, false, false, false),
    FIFTEEN(15, false, true, false),
    SIXTEEN(16, false, true, false),
    SEVENTEEN(17, true, false, false),
    EIGHTEEN(18, false, false, false),
    NINETEEN(19, false, false, false),
    TWENTY(20, false, false, false),
    TWENTY_ONE(21, false, false, false),
    TWENTY_TWO(22, false, true, false),
    TWENTY_THREE(23, false, true, false),
    TWENTY_FOUR(24, true, false, false),
    TWENTY_FIVE(25, true, false, true),
    TWENTY_SIX(26, false, false, false),
    TWENTY_SEVEN(27, false, false, false),
    TWENTY_EIGHT(28, false, false, false),
    TWENTY_NINE(29, false, true, false),
    THIRTY(30, false, true, false),
    THIRTY_ONE(31, true, true, false);


    private final int day;

    private final boolean startStatus;

    private final boolean weekendStatus;

    private final boolean xmasStatus;

    December(int day, boolean startStatus, boolean weekendStatus, boolean xmasStatus) {
        this.day = day;
        this.startStatus = startStatus;
        this.weekendStatus = weekendStatus;
        this.xmasStatus = xmasStatus;
    }

    public static December of(Integer day) {
        for (December december :December.values()) {
            if (december.day == day) {
                return december;
            }
        }
        throw new IllegalArgumentException(INVALID_ORDER.getMessage());
    }

    public boolean isXmasStatus() {
        return xmasStatus;
    }

    public boolean isWeekendStatus() {
        return weekendStatus;
    }

    public boolean isStartStatus() {
        return startStatus;
    }

    public int getDay() {
        return day;
    }
}
