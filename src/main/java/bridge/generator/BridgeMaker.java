package bridge.generator;

import bridge.constant.Constant;
import bridge.domain.Bridge;
import java.util.ArrayList;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int num = bridgeNumberGenerator.generate();
            if (num == 0) {
                bridge.add(Constant.DOWN);
                continue;
            }

            if (num == 1) {
                bridge.add(Constant.UP);
            }
        }

        return bridge;
    }
}
