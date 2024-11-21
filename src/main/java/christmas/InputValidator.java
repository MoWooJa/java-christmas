package christmas;

import static christmas.Exceptions.INVALID_DAY;
import static christmas.Exceptions.INVALID_ORDER;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    public Integer validateVisitDay(String input) {
        Integer day;

        try {
            day = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_DAY.getMessage());
        }

        if (day < 1 || day > 31) {
            throw new IllegalArgumentException(INVALID_DAY.getMessage());
        }

        return day;
    }

    public void validateOrderRequest(List<OrderRequestDto> orderRequests) {
        // 중복주문 안됨
        List<Menu> menus = new ArrayList<>();
        int totalQuantity = 0;
        int drinkCount = 0;
        for (OrderRequestDto orderRequest : orderRequests) {
            menus.add(orderRequest.menu());
            totalQuantity += orderRequest.quantity();
            if (orderRequest.menu().getMenuCategory() == MenuCategory.DRINK) {
                drinkCount += 1;
            }
        }
        Set<Menu> menuSet = new HashSet<>(menus);
        if (menus.size() != menuSet.size()) {
            throw new IllegalArgumentException(INVALID_ORDER.getMessage());
        }

        // 전체주문 개수 25이하
        if (totalQuantity > 20) {
            throw new IllegalArgumentException(INVALID_ORDER.getMessage());
        }

        // 음료만 주문 안 됨
        if (drinkCount == menus.size()) {
            throw new IllegalArgumentException(INVALID_ORDER.getMessage());
        }
    }
}
