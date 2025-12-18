package bridge.controller;

import bridge.domain.BridgeRandomNumberGenerator;
import bridge.service.BridgeGame;
import bridge.service.BridgeMaker;
import bridge.util.InputHandler;
import bridge.view.InputView;
import java.util.List;

public class BridgeGameController {
    private static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";

    public void run(){
        InputView inputView = new InputView();
        BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(generator);

        System.out.println(GAME_START_MESSAGE);
        System.out.println();
        // 다리 길이 입력 받기
        int bridgeSize = InputHandler.retry(InputView::readBridgeSize);

        // 다리 생성
        List<String> bridgeList = bridgeMaker.makeBridge(bridgeSize);

        // 게임 생성
        BridgeGame game = new BridgeGame(bridgeList);

        //게임 실행
        game.run();
    }
}
