package bridge.factory;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import java.util.List;

public class BridgeFactory {
    private BridgeFactory() {
    }

    public static BridgeGame createGame(List<String> bridge) {
        return new BridgeGame(new Bridge(bridge));
    }
}
