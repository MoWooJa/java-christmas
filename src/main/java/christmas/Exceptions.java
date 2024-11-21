package christmas;

public enum Exceptions {

    INVALID_DAY("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");

    private final String message;

    Exceptions(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
