package bridge;

public interface Validator {
    void validate(String input);
    /**
     * 검증 관련 메서드
     * 검증이 추가되면 아래에 추가하기
     * **/

    static void validateNotBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("빈 값은 입력할 수 없습니다.");
        }
    }

    static void validateIsNumber(String input) {
        try{
            Integer.parseInt(input);
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    static void validateRange(String input, int min, int max) {
        int value = Integer.parseInt(input);
        if (value < min || value > max) {
            throw new IllegalArgumentException(min + "부터 " + max + " 사이의 숫자만 입력 가능합니다.");
        }
    }

    static void validateMove(String input) {
        if (!(input.equals("U") || input.equals("D"))) {
            throw new IllegalArgumentException("U와 D중 하나를 입력해야합니다.");
        }
    }

    static void validateRestart(String input) {
        if (!(input.equals("R") || input.equals("Q"))) {
            throw new IllegalArgumentException("R와 Q중 하나를 입력해야합니다.");
        }
    }
}


