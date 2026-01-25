package bridge.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String BRIDGE_SIZE_REQUEST = "다리의 길이를 입력해주세요.";
    private static final String MOVING_REQUEST = "\n이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String COMMAND_REQUEST = "\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    public static String readBridgeSize() {
        System.out.println(BRIDGE_SIZE_REQUEST);
        return Console.readLine();
    }

    public static String readMoving() {
        System.out.println(MOVING_REQUEST);
        return Console.readLine();
    }

    public static String readGameCommand() {
        System.out.println(COMMAND_REQUEST);
        return Console.readLine();
    }
}
