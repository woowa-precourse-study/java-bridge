package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    static String PREFIX_ERROR = "[ERROR] ";
    static final int MAX_RETRY = 10;

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        int num = 0;
        try {
            System.out.println("다리의 길이를 입력해주세요.");
            // 숫자 입력
            String number = readInputWithRetry(List.of(
                    Validator::validateNotBlank,
                    Validator::validateIsNumber,
                    input -> Validator.validateRange(input, 3, 20)
            ));
            num = Integer.parseInt(number);
        } catch (IllegalArgumentException | NoSuchElementException e) { // 입력안함은 여기서 자동 제거
            System.out.println(PREFIX_ERROR + e.getMessage());
        }
        return num;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String move = "";
        try {
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            // 숫자 입력
            move = readInputWithRetry(List.of(
                    Validator::validateNotBlank,
                    Validator::validateMove
            ));

        } catch (IllegalArgumentException | NoSuchElementException e) { // 입력안함은 여기서 자동 제거
            System.out.println(PREFIX_ERROR + e.getMessage());
        }
        return move;
    }


    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        try {
            System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
            // 숫자 입력
            String move = readInputWithRetry(List.of(
                    Validator::validateNotBlank,
                    Validator::validateRestart
            ));
            if (move.equals("R")) {
                return "Restart";
            }

        } catch (IllegalArgumentException | NoSuchElementException e) { // 입력안함은 여기서 자동 제거
            System.out.println(PREFIX_ERROR + e.getMessage());
        }
        return "Quit";
    }


    private String readInput(List<Validator> validators) {
        String input = Console.readLine();
        System.out.println(input);
        for (Validator v : validators) {
            v.validate(input);
        }
        return input;
    }


    private String readInputWithRetry(List<Validator> validators) {
        int retry = 0;
        while (true) {
            try {
                return readInput(validators);
            } catch (IllegalArgumentException | NoSuchElementException e) {
                retry++;
                System.out.println(PREFIX_ERROR + e.getMessage());

                if (retry >= MAX_RETRY) {
                    throw new IllegalStateException("입력 횟수를 초과했습니다.");
                }
            }
        }
    }
}
