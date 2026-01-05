package bridge.domain;

public class BridgeGroup {
    private final Bridge up;
    private final Bridge down;

    public BridgeGroup() {
        this.up = new Bridge();
        this.down = new Bridge();
    }

    public void makeInit() {
        up.clear();
        down.clear();
    }
}
