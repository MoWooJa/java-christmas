package christmas;

import christmas.Benefit.Benefit;
import java.util.List;

public class OrderController {
    private final OrderCreator orderCreator;
    private final InputHandler inputHandler;

    public OrderController(OrderCreator orderCreator, InputHandler inputHandler) {
        this.orderCreator = orderCreator;
        this.inputHandler = inputHandler;
    }

    public OrderResult order() {
        December visitDay = inputHandler.askVisitDay();
        List<OrderRequestDto> orderRequests = inputHandler.askManuAndQuantity();
        Orders orders = orderCreator.create(visitDay, orderRequests);
        Benefit benefit = orderCreator.applyBenefit(orders, visitDay);
        return new OrderResult(orders, benefit);
    }
}
