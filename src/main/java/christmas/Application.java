package christmas;

public class Application {
    public static void main(String[] args) {
        MainController mainController = MainFactory.mainController();
        mainController.run();
    }
}
