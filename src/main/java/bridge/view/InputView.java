package bridge.view;

import bridge.util.ErrorMessage;
import bridge.util.Validator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String INPUT_BRIDGE_LENGTH = "다리의 길이를 입력해주세요.";
    private static final String INPUT_SELECT_BOX = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_RETRY_GAME = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료 : Q)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        System.out.println(INPUT_BRIDGE_LENGTH);
        String inputBridgeSize = Console.readLine();

        Validator.checkNull(inputBridgeSize);
        try{
            int bridgeSize = Integer.parseInt(inputBridgeSize);
            Validator.checkRange(bridgeSize);
            return bridgeSize;
        }catch(NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.INPUT_RANGE_ERROR);
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        System.out.println(INPUT_SELECT_BOX);
        String inputMoving = Console.readLine();

        Validator.checkNull(inputMoving);
        Validator.checkMoving(inputMoving);
        return inputMoving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        System.out.println(INPUT_RETRY_GAME);
        String inputGameCommand = Console.readLine();

        Validator.checkNull(inputGameCommand);
        Validator.checkCommand(inputGameCommand);
        return inputGameCommand;
    }
}
