package emblem.aether.util;

public class Location {

    private int x;
    private int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Location at(int x, int y) {
        return new Location(x, y);
    }

    public int x() { return this.x; }
    public int y() { return this.y; }
    public void incX() { ++x; }
    public void decX() { --x; }
    public void incY() { ++y; }
    public void decY() { --y; }

    @Override
    public String toString() { return "("+x+","+y+")"; }
}
