package christmas;

public record OrderRequestDto(Menu menu, Integer quantity) {
    static OrderRequestDto of(Menu menu, Integer quantity) {
        return new OrderRequestDto(menu, quantity);
    }
}
