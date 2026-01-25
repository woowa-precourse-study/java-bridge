package bridge.util;

import static bridge.constant.ErrorMessage.BRIDGE_SIZE_ERROR;

public final class NumberConverter {

    public static Integer convertToNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(BRIDGE_SIZE_ERROR.getErrorMessage());
        }
    }
}
