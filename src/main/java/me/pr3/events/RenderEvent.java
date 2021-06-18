package me.pr3.events;

import java.awt.*;

public class RenderEvent {

    public Graphics getGraphics() {
        return graphics;
    }

    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }

    Graphics graphics;

    public RenderEvent(Graphics g){
        graphics = g;
    }



}
