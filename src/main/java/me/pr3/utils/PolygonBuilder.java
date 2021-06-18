package me.pr3.utils;

import java.awt.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class PolygonBuilder {

   public static Polygon buildPolygon(Point ... points){

       return new Polygon(Arrays.stream(points).mapToInt(n -> n.x).toArray(),Arrays.stream(points).mapToInt(n -> n.y).toArray(), points.length);

   }



}
