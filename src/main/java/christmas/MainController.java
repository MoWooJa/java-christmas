package christmas;

public class MainController {
    private final OrderController orderController;

    private final PlannerController plannerController;

    public MainController(OrderController orderController, PlannerController plannerController) {
        this.orderController = orderController;
        this.plannerController = plannerController;
    }

    public void run() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
        OrderResult order = orderController.order();
        plannerController.printPlanner(order);
    }
}
