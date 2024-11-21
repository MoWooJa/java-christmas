package christmas;

import static christmas.Exceptions.INVALID_DAY;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {

    private final OrderParser orderParser;

    private final InputValidator inputValidator;

    public InputView(OrderParser orderParser, InputValidator inputValidator) {
        this.orderParser = orderParser;
        this.inputValidator = inputValidator;
    }

    public December getVisitDay() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        String input = Console.readLine();
        try {
            int visitDay = Integer.parseInt(input);
            return December.of(visitDay);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_DAY.getMessage());
        }
    }

    public List<OrderRequestDto> getMenuAndQuantity() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        String input = Console.readLine();
        List<OrderRequestDto> orderRequests = orderParser.parseOrder(input);
        inputValidator.validateOrderRequest(orderRequests);
        return orderRequests;
    }
}
