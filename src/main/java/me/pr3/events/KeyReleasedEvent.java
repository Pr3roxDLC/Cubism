package me.pr3.events;

import java.awt.*;
import java.awt.event.KeyEvent;

public class KeyReleasedEvent extends KeyEvent {
    public KeyReleasedEvent(Component source, int id, long when, int modifiers, int keyCode, char keyChar, int keyLocation) {
        super(source, id, when, modifiers, keyCode, keyChar, keyLocation);
    }

    public KeyReleasedEvent(Component source, int id, long when, int modifiers, int keyCode, char keyChar) {
        super(source, id, when, modifiers, keyCode, keyChar);
    }

    public KeyReleasedEvent(Component source, int id, long when, int modifiers, int keyCode) {
        super(source, id, when, modifiers, keyCode);
    }

    public KeyReleasedEvent(KeyEvent e){
        super(e.getComponent(),e.getID(), e.getWhen(), e.getModifiers(), e.getKeyCode(), e.getKeyChar(), e.getKeyLocation());
    }

}
