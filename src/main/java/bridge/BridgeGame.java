package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridgeAnswer;
    private List<String> moveUp;
    private List<String> moveDown;


    public BridgeGame(int bridgeLength) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        this.bridgeAnswer = bridgeMaker.makeBridge(bridgeLength);
        this.moveUp = new ArrayList<>();
        this.moveDown = new ArrayList<>();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String userMove, int idx) {
        if (userMove.equals("U")) {
            moveUp.add(userCorrect(userMove, idx));
            moveDown.add(" ");
            return;
        }
        moveUp.add(" ");
        moveDown.add(userCorrect(userMove, idx));
    }

    public String userCorrect(String move, int idx) {
        if (move.equals(bridgeAnswer.get(idx))) {
            return "O";
        }
        return "X";
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        this.moveUp = new ArrayList<>();
        this.moveDown = new ArrayList<>();
    }

    public List<String> getMoveUp() {
        return moveUp.stream().collect(Collectors.toList());
    }

    public List<String> getMoveDown() {
        return moveDown.stream().collect(Collectors.toList());
    }
}
