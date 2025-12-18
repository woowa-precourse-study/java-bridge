package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeController {
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        int num = inputView.readBridgeSize();
        int times = 0;
        List<String> moveUp = new ArrayList<>();
        List<String> moveDown = new ArrayList<>();
        BridgeGame bridgeGame = new BridgeGame(num);
        String success = "";

        while (true) {
            bridgeGame.retry();
            times += 1;
            List<String> result = playOneRound(bridgeGame);
            success = result.get(0);
            moveUp = bridgeGame.getMoveUp();
            moveDown = bridgeGame.getMoveDown();

            if (success.equals("성공") || result.get(1).equals("Restart")) {
                break;
            }
        }
        outputView.printResult(moveUp, moveDown, success, times);

    }

    public List<String> playOneRound(BridgeGame bridgeGame) {
        int idx = 0;
        String result = "성공";
        String isRestart = "Quit";
        while (!bridgeGame.isFull()) {
            String move = inputView.readMoving();
            bridgeGame.move(move, idx);
            if (!bridgeGame.isFull()) {
                outputView.printMap(bridgeGame.getMoveUp(), bridgeGame.getMoveDown());
            }

            if (bridgeGame.userCorrect(move, idx).equals("X")) {
                result = "실패";
                isRestart = inputView.readGameCommand();
                break;
            }

            idx += 1;
        }
        return List.of(result, isRestart);
    }
}
