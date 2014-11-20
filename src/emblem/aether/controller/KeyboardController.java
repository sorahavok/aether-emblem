package emblem.aether.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardController implements Controller, KeyListener {

    private Action action = Action.NONE;

    @Override
    public Action readCommand() {
        final Action temp = action;
        action = Action.NONE;
        return temp;
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("key code: " + e.getKeyCode());
        System.out.println("key code: " + e.getKeyChar());
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            action = Action.EXIT;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

}
