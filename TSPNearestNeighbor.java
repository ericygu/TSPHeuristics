package com.company;

import java.util.ArrayList;
public class TSPNearestNeighbor {
    public static ArrayList<Line2D> computeNearestNeighbor(ArrayList<Point2D> points){
        ArrayList<Point2D> pathing = new ArrayList<Point2D>();
        ArrayList<Point2D> vertices = (ArrayList<Point2D>) points.clone();
        //base
        pathing.add(vertices.remove(0));
        Point2D vertice = pathing.get(0);

        while (vertices.size() > 0) {
            int minI = 0;
            double minimalDistance = vertice.distance(vertices.get(0));
            //greedy method
            int i = 0;
            while (i < vertices.size()) {
                double distance = vertice.distance(vertices.get(i));
                if (distance < minimalDistance) {
                    minI = i;
                    minimalDistance = distance;
                }
                i++;
            }
            pathing.add(vertices.remove(minI));
            vertice = pathing.get(pathing.size()-1);
        }
        pathing.add(pathing.get(0));
        return points2Lines(pathing);
    }

    public static ArrayList<Line2D> getLine2DS(ArrayList<Point2D> points) {
        ArrayList<Line2D> lines = new ArrayList<>();
        int i = 1;
        //connect and iterate
        while (i < points.size()) {
            lines.add(new Line2D(points.get(i-1), points.get(i)));
            i++;
        }
        return lines;
    }

    private static ArrayList<Line2D> points2Lines(ArrayList<Point2D> points) {
        return getLine2DS(points);
    }

}

