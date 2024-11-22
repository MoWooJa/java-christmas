package christmas;

import java.util.Arrays;
import java.util.EnumMap;

public class Parser {

    private static final String DELIMITE = ",";

    public static EnumMap<Menu, Integer> parse(String menu) {
        EnumMap<Menu, Integer> orderItems = new EnumMap<>(Menu.class);
        Arrays.stream(menu.split(DELIMITE))
                .map(item -> item.split("-"))
                .forEach(parts -> {
                    Menu menuItem = Menu.findMenuByMatching(parts[0]);
                    int quantity = Integer.parseInt(parts[1]);

                    orderItems.put(menuItem, orderItems.getOrDefault(menuItem, 0) + quantity);
                });

        return orderItems;

    }
}
