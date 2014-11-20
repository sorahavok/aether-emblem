package emblem.aether.units;

import emblem.aether.controller.Action;
import emblem.aether.util.Location;

public class SimplePlayer implements Unit {

    private final Location loc;

    public SimplePlayer(final Location loc) {
        this.loc = loc;
    }

    @Override
    public final Location getLocation() {
        return loc;
    }

    @Override
    public final String toString() {
        return "#";
    }

    @Override
    public final void processActions(final Action... commands) {
        for (final Action action : commands) {
            if(action == Action.UP) {loc.decY();}
            else if(action == Action.DOWN) { loc.incY(); }
            else if(action == Action.LEFT) { loc.decX(); }
            else if(action == Action.RIGHT) { loc.incX(); }
        }
    }

}
