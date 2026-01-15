package bridge.domain;

import java.util.List;

public class BridgeGroup {
    private final Bridge up;
    private final Bridge down;

    public BridgeGroup() {
        this.up = new Bridge();
        this.down = new Bridge();
    }

    public Bridge getUp() {
        return up;
    }

    public Bridge getDown() {
        return down;
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

    public void move(String userInput, String answer){
        if (userInput.equals("U")){
            up.add(answer.equals(userInput)?"O":"X");
            down.add(" ");
            return;
        }
        up.add(" ");
        down.add(answer.equals(userInput)?"O":"X");
    }
}
