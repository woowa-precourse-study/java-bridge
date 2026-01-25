package bridge.util;

import static bridge.constant.ErrorMessage.BRIDGE_SIZE_ERROR;
import static bridge.constant.ErrorMessage.COMMAND_ERROR;
import static bridge.constant.ErrorMessage.MOVING_ERROR;

public final class Validator {

    private static final String MOVING_FORMAT = "[UD]";
    private static final String COMMAND_FORMAT = "[RQ]";

    private Validator() {
    }

    public static void validateBridgeSize(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException(BRIDGE_SIZE_ERROR.getErrorMessage());
        }
    }

    public static void validateMoving(String moving) {
        if (!moving.matches(MOVING_FORMAT)) {
            throw new IllegalArgumentException(MOVING_ERROR.getErrorMessage());
        }
    }

    public static void validateCommand(String command) {
        if (!command.matches(COMMAND_FORMAT)) {
            throw new IllegalArgumentException(COMMAND_ERROR.getErrorMessage());
        }
    }
}
