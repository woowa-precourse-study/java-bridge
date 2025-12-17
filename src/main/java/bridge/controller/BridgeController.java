package bridge.controller;

import static bridge.exception.ErrorMessage.NOT_VALID_COMMAND;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.GameResult;
import bridge.factory.BridgeFactory;
import bridge.util.NumberParser;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.view.PrintMessage;
import java.util.List;
import java.util.function.Supplier;

public class BridgeController {
    private final BridgeMaker bridgeMaker;
    private GameResult result;

    public BridgeController(BridgeMaker bridgeMaker, GameResult result) {
        this.bridgeMaker = bridgeMaker;
        this.result = result;
    }

    public void run() {
        int tries = 1;

        OutputView.printPrompt(PrintMessage.GAME_BEGIN);

        int size = readSize();
        List<String> bridge = bridgeMaker.makeBridge(size);
        BridgeGame game = BridgeFactory.createGame(bridge);

        while (true) {
            move(game, size);

            if (result.isSuccess()) {
                break;
            }

            String command = readCommand();
            if (command.equals("Q")) {
                break;
            }

            tries++;
            game = game.retry();
            result = result.retry();
        }

        OutputView.printResult(result, tries);
    }

    private void move(BridgeGame game, int maxSize) {
        while (true) {
            retryOnError(() -> {
                OutputView.printPrompt(PrintMessage.INPUT_MOVE);
                String move = InputView.readMoving();
                result = game.move(move, result);
            });
            OutputView.printMap(result);

            if (!result.isSuccess()) {
                return;
            }

            if (result.isMaxSize(maxSize)) {
                return;
            }
        }
    }

    private int readSize() {
        return retryOnError(() -> {
            OutputView.printPrompt(PrintMessage.INPUT_BRIDGE_SIZE);
            String inputBridgeSize = InputView.readBridgeSize();

            return NumberParser.parse(inputBridgeSize);
        });
    }

    private String readCommand() {
        return retryOnError(() -> {
            OutputView.printPrompt(PrintMessage.INPUT_AGAIN);
            String command = InputView.readGameCommand();

            validateCommand(command);

            return command;
        });
    }

    private void validateCommand(String command) {
        if (!command.equals("R") && !command.equals("D")) {
            throw new IllegalArgumentException(NOT_VALID_COMMAND.getMessage());
        }
    }

    private <T> T retryOnError(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    private void retryOnError(Runnable runnable) {
        while (true) {
            try {
                runnable.run();
                return;
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }
}
