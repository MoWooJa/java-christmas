package christmas.event;

import christmas.Menu;
import christmas.MenuCategory;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WeekdayEvent {
    //2023.12.1 ~ 2023.12.31 동안 적용
    //평일에는 디저트 메뉴를 메뉴 1개당 2,023원 할인

    private static boolean canDiscount(int date) {
        List<Integer> discountDays = new ArrayList<>(List.of(
                3, 4, 5, 6, 7,
                10, 11, 12, 13, 14,
                17, 18, 19, 20, 21,
                24, 25, 26, 27, 28,
                31
        ));
        return discountDays.contains(date);
    }

    public static int discountPrice(int date, EnumMap<Menu, Integer> orderItems) {
        if (canDiscount(date)) {
            int discount = 0;
            for (Map.Entry<Menu, Integer> entry : orderItems.entrySet()) {
                if (entry.getKey().getCategory().equals(MenuCategory.DESSERT)) {
                    discount += entry.getValue() * 2023;
                }
            }
            return discount;
        }
        return 0;
    }


}
