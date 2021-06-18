package me.pr3.utils;

import java.awt.*;

public class RenderThread extends Thread{

    private Graphics graphics = null;

    public Graphics getGraphics() {
        return graphics;
    }

    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }


    public RenderThread(Graphics graphics){
        this.graphics = graphics;
    }


    @Override
    public void run() {
    }
}
