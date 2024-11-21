package christmas.Benefit;

public enum Badge {
    SANTA("산타", 20000),
    TREE("트리", 10000),
    STAR("별", 5000),
    NONE("없음", 0);

    private final String name;

    private final int price;

    Badge(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public static Badge of(int discountPrice) {
        for (Badge badge : Badge.values()) {
            if (discountPrice >= badge.price) {
                return badge;
            }
        }
        return NONE;
    }
}
