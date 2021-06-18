package me.pr3.managers;

import me.pr3.Main;
import me.pr3.events.KeyPressedEvent;
import me.pr3.events.KeyReleasedEvent;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputManager implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        Main.EVENT_BUS.post(new KeyPressedEvent(e));
    }

    @Override
    public void keyReleased(KeyEvent e) {
       Main.EVENT_BUS.post(new KeyReleasedEvent(e));
    }
}
