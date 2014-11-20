package emblem.aether.controller;

import java.io.IOException;
import java.io.Reader;

public class CommandLineController implements Controller {

    private final Reader reader;

    public CommandLineController(final Reader reader) {
        this.reader = reader;
    }

    @Override
    public Action readCommand() {
        try {
            final int read = reader.read();
            switch (read) {
                case 97: return Action.LEFT;  // a
                case 119: return Action.UP;   // w
                case 115: return Action.DOWN; // s
                case 100: return Action.RIGHT;// d
                case 96: return Action.EXIT;  // exit
                default: return Action.NONE;
            }
        } catch (IOException e) {
            return Action.EXIT;
        }
    }

}
