package bridge.view;

import bridge.domain.GameResult;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String RESULT_START = "[";

    public static void printPrompt(String message) {
        System.out.println(message);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(GameResult result) {
        boolean success = result.isSuccess();

        List<String> gameResult = result.getResult();

        StringBuilder upperBuilder = new StringBuilder(RESULT_START);
        StringBuilder lowerBuilder = new StringBuilder(RESULT_START);

        convertResultToString(gameResult, success, upperBuilder, lowerBuilder);

        System.out.println(upperBuilder);
        System.out.println(lowerBuilder);
        System.out.println();
    }

    private static void convertResultToString(List<String> gameResult, boolean success, StringBuilder upperBuilder,
                                              StringBuilder lowerBuilder) {
        for (int i = 0; i < gameResult.size(); i++) {
            String each = gameResult.get(i);

            boolean eachSuccess = true;
            String delimter = "|";
            if (i == gameResult.size() - 1) {
                eachSuccess = success;
                delimter = "";
            }

            appendToBuilder(upperBuilder, lowerBuilder, each, eachSuccess, delimter);
        }
        upperBuilder.append("]");
        lowerBuilder.append("]");
    }

    private static void appendToBuilder(StringBuilder upperBuilder, StringBuilder lowerBuilder, String each,
                                        boolean eachSuccess, String delimter) {
        if (each.equals("U")) {
            upperBuilder.append(" ").append(printScreenResult(eachSuccess)).append(" ").append(delimter);
            lowerBuilder.append("   ").append(delimter);
            return;
        }

        upperBuilder.append("   ").append(delimter);
        lowerBuilder.append(" ").append(printScreenResult(eachSuccess)).append(" ").append(delimter);
    }

    private static String printScreenResult(boolean eachSuccess) {
        if (eachSuccess) {
            return "O";
        }

        return "X";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(GameResult result, int tries) {
        System.out.println(PrintMessage.GAME_RESULT);

        printMap(result);

        String success = "실패";
        if (result.isSuccess()) {
            success = "성공";
        }

        System.out.println();
        System.out.printf(PrintMessage.GAME_SUCCESS, success);
        System.out.printf(PrintMessage.TOTAL_TRIES, tries);
    }


    public static void printError(String message) {
        System.out.println(message);
    }
}
