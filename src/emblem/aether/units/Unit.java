package emblem.aether.units;

import emblem.aether.controller.Action;
import emblem.aether.util.Location;

public interface Unit {

    Location getLocation();
    void processActions(Action... commands);

}
