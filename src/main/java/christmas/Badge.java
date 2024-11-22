package christmas;

public enum Badge {
    STAR("별"),
    TREE("트리"),
    SANTA("산타"),
    NONE("없음");

    private String name;

    public String getName() {
        return name;
    }

    Badge(String name) {
        this.name = name;
    }

    public static Badge receiveBadge(int totalBenefitAmount) {
        if (totalBenefitAmount >= 20000) {
            return SANTA;
        }
        if (totalBenefitAmount >= 10000) {
            return TREE;
        }
        if (totalBenefitAmount >= 5000) {
            return STAR;
        }
        return NONE;
    }
}
