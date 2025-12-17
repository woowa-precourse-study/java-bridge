package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class GameResult {
    private final List<String> result;
    private final boolean success;

    public GameResult(List<String> result, boolean success) {
        this.result = result;
        this.success = success;
    }

    public GameResult add(String move, boolean success) {
        ArrayList<String> newResult = new ArrayList<>(result);
        newResult.add(move);

        return new GameResult(List.copyOf(newResult), success);
    }

    public List<String> getResult() {
        return List.copyOf(result);
    }

    public boolean isSuccess() {
        return success;
    }

    public boolean isMaxSize(int maxSize) {
        return result.size() == maxSize;
    }

    public GameResult retry() {
        return new GameResult(List.of(), true);
    }
}
