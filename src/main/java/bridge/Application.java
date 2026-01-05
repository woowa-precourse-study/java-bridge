package bridge;

public class Application {

    public static void main(String[] args) {
        BridgeController oncallController = new BridgeController();
            try{
                oncallController.run();
            } catch(IllegalStateException e){
                System.out.println(e.getMessage());
            }
    }

}

