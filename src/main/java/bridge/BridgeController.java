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
        String gameResult = "";

        BridgeGame bridgeGame = new BridgeGame(num);

        while (true) {
            times += 1;
            List<String> copyAnswer = bridgeGame.retry();
            List<List<String>> result = playGame(num, copyAnswer);
            moveUp = result.get(1);
            moveDown = result.get(2);
            gameResult = result.get(0).get(0);

            if (gameResult.equals("성공") || gameResult.equals("Restart")) {
                break;
            }
        }
        outputView.printResult(moveUp, moveDown, gameResult, times);

    }


    public List<List<String>> playGame(int num, List<String> bridgeAnswer) {
        List<String> moveUp = new ArrayList<>();
        List<String> moveDown = new ArrayList<>();
        int idx = 0;
        String result = "성공";
        String isRestart = "Quit";
        while (moveUp.size() < num) {
            String move = inputView.readMoving();

            if (move.equals("U") && bridgeAnswer.get(idx).equals("U")) {
                moveUp.add("O");
                moveDown.add(" ");
            } else if (move.equals("U") && bridgeAnswer.get(idx).equals("D")) {
                moveUp.add("X");
                moveDown.add(" ");
                result = "실패";
                isRestart = inputView.readGameCommand();
                break;
            } else if (move.equals("D") && bridgeAnswer.get(idx).equals("D")) {
                moveUp.add(" ");
                moveDown.add("O");
            } else if (move.equals("D") && bridgeAnswer.get(idx).equals("U")) {
                moveUp.add(" ");
                moveDown.add("X");
                result = "실패";
                isRestart = inputView.readGameCommand();
                break;
            }
            if (moveUp.size() < num) {
                outputView.printMap(moveUp, moveDown);
            }
            idx += 1;

        }
        return List.of(List.of(result, isRestart), moveUp, moveDown);

    }
}
