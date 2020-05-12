package com.company;

import java.util.ArrayList;
public class TSPMinimumSpanningTree {
    public static ArrayList<Line2D> computeMST(ArrayList<Point2D> vertices){
        vertices = (ArrayList<Point2D>) vertices.clone();
        ArrayList<Point2D> mstVertices = new ArrayList<Point2D>();
        mstVertices.add(vertices.remove(0));
        ArrayList<Line2D> tree = new ArrayList<Line2D>();

        while (vertices.size() > 0) {
            double minimumDistance = mstVertices.get(0).distance(vertices.get(0));
            Line2D minimumEdge = new Line2D(mstVertices.get(0), vertices.get(0));
            int index = 0;

            for (Point2D mstVertice : mstVertices) {
                int i = 0;
                while (i < vertices.size()) {
                    double distance = mstVertice.distance(vertices.get(i));
                    if (distance < minimumDistance) {
                        minimumDistance = distance;
                        minimumEdge = new Line2D(mstVertice, vertices.get(i));
                        index = i;
                    }
                    i++;
                }
            }
            mstVertices.add(vertices.remove(index));
            tree.add(minimumEdge);
        }
        return tree;
    }

    public static ArrayList<Line2D> computeDFSTour(ArrayList<Point2D> points, ArrayList<Line2D> mst){
        mst = (ArrayList<Line2D>) mst.clone();
        ArrayList<Point2D> traversal = new ArrayList<Point2D>();
        traversal.add(mst.get(0).getP1());

        while (mst.size() > 0) {
            int i = 0;
            int index = 0;
            while (i < traversal.size()) { // iterate until valid index
                index = getIndex(mst, traversal.get(traversal.size() - 1 - i));
                if (index != -1) {
                    break;
                }
                i++;
            }
            traversal.add(mst.remove(index).getP2());
        }
        traversal.add(traversal.get(0));
        return points2Lines(traversal);
    }

    private static int getIndex(ArrayList<Line2D> mst, Point2D p) {
        int i = 0;
        while (i < mst.size()) {
            if (mst.get(i).getP1() == p) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private static ArrayList<Line2D> points2Lines(ArrayList<Point2D> points) {
        return TSPNearestNeighbor.getLine2DS(points);
    }
}
