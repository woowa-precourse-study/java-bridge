package bridge.util;

import static bridge.exception.ErrorMessage.NOT_A_NUMBER;

public class NumberParser {
    private NumberParser() {
    }

    public static int parse(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_A_NUMBER.getMessage());
        }
    }
}
