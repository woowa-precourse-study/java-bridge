package bridge.domain;

import java.util.List;

public class Bridge {

    private List<String> bridge;
    private int position;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean isSuccessMoving(String step) {
        if (bridge.get(position).equals(step)) {
            position++;
            return true;
        }
        return false;
    }

    public void resetPosition() {
        position = 0;
    }

    public boolean isLastMoving() {
        return position == bridge.size();
    }
}
