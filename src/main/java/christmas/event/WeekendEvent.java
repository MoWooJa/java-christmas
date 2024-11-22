package christmas.event;

import christmas.Menu;
import christmas.MenuCategory;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WeekendEvent {
    //2023.12.1 ~ 2023.12.31 동안 적용
    //주말에는 메인 메뉴를 메뉴 1개당 2,023원 할인
    private static boolean canDiscount(int date) {
        List<Integer> discountDays = new ArrayList<>(List.of(
                    1, 2,
                    8, 9,
                    15, 16,
                    22, 23,
                    29, 30
            ));
        return discountDays.contains(date);
    }
    public static int discountPrice(int date, EnumMap<Menu,Integer> order) {
        if (canDiscount(date)) {
            int discount = 0;
            for (Map.Entry<Menu, Integer> entry : order.entrySet()) {
                if (entry.getKey().getCategory().equals(MenuCategory.MAIN)) {
                    discount += entry.getValue() * 2023;
                }
            }
            return discount;
        }
        return 0;
    }
}
