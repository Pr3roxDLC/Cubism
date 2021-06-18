package me.pr3.primitives;

import com.google.common.eventbus.Subscribe;
import me.pr3.Main;
import me.pr3.utils.PolygonBuilder;
import me.pr3.events.Render2DEvent;

import java.awt.*;
import java.util.Arrays;

public class Plane {

    Point[] points = new Point[4];
    Polygon[] polygons = new Polygon[2];
    boolean wireframe = false;

    public boolean isWireframe(){
        return wireframe;
    }

    public void setWireframe(boolean wireframe){this.wireframe = wireframe;}

    public Point[] getPoints() {
        return points;
    }

    public void setPoints(Point[] points) {
        this.points = points;
    }

    public Polygon[] getPolygons() {
        return polygons;
    }

    public void setPolygons(Polygon[] polygons) {
        this.polygons = polygons;
    }

    public Plane(int x, int y, int width, int height) {

        Main.EVENT_BUS.register(this);

        points[0] = new Point(x, y);
        points[1] = new Point(x, y + height);
        points[2] = new Point(x + width, y + height);
        points[3] = new Point(x + width, y);
        polygons[0] = PolygonBuilder.buildPolygon(points[0], points[1], points[2]);
        polygons[1] = PolygonBuilder.buildPolygon(points[2], points[3], points[0]);

    }


    @Subscribe
    public void onRender(Render2DEvent e){
        Arrays.stream(polygons).forEach(n ->{if(!wireframe){ e.getGraphics().fillPolygon(n);}else{e.getGraphics().drawPolygon(n);}});
    }

}
