package bridge.domain;

import bridge.utils.BridgeNumberGenerator;
import bridge.utils.BridgeRandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final BridgeGroup bridges;
    private final List<String> answerBridges;
    private final BridgeMaker bridgeMaker;

    public BridgeGame(BridgeNumberGenerator bridgeNumberGenerator, int size) {
        this.bridges=new BridgeGroup();
        this.bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        this.answerBridges = bridgeMaker.makeBridge(size);
    }

    public List<Bridge> getBridges() {
        return bridges.getBridgeGroup();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String userInput) {
        String answer=answerBridges.get(bridges.getCount());
        if (userInput.equals("U")){
            bridges.addUp(answer.equals(userInput));
            bridges.addDown(false);
            return;
        }
        bridges.addUp(false);
        bridges.addDown(answer.equals(userInput));
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        bridges.makeInit();
    }
}
