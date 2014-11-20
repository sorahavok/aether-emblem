package emblem.aether;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TileMap {

    private final List<List<Tile>> tiles;

    public TileMap(final List<List<Tile>> tiles) {
        this.tiles = tiles;
    }

    public List<List<Tile>> tiles() {
        return tiles;
    }

    @Override
    public String toString() {
        return tiles.stream()
                .map(tiles -> tiles.stream().map(Tile::toString).collect(Collectors.joining(" ")))
                .collect(Collectors.joining("\n"));
        }

    public static Builder builder() {return new Builder();}

    public static class Builder {

        private List<Tile> tiles = new ArrayList<>();
        private int width;

        public Builder withWidth(int width) { this.width = width; return this; }
        public Builder addTile(Tile tile) { tiles.add(tile); return this; }
        public Builder addTiles(List<Tile> tiles) { tiles.addAll(tiles); return this; }
        public int width() { return width; }
        public int size() { return tiles.size(); }
        public List<Tile> tiles() { return tiles; }

        public TileMap build() {
            if(tiles.size() % width != 0) {
                System.err.println("[WARN] The number of tiles("+tiles.size()+") isn't divisible by the width ("+width+")");
            }
            return new TileMap( IntStream.range(0, tiles.size()/width + 1)
                         .mapToObj(i -> tiles.stream().skip(i * width).limit(width).collect(Collectors.toList()))
                         .collect(Collectors.toList()));
        }
    }
}
