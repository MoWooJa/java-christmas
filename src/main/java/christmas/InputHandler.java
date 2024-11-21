package christmas;

import java.util.List;
import java.util.function.Supplier;

public class InputHandler {

    private final InputView inputView;

    public InputHandler(InputView inputView) {
        this.inputView = inputView;
    }

    public December askVisitDay() {
        return handle(inputView::getVisitDay);
    }

    public List<OrderRequestDto> askManuAndQuantity() {
        return handle(inputView::getMenuAndQuantity);
    }


    private <T> T handle(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
