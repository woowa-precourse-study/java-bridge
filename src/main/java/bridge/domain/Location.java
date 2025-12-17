package bridge.domain;

public class Location {
    public static final Location INIT = new Location(0);

    private final int location;

    public Location(int location) {
        this.location = location;
    }

    public int getLocation() {
        return location;
    }

    public Location move() {
        return new Location(location + 1);
    }
}
