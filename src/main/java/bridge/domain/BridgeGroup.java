package bridge.domain;

import java.util.List;

public class BridgeGroup {
    private final Bridge up;
    private final Bridge down;

    public BridgeGroup() {
        this.up = new Bridge();
        this.down = new Bridge();
    }

    public List<Bridge> getBridgeGroup() {
        return List.of(up,down);
    }


    public void makeInit() {
        up.clear();
        down.clear();
    }

    public int getCount(){
        return up.getSize();
    }

    public void addUp(boolean isAnswer){
        if (isAnswer){
            up.add("O");
            return;
        }
        up.add(" ");
    }

    public void addDown(boolean isAnswer){
        if (isAnswer){
            down.add("O");
            return;
        }
        down.add(" ");
    }
}
