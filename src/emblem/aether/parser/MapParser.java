package emblem.aether.parser;

import java.util.Scanner;

import emblem.aether.Tile;
import emblem.aether.TileMap;

public class MapParser implements FileParser<TileMap> {

    private final String delimiter;

    public MapParser(final String delimiter) {
        this.delimiter = delimiter;
    }


    @Override
    public TileMap parseFile(final Scanner scanner) {
        TileMap.Builder builder = TileMap.builder();
        builder.withWidth(8);
        scanner.forEachRemaining( x -> builder.addTile(new Tile(Integer.parseInt(x))));
        return builder.build();
    }

    @Override
    public String getDelimiter() {
        return delimiter;
    }

}
