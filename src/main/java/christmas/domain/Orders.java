package christmas.domain;

import java.util.ArrayList;
import java.util.List;

public class Orders {

    private List<Order> orders = new ArrayList<>();

    public void addOrders(Order order) {
        orders.add(order);
    }
}
