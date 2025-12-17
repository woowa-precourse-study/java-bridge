package bridge.exception;

public enum ErrorMessage {
    NOT_VALID_BRIDGE_SIZE("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    NOT_A_NUMBER("숫자가 아닙니다."),
    NOT_VALID_MOVE("잘못된 입력입니다."),
    NOT_VALID_COMMAND("잘못된 입력입니다.");

    private static final String ERROR_PREFIX = "[ERROR] ";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}
