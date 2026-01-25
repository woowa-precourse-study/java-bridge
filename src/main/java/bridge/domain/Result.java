package bridge.domain;

import bridge.constant.Constant;
import bridge.constant.FinalResult;
import bridge.constant.MovingResult;
import bridge.dto.ResultDto;
import java.util.ArrayList;
import java.util.List;

public class Result {

    private static final String SUCCESS_MARK = "O";
    private static final String FAIL_MARK = "X";
    private static final String EMPTY_MARK = " ";

    private final List<String> upBridge;
    private final List<String> downBridge;
    private FinalResult finalResult;

    public Result() {
        this.upBridge = new ArrayList<>();
        this.downBridge = new ArrayList<>();
    }

    public void updateState(String moving, MovingResult movingResult) {
        if (movingResult.equals(MovingResult.SUCCESS) && moving.equals(Constant.UP)) {
            upBridge.add(SUCCESS_MARK);
            downBridge.add(EMPTY_MARK);
            finalResult = FinalResult.WIN;
            return;
        }

        if (movingResult.equals(MovingResult.SUCCESS) && moving.equals(Constant.DOWN)) {
            upBridge.add(EMPTY_MARK);
            downBridge.add(SUCCESS_MARK);
            finalResult = FinalResult.WIN;
            return;
        }

        if (movingResult.equals(MovingResult.FAIL) && moving.equals(Constant.UP)) {
            upBridge.add(FAIL_MARK);
            downBridge.add(EMPTY_MARK);
            finalResult = FinalResult.LOSE;
            return;
        }

        upBridge.add(EMPTY_MARK);
        downBridge.add(FAIL_MARK);
        finalResult = FinalResult.LOSE;
    }

    public ResultDto getResult(int tryCount) {
        return new ResultDto(upBridge, downBridge, tryCount, finalResult);
    }
}
