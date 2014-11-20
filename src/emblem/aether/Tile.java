package emblem.aether;

public class Tile {

    private final int value;

    public Tile(final int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public boolean passable() {
        return value != 1;
    }

    @Override
    public String toString() {
        return value == 1 ? "X" : value == 2 ? " " : "O";
    }
}
