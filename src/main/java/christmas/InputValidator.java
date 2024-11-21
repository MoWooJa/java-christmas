package christmas;

import static christmas.Exceptions.INVALID_DAY;

public class InputValidator {

    public Integer validateVisitDay(String input) {
        Integer day;

        try {
            day = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_DAY.getMessage());
        }

        if (day < 1 || day > 31) {
            throw new IllegalArgumentException(INVALID_DAY.getMessage());
        }

        return day;
    }
}
