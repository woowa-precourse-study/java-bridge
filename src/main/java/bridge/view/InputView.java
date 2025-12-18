package bridge.view;

import bridge.util.ErrorMessage;
import bridge.util.Validator;
import camp.nextstep.edu.missionutils.Console;
import java.nio.file.attribute.AclEntryPermission;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String INPUT_BRIDGE_LENGTH = "다리의 길이를 입력해주세요.";
    private static final String INPUT_SELECT_BOX = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_RETRY_GAME = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료 : Q)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(GAME_START_MESSAGE);
        System.out.println();
        while(true){
            System.out.println(INPUT_BRIDGE_LENGTH);
            String inputBridgeSize = Console.readLine();
            if(Validator.checkNull(inputBridgeSize)){
                System.out.println(ErrorMessage.INPUT_RANGE_ERROR);
                continue;
            }
            try{
                int bridgeSize = Integer.parseInt(inputBridgeSize);
                if(Validator.checkRange(bridgeSize)){
                    System.out.println(ErrorMessage.INPUT_RANGE_ERROR);
                    continue;
                }
                return Integer.parseInt(inputBridgeSize);
            }catch(NumberFormatException e){
                System.out.println(ErrorMessage.INPUT_RANGE_ERROR);
            }
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        while(true){
            System.out.println(INPUT_SELECT_BOX);
            String inputMoving = Console.readLine();
            if(Validator.checkNull(inputMoving) || !Validator.checkMoving(inputMoving)){
                System.out.println(ErrorMessage.INPUT_SELECT_ERROR);
                continue;
            }
            return inputMoving;
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        while(true){
            System.out.println(INPUT_RETRY_GAME);
            String inputGameCommand = Console.readLine();
            if(Validator.checkNull(inputGameCommand) || !Validator.checkCommand(inputGameCommand)){
                System.out.println(ErrorMessage.INPUT_RETRY_ERROR);
                continue;
            }
            return inputGameCommand;
        }
    }
}
