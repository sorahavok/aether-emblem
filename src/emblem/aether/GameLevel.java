package emblem.aether;

import emblem.aether.controller.Action;
import emblem.aether.controller.Controller;
import emblem.aether.units.Unit;

public class GameLevel implements Runnable {

    private final TileMap tileMap;
    private final Controller controller;
    private final Unit player;

    public GameLevel(final TileMap tileMap, final Controller controller, final Unit player) {
        this.tileMap = tileMap;
        this.controller = controller;
        this.player = player;
        System.out.println(this.tileMap);
    }

    @Override
    public void run() {

        while(true) {
            final Action command = controller.readCommand();
            if(command != Action.NONE) {
                player.processActions(command);
            }
            if(command == Action.EXIT) {
                System.out.println("Time to Exit");
                break;
            }
        }
    }

}
