package bridge.service;

import bridge.domain.BridgeGame;
import bridge.utils.BridgeNumberGenerator;
import bridge.utils.BridgeRandomNumberGenerator;

public class Service {
    public BridgeGame getBridgeGame(int size){
        BridgeNumberGenerator bridgeNumberGenerator= new BridgeRandomNumberGenerator();
        return new BridgeGame(bridgeNumberGenerator,size);
    }

    public void retryGame(BridgeGame bridgeGame){
        bridgeGame.retry();
    }
}
