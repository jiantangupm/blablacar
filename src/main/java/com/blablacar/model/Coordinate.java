package com.blablacar.model;

/**
 * Business model class for coordinate information, which is used to locate a mower
 */
public class Coordinate {
    /**
     * Suppose the coordinates can only be int.
     */
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
