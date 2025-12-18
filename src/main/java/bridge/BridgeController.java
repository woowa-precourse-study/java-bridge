package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class BridgeController {
    private final InputView inputView;
    //    private final BridgeService bridgeService;
    static String PREFIX_ERROR = "[ERROR] ";
    static final int MAX_RETRY = 10;

    public BridgeController() {
        this.inputView = new InputView();
//        this.bridgeService = bridgeService;
    }

    public void run() {
        int num = inputView.readBridgeSize();
        int times = 0;

        // 정답이 되는 다리 건설
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> bridgeAnswer = bridgeMaker.makeBridge(num);
        List<String> copyAnswer = new ArrayList<>();
        List<String> moveUp = new ArrayList<>();
        List<String> moveDown = new ArrayList<>();
        String gameResult = "";

        while (true) {
            times += 1;
            copyAnswer.addAll(bridgeAnswer);  // 깊은 복사
            List<List<String>> result = playGame(num, copyAnswer);
            moveUp = result.get(1);
            moveDown = result.get(2);
            gameResult = result.get(0).get(0);

            if (gameResult.equals("성공") || gameResult.equals("Restart")) {
                break;
            }
        }


        System.out.println("최종 게임 결과");
        System.out.println("[ " + String.join(" | ", moveUp) + " ]");
        System.out.println("[ " + String.join(" | ", moveDown) + " ]");
        System.out.println("게임 성공 여부: " + gameResult);
        System.out.println("총 시도한 횟수: " + times);

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
                System.out.println("[ " + String.join(" | ", moveUp) + " ]");
                System.out.println("[ " + String.join(" | ", moveDown) + " ]");
            }
            idx += 1;

        }
        return List.of(List.of(result, isRestart), moveUp, moveDown);

    }
}
