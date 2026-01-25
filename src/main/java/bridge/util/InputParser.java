package bridge.util;

public final class InputParser {

    private InputParser() {}

    public static Integer parseBridgeSize(String readBridgeSize) {
        int bridgeSize =  NumberConverter.convertToNumber(readBridgeSize.strip());
        Validator.validateBridgeSize(bridgeSize);

        return bridgeSize;
    }

    public static String parseMoving(String readMoving) {
        String moving = readMoving.strip();
        Validator.validateMoving(moving);

        return moving;
    }

    public static String parseGameCommand(String readCommand) {
        String command = readCommand.strip();
        Validator.validateCommand(command);

        return command;
    }
}
