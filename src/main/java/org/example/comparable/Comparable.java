package org.example.comparable;

import java.util.TreeSet;

public class Comparable {
    public static void main(String[] args) {
        TreeSet<Point> treeSet = new TreeSet<>();
        treeSet.add(new Point(2, 3));
        treeSet.add(new Point(1, 2));
        treeSet.add(new Point(2, 3));
        treeSet.add(new Point(1, 1));
        treeSet.add(new Point(1, 2));
        System.out.println(treeSet);

    }

}

class Point implements java.lang.Comparable<Point> {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public int compareTo(Point o) {
        if (this.x > o.x) return 1;
        else if (this.x < o.x) {
            return -1;
        } else {
            if (this.y > o.y) return 1;
            else if (this.y < o.y) {
                return -1;
            } else return 0;
        }
    }
}
