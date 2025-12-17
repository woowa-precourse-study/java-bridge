package bridge.factory;

import bridge.controller.BridgeController;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeNumberGenerator;
import bridge.domain.GameResult;
import bridge.domain.numbergenerator.BridgeRandomNumberGenerator;
import java.util.List;

public class ApplicationFactory {
    public BridgeController controller() {
        return new BridgeController(bridgeMaker(), gameResult());
    }

    private GameResult gameResult() {
        return new GameResult(List.of(), true);
    }

    public BridgeMaker bridgeMaker() {
        return new BridgeMaker(numberGenerator());
    }

    public BridgeNumberGenerator numberGenerator() {
        return new BridgeRandomNumberGenerator();
    }
}
