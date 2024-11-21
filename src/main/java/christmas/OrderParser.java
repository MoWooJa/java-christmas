package christmas;

import static christmas.Exceptions.INVALID_ORDER;

import java.util.ArrayList;
import java.util.List;

public class OrderParser {

    public List<OrderRequestDto> parseOrder(String input) {
        String[] splitInput = input.split(",");
        List<OrderRequestDto> orderRequests = new ArrayList<>();

        for (String s : splitInput) {
            String[] orderRequest = s.split("-");

            if (2 != orderRequest.length) {
                throw new IllegalArgumentException(INVALID_ORDER.getMessage());
            }
            int quantity;
            try {
                quantity = Integer.parseInt(orderRequest[1]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(INVALID_ORDER.getMessage());
            }
            if (quantity < 1) {
                throw new IllegalArgumentException(INVALID_ORDER.getMessage());
            }
            Menu menu = Menu.of(orderRequest[0]);

            OrderRequestDto order = OrderRequestDto.of(menu, quantity);
            orderRequests.add(order);
        }
        return orderRequests;
    }

}
