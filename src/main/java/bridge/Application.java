package bridge;

import bridge.controller.Controller;
import bridge.service.Service;


public class Application {

    public static void main(String[] args) {
        Service service = new Service();
        Controller controller = new Controller(service);
        try {
            controller.run();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
