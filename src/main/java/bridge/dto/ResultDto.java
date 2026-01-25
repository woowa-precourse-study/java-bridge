package bridge.dto;

import bridge.constant.FinalResult;
import java.util.ArrayList;
import java.util.List;

public class ResultDto {

    private final List<String> upBridge;
    private final List<String> downBridge;
    private final int tryCount;
    private final FinalResult finalResult;

    public ResultDto(List<String> upBridge, List<String> downBridge, int tryCount, FinalResult finalResult) {
        this.upBridge = new ArrayList<>(upBridge);
        this.downBridge = new ArrayList<>(downBridge);
        this.tryCount = tryCount;
        this.finalResult = finalResult;
    }

    public List<String> getUpBridge() {
        return upBridge;
    }

    public List<String> getDownBridge() {
        return downBridge;
    }

    public int getTryCount() {
        return tryCount;
    }

    public FinalResult getFinalResult() {
        return finalResult;
    }
}
