package bridge.constant;

public enum FinalResult {
    WIN("성공"),
    LOSE("실패"),
    ;

    private final String result;

    FinalResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
