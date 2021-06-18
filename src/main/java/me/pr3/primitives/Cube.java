package me.pr3.primitives;

import com.google.common.eventbus.Subscribe;
import javafx.geometry.Point3D;
import me.pr3.Main;
import me.pr3.events.Render3DEvent;
import me.pr3.utils.PolygonBuilder;
import me.pr3.utils.ProjectionHelper;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Cube {

        public ArrayList<Point3D> point3DS = new ArrayList<>();
        public Polygon[] polygons = new Polygon[12];

        public Cube(int x, int y, int z, int width, int height, int depth){

            Main.EVENT_BUS.register(this);

            point3DS.add(new Point3D(x,y,z));
            point3DS.add(new Point3D(x + width,y,z));
            point3DS.add(new Point3D(x + width,y,z + depth));
            point3DS.add(new Point3D(x,y,z + depth));
            point3DS.add(new Point3D(x,y + height,z));
            point3DS.add(new Point3D(x + width,y + height,z));
            point3DS.add(new Point3D(x + width,y + height,z + depth));
            point3DS.add(new Point3D(x,y + height,z + depth));

            polygons[0] = PolygonBuilder.buildPolygon(ProjectionHelper.getScreenCordsOf3DPoint(point3DS.get(0)), ProjectionHelper.getScreenCordsOf3DPoint(point3DS.get(1)), ProjectionHelper.getScreenCordsOf3DPoint(point3DS.get(2)));
            polygons[1] = PolygonBuilder.buildPolygon(ProjectionHelper.getScreenCordsOf3DPoint(point3DS.get(2)), ProjectionHelper.getScreenCordsOf3DPoint(point3DS.get(3)), ProjectionHelper.getScreenCordsOf3DPoint(point3DS.get(0)));
            polygons[2] = PolygonBuilder.buildPolygon(ProjectionHelper.getScreenCordsOf3DPoint(point3DS.get(4)), ProjectionHelper.getScreenCordsOf3DPoint(point3DS.get(5)), ProjectionHelper.getScreenCordsOf3DPoint(point3DS.get(6)));
            polygons[3] = PolygonBuilder.buildPolygon(ProjectionHelper.getScreenCordsOf3DPoint(point3DS.get(6)), ProjectionHelper.getScreenCordsOf3DPoint(point3DS.get(7)), ProjectionHelper.getScreenCordsOf3DPoint(point3DS.get(4)));

        }


        @Subscribe
        public void onRender3D(Render3DEvent event){



            event.getGraphics().setColor(Color.GREEN);
            polygons[0] = PolygonBuilder.buildPolygon(ProjectionHelper.getScreenCordsOf3DPoint(point3DS.get(0)), ProjectionHelper.getScreenCordsOf3DPoint(point3DS.get(1)), ProjectionHelper.getScreenCordsOf3DPoint(point3DS.get(2)));
            polygons[1] = PolygonBuilder.buildPolygon(ProjectionHelper.getScreenCordsOf3DPoint(point3DS.get(2)), ProjectionHelper.getScreenCordsOf3DPoint(point3DS.get(3)), ProjectionHelper.getScreenCordsOf3DPoint(point3DS.get(0)));
            polygons[2] = PolygonBuilder.buildPolygon(ProjectionHelper.getScreenCordsOf3DPoint(point3DS.get(4)), ProjectionHelper.getScreenCordsOf3DPoint(point3DS.get(5)), ProjectionHelper.getScreenCordsOf3DPoint(point3DS.get(6)));
            polygons[3] = PolygonBuilder.buildPolygon(ProjectionHelper.getScreenCordsOf3DPoint(point3DS.get(6)), ProjectionHelper.getScreenCordsOf3DPoint(point3DS.get(7)), ProjectionHelper.getScreenCordsOf3DPoint(point3DS.get(4)));

            try {
                Arrays.stream(polygons).forEach(n -> event.getGraphics().drawPolygon(n));
            }catch(NullPointerException e){
                //TODO FIGURE OUT WHATS CAUSING THE NPE AND FIX IT
            }
        }





}
