package bridge.domain;

import bridge.dto.ResultDto;
import bridge.generator.BridgeMaker;
import bridge.generator.BridgeRandomNumberGenerator;
import bridge.constant.MovingResult;

public class BridgeGame {

    private final Bridge bridge;
    private int tryCount;
    private Result result;

    public BridgeGame(int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
        tryCount = 1;
        result = new Result();
    }

    public void move(String moving) {
        if (bridge.isSuccessMoving(moving)) {
            result.updateState(moving, MovingResult.SUCCESS);
            return;
        }

        result.updateState(moving, MovingResult.FAIL);
    }

    public void retry() {
        tryCount++;
        bridge.resetPosition();
        result = new Result();
    }

    public ResultDto getResult() {
        return result.getResult(tryCount);
    }

    public boolean isGameOver() {
        return bridge.isLastMoving();
    }
}
