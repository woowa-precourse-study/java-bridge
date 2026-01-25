package bridge.constant;

public enum ErrorMessage {

    BRIDGE_SIZE_ERROR("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    MOVING_ERROR("이동할 칸은 U 또는 D 이어야 합니다."),
    COMMAND_ERROR("R 또는 Q 이어야 합니다."),
    ;

    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage(Object... args) {
        return ERROR_MESSAGE_PREFIX + String.format(errorMessage, args);
    }

}
