package bridge;

import bridge.controller.BridgeController;
import bridge.factory.ApplicationFactory;

public class Application {

    public static void main(String[] args) {
        ApplicationFactory factory = new ApplicationFactory();

        BridgeController controller = factory.controller();

        controller.run();
    }
}
