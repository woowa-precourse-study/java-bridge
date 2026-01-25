package bridge.controller;

import bridge.constant.Constant;
import bridge.constant.FinalResult;
import bridge.dto.ResultDto;
import bridge.service.BridgeService;
import bridge.util.InputParser;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {

    private final BridgeService bridgeService;

    public BridgeController(BridgeService bridgeService) {
        this.bridgeService = bridgeService;
    }

    public void run() {
        OutputView.printStart();

        registerBridgeSize();

        while (true) {
            move();
            ResultDto result = getResult();
            OutputView.printMap(result);

            String command = readCommandIfFail(result);
            if (!command.isEmpty()) {
                resetIfCommandIsRestart(command);
            }

            if (isGameOver(command)) {
                OutputView.printResult(result);
                break;
            }
        }
    }

    private void registerBridgeSize() {
        while (true) {
            try {
                String readBridgeSize = InputView.readBridgeSize();
                int bridgeSize = InputParser.parseBridgeSize(readBridgeSize);

                bridgeService.registerBridgeSize(bridgeSize);

                return;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }

    private boolean isGameOver(String command) {
        return bridgeService.isGameOver() || command.equals(Constant.QUIT);
    }

    private void resetIfCommandIsRestart(String command) {
        if (command.equals(Constant.RESTART)) {
            bridgeService.reset();
        }
    }

    private String readCommandIfFail(ResultDto resultDto) {
        if (resultDto.getFinalResult() == FinalResult.LOSE) {
            while (true) {
                try {
                    String readGameCommand = InputView.readGameCommand();
                    return InputParser.parseGameCommand(readGameCommand);
                } catch (IllegalArgumentException e) {
                    OutputView.printErrorMessage(e);
                }
            }
        }
        return "";
    }

    private ResultDto getResult() {
        return bridgeService.getResult();
    }

    private void move() {
        while (true) {
            try {
                String readMoving = InputView.readMoving();
                String moving = InputParser.parseMoving(readMoving);
                bridgeService.move(moving);
                return;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }

    }
}
