package bridge.view;

import bridge.constant.FinalResult;
import bridge.dto.ResultDto;
import java.util.List;

public class OutputView {

    private static final String PREFIX = "[ ";
    private static final String SUFFIX = " ]";
    private static final String DELIMITER = " | ";
    private static final String START = "다리 건너기 게임을 시작합니다.\n";
    private static final String GAME_RESULT = "최종 게임 결과";
    private static final String FINAL_RESULT = "게임 성공 여부: ";
    private static final String TRY_COUNT = "총 시도한 횟수: ";

    public static void printStart() {
        System.out.println(START);
    }

    public static void printMap(ResultDto resultDto) {
        List<String> upBridge = resultDto.getUpBridge();
        List<String> downBridge = resultDto.getDownBridge();

        String[] up = upBridge.toArray(new String[0]);
        String[] down = downBridge.toArray(new String[0]);

        System.out.println(PREFIX + String.join(DELIMITER, up) + SUFFIX);
        System.out.println(PREFIX + String.join(DELIMITER, down) + SUFFIX);
    }

    public static void printResult(ResultDto finalResult) {
        int tryCount = finalResult.getTryCount();
        FinalResult result = finalResult.getFinalResult();

        System.out.println(GAME_RESULT);
        printMap(finalResult);
        System.out.println(FINAL_RESULT + result.getResult());
        System.out.println(TRY_COUNT + tryCount);
        System.out.println();
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
