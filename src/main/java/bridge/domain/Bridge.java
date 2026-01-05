package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private final List<String> bridge = new ArrayList<>();

    public void add(String message){
        bridge.add(message);
    }

    public void clear(){
        bridge.clear();
    }

    public List<String> getBridge() {
        return bridge;
    }

    public int getSize() {
        return bridge.size();
    }
}
