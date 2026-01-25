package bridge.service;

import bridge.domain.BridgeGame;
import bridge.dto.ResultDto;

public class BridgeService {

    private BridgeGame bridgeGame;

    public void registerBridgeSize(int bridgeSize) {
        bridgeGame = new BridgeGame(bridgeSize);
    }

    public void move(String moving) {
        bridgeGame.move(moving);
    }

    public ResultDto getResult() {
        return bridgeGame.getResult();
    }

    public void reset() {
        bridgeGame.retry();
    }

    public boolean isGameOver() {
        return bridgeGame.isGameOver();
    }
}
