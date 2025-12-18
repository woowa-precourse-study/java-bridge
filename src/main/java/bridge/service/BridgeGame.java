package bridge.service;

import bridge.util.InputHandler;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private List<String> bridge;
    private ArrayList<String>[] moveResult = new ArrayList[2];
    private int bridgeSize;
    private int currentIndex = 0;
    private int tryCount = 1;

    public BridgeGame(List<String> brideList) {
        this.bridge = brideList;
        this.bridgeSize = brideList.size();
        moveResult[0] = new ArrayList<>();
        moveResult[1] = new ArrayList<>();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String movingInput, String result) {
        if(movingInput.equals("U")){
            moveResult[0].add(result);
            moveResult[1].add(" ");
        }else{
            moveResult[0].add(" ");
            moveResult[1].add(result);
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        moveResult[0].remove(moveResult[0].size()-1);
        moveResult[1].remove(moveResult[1].size()-1);
        tryCount++;
    }

    /**
     * 허용된 칸인지 확인하는 메서드
     * */
    public String checkMoveable(String movingInput){
        String currentBox = bridge.get(currentIndex);
        if(movingInput.equals(currentBox)){
            return "O";
        }
        return "X";
    }


    public void run(){
        while(currentIndex < bridgeSize){
            // 라운드 진행
            // 칸 입력 받기
            String movingInput = InputHandler.retry(InputView::readMoving);

            // 진행가능 여부 계산
            String result = checkMoveable(movingInput);
            move(movingInput, result);
            currentIndex++;

            // 중간 출력
            OutputView.printMap(moveResult);

            //결과가 X일 경우 재시작 여부 판단
            if(result.equals("X")){
                String command = InputHandler.retry(InputView::readGameCommand);
                if(command.equals("Q")){
                    break;
                }
                retry();
                currentIndex--;
            }
        }

        OutputView.printResult(moveResult,bridgeSize,tryCount, currentIndex);
    }


}
