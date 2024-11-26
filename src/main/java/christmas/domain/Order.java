package christmas.domain;


public class Order {

    private int day;
    private String food;
    private int quantity;

    public Order(int day, String food, int quantity) {
        this.day = day;
        this.food = food;
        this.quantity = quantity;
    }

    public String getFood() {
        return food;
    }
    public int getQuantity() {
        return quantity;
    }
}
