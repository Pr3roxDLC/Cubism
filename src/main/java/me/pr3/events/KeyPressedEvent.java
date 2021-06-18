package me.pr3.events;

import java.awt.*;
import java.awt.event.KeyEvent;

public class KeyPressedEvent extends KeyEvent {
    public KeyPressedEvent(Component source, int id, long when, int modifiers, int keyCode, char keyChar, int keyLocation) {
        super(source, id, when, modifiers, keyCode, keyChar, keyLocation);
    }

    public KeyPressedEvent(Component source, int id, long when, int modifiers, int keyCode, char keyChar) {
        super(source, id, when, modifiers, keyCode, keyChar);
    }

    public KeyPressedEvent(Component source, int id, long when, int modifiers, int keyCode) {
        super(source, id, when, modifiers, keyCode);
    }

    public KeyPressedEvent(KeyEvent e){
        super(e.getComponent(),e.getID(), e.getWhen(), e.getModifiers(), e.getKeyCode(), e.getKeyChar(), e.getKeyLocation());
    }

}
