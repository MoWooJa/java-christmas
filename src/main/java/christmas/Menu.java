package christmas;

import static christmas.Exceptions.INVALID_ORDER;
import static christmas.MenuCategory.APPETIZER;
import static christmas.MenuCategory.DESERT;
import static christmas.MenuCategory.DRINK;
import static christmas.MenuCategory.MAIN;

public enum Menu {
    SOUP(APPETIZER, "양송이수프", 6000),
    TAPAS(APPETIZER, "타파스", 5500),
    SALAS(APPETIZER, "시저샐러드", 8000),

    CAKE(DESERT, "초코케이크", 15000),

    ICE_CREAM(DESERT, "아이스크림", 5000),

    COKE(DRINK, "제로콜라", 3000),

    WINE(DRINK, "레드와인", 60000),

    CHAMPAGNE(DRINK, "샴페인", 25000),

    STEAK(MAIN, "티본스테이크", 55000),

    RIBS(MAIN, "바비큐립", 54000),

    SEA_FOOD_PASTA(MAIN, "해산물파스타", 35000),

    CHRIST_PASTA(MAIN, "크리스마스파스타", 25000);



    private final MenuCategory menuCategory;

    private final String name;

    private final int price;

    Menu(MenuCategory menuCategory, String name, int price) {
        this.menuCategory = menuCategory;
        this.name = name;
        this.price = price;
    }

    public static Menu of(String name) {
        for (Menu menu : Menu.values()) {
            if (menu.name.equals(name)) {
                return menu;
            }
        }
        throw new IllegalArgumentException(INVALID_ORDER.getMessage());
    }

    public MenuCategory getMenuCategory() {
        return menuCategory;
    }

    public int getPrice() {
        return price;
    }
}
