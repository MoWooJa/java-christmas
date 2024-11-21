package christmas;

public class PlannerController {
    private final OutputView outPutView;


    public PlannerController(OutputView outPutView) {
        this.outPutView = outPutView;
    }

    public void printPlanner(OrderResult orderResult) {
        outPutView.print(orderResult);
    }
}
