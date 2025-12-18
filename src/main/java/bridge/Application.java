package bridge;

import bridge.domain.BridgeRandomNumberGenerator;
import bridge.service.BridgeGame;
import bridge.service.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(generator);

        // 다리 길이 입력 받기
        int bridgeSize = inputView.readBridgeSize();

        // 다리 생성
        List<String> bridgeList = bridgeMaker.makeBridge(bridgeSize);


        // 게임 생성

        BridgeGame game = new BridgeGame(bridgeList);
        int currentIndex = 0;
        int tryCount = 1;

        // 게임 루프 실행
        while(currentIndex < bridgeSize){
            // 라운드 진행
            String movingInput = inputView.readMoving();
            String result = game.checkMoveable(movingInput);
            game.move(movingInput, result);
            currentIndex++;

            ArrayList<String>[] midResult = game.getMoveResult();

            // 중간 출력
            outputView.printMap(midResult);

            if(result.equals("X")){
                String command = inputView.readGameCommand();
                if(command.equals("Q")){
                    outputView.printResult(midResult,bridgeSize,tryCount,currentIndex);
                    return;
                }
                game.retry();
                currentIndex--;
                tryCount++;
            }
        }
        ArrayList<String>[] result = game.getMoveResult();
        outputView.printResult(result,bridgeSize,tryCount, currentIndex);
    }
}
