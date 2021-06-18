package me.pr3;

import com.google.common.eventbus.Subscribe;
import com.sun.javafx.geom.Vec3f;
import javafx.geometry.Point3D;
import me.pr3.events.KeyPressedEvent;

import java.awt.event.KeyEvent;

public class Camera {

    public Point3D getLocation() {
        return location;
    }

    public void setLocation(Point3D location) {
        this.location = location;
    }

    public Vec3f getFacing() {
        return facing;
    }

    public void setFacing(Vec3f facing) {
        this.facing = facing;
    }

    Point3D location = new Point3D(0, 0,0);
    Vec3f facing = new Vec3f(0, 0,0 );
    float fov = 90f;

    public Camera(Point3D location, Vec3f facing){

        Main.EVENT_BUS.register(this);

        this.facing = facing;
            this.location = location;

    }


    public Camera(Point3D location, Vec3f facing, float fov){

        Main.EVENT_BUS.register(this);

        this.facing = facing;
        this.location = location;
        this.fov = fov;
    }

    @Subscribe
    public void onKeyPressed(KeyPressedEvent e){
        System.out.printf("Test");
            if(e.getKeyCode() == KeyEvent.VK_SHIFT){
                System.out.println("Key");
                location = location.add(0,1,0);
                System.out.println(location.getX() + " " + location.getY() + " " + location.getZ());
            }
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            System.out.println("Key");
            location = location.subtract(0,1,0);
            System.out.println(location.getX() + " " + location.getY() + " " + location.getZ());
        }
        if(e.getKeyCode() == KeyEvent.VK_D){
            System.out.println("Key");
            location = location.add(1,0,0);
            System.out.println(location.getX() + " " + location.getY() + " " + location.getZ());
        }
        if(e.getKeyCode() == KeyEvent.VK_A){
            System.out.println("Key");
            location = location.subtract(1,0,0);
            System.out.println(location.getX() + " " + location.getY() + " " + location.getZ());
        }
        if(e.getKeyCode() == KeyEvent.VK_S){
            System.out.println("Key");
            location = location.add(0,0,1);
            System.out.println(location.getX() + " " + location.getY() + " " + location.getZ());
        }
        if(e.getKeyCode() == KeyEvent.VK_W){
            System.out.println("Key");
            location = location.subtract(0,0,1);
            System.out.println(location.getX() + " " + location.getY() + " " + location.getZ());
        }
    }

}
