package bridge;

import bridge.domain.BridgeRandomNumberGenerator;
import bridge.service.BridgeGame;
import bridge.service.BridgeMaker;
import bridge.view.InputView;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(generator);

        // 다리 길이 입력 받기
        int bridgeSize = inputView.readBridgeSize();

        // 다리 생성
        List<String> bridgeList = bridgeMaker.makeBridge(bridgeSize);

        // 게임 생성
        BridgeGame game = new BridgeGame(bridgeList);

        //게임 실행
        game.run();
    }
}
