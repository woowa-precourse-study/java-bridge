package bridge.controller;

import bridge.service.Service;

import java.util.function.Supplier;

public class Controller {
    private final InputView inputView;
    private final Service service;
    static final int MAX_RETRY = 10;

    public Controller(Service service) {
        this.inputView = new InputView();
        this.service = service;
    }

    public void run() {

        int size = doRetry(inputView::readBridgeSize);

    }

    private <T> T doRetry(Supplier<T> action) {
        int retry = 0;
        while (true) {
            try {
                return action.get();
            } catch (IllegalArgumentException e) {
                retry++;
                System.out.println(e.getMessage());

                if (retry >= MAX_RETRY) {
                    throw new IllegalStateException("입력 횟수를 초과했습니다.");
                }
            }
        }
    }


}

