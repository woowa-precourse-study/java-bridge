package bridge.domain;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public List<String> getBridge() {
        return List.copyOf(bridge);
    }

    public boolean isSameAs(int latestMove, String move) {
        return bridge.get(latestMove).equals(move);
    }
}
