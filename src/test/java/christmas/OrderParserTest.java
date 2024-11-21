package christmas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class OrderParserTest {

    OrderParser orderParser = new OrderParser();

    @Test
    void parseOrder() {
        String input = "해산물파스타-2,레드와인-1,초코케이크-1";
        List<OrderRequestDto> orderRequestDtos = orderParser.parseOrder(input);
        System.out.println(orderRequestDtos);
    }
}