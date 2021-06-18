package me.pr3.utils;

import javafx.geometry.Point3D;
import me.pr3.Main;

import java.awt.*;

public class ProjectionHelper {


    //https://stackoverflow.com/questions/724219/how-to-convert-a-3d-point-into-2d-perspective-projection
    public static Point getScreenCordsOf3DPoint(Point3D point3D) {
        int x = (int) ((point3D.getX() - Main.CAMERA.getLocation().getX()) * (point3D.getZ() - Main.CAMERA.getLocation().getZ()) + Main.CAMERA.getLocation().getX());
        int y = (int) ((point3D.getY() - Main.CAMERA.getLocation().getY()) * (point3D.getZ() - Main.CAMERA.getLocation().getZ()) + Main.CAMERA.getLocation().getY());

//        System.out.println(Main.CAMERA.getLocation().getX() + " " + Main.CAMERA.getLocation().getY() + " " + Main.CAMERA.getLocation().getZ());
//        System.out.println("Drawing at: " + x+" "+y);
        return new Point(x + Main.WIDTH/2, y);
    }

}
