package emblem.aether;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import emblem.aether.controller.CommandLineController;
import emblem.aether.controller.Controller;
import emblem.aether.parser.FileParser;
import emblem.aether.parser.MapParser;
import emblem.aether.units.SimplePlayer;
import emblem.aether.util.Location;

public class EntryPoint {

    public static void main(String[] args) throws IOException {
        final String mapPath = "resources/map";
        final TileMap map = createMap(mapPath);
        final Controller controller = new CommandLineController(new BufferedReader(new InputStreamReader(System.in)));
        final GameLevel game = new GameLevel(map, controller, new SimplePlayer(Location.at(3, 3)));
        game.run();
    }

    private static TileMap createMap(final String mapPath) throws IOException {
        final File file = new File(mapPath);
        final FileParser<TileMap> parser = new MapParser(",|\n");
        return parser.readFile(file);
    }

//    private static void buildMap() throws IOException {
//        File file = new File("newFile");
//        try (Writer writer = new FileWriter(file)) {
//            TileMap.Builder bob = TileMap.builder();
//
//            bob.addTile(new Tile(0))
//            .addTile(new Tile(1));
//
//            for(int i=0; i<14; ++i) { bob.addTiles(bob.tiles()); }
//
//            IntStream.range(2, bob.size() + 1)
//              .filter(i -> bob.size()%i == 0)
//              .mapToObj(i -> bob.withWidth(i).build())
//              .forEach(map -> {
//                try {
//                    System.out.println("Starting Write for " + map.tiles().size());
//                    writer.write(map.toString());
//                }
//                catch (IOException e) {e.printStackTrace();}
//              });
//            System.out.println("Size: "+ bob.size());
//        }
//    }
}
