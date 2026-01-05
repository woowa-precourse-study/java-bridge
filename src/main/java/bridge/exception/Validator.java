package bridge.exception;

public interface Validator {
    void validate(String input);


    static void validateNotBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 빈 값은 입력할 수 없습니다.");
        }
    }

    static int validateIsNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다.");
        }
    }

    static void validateRange(String input) {
        int min = 3;
        int max = 20;
        int value = validateIsNumber(input);
        if (value < min || value > max) {
            throw new IllegalArgumentException("[ERROR] "+min + "부터 " + max + " 사이의 숫자만 입력 가능합니다.");
        }
    }

}
