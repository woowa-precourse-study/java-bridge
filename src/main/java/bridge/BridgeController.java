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
        String result="";

        while (true) {
            bridgeGame.retry();
            times += 1;
            int idx = 0;
            result = "성공";
            String isRestart = "Quit";
            while (moveUp.size() < num) {
                String move = inputView.readMoving();
                // move 사용자  , bridgeAnswer.get(idx) : 답
                bridgeGame.move(move,idx);
                if (moveUp.size() < num) {
                    moveUp = bridgeGame.getMoveUp();
                    moveDown = bridgeGame.getMoveDown();
                    outputView.printMap(moveUp, moveDown);
                }

                if (bridgeGame.userCorrect(move,idx).equals("X")){
                    result = "실패";
                    isRestart = inputView.readGameCommand();
                    break;
                }

                idx += 1;
            }

            moveUp = bridgeGame.getMoveUp();
            moveDown = bridgeGame.getMoveDown();

            if (result.equals("성공") || isRestart.equals("Restart")) {
                break;
            }
        }
        outputView.printResult(moveUp, moveDown, result, times);

    }


    public List<List<String>> playGame(int num, List<String> bridgeAnswer) {
        List<String> moveUp = new ArrayList<>();
        List<String> moveDown = new ArrayList<>();
        int idx = 0;
        String result = "성공";
        String isRestart = "Quit";
        while (moveUp.size() < num) {
            String move = inputView.readMoving();
            // move 사용자  , bridgeAnswer.get(idx) : 답

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
