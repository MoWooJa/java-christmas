package christmas;

public class MainFactory {
    public static MainController mainController() {
        return new MainController(orderController(), plannerController());
    }

    private static OrderController orderController() {
        return new OrderController(orderCreator(), inputHandler());
    }

    private static OrderCreator orderCreator() {
        return new OrderCreator();
    }

    private static InputHandler inputHandler() {
        return new InputHandler(inputView());
    }

    private static InputView inputView() {
        return new InputView(orderParser(), inputValidator());
    }

    private static OrderParser orderParser() {
        return new OrderParser();
    }

    private static InputValidator inputValidator() {
        return new InputValidator();
    }

    private static PlannerController plannerController() {
        return new PlannerController(outputView());
    }

    private static OutputView outputView() {
        return new OutputView();
    }
}
