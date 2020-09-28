package com.blablacar.model.enums;

import com.blablacar.model.Coordinate;

public enum Direction {

    NORTH('N', 0, 0, 1),
    EAST('E', 90, 1, 0),
    SOUTH('S', 180, 0, -1),
    WEST('W', 270, -1, 0);

    private static final int CIRCLE_DEGREE = 360;

    private char letter;
    private int angle;
    private int xStep;
    private int yStep;

    Direction(char letter, int angle, int xStep, int yStep) {
        this.letter = letter;
        this.angle = angle;
        this.xStep = xStep;
        this.yStep = yStep;
    }

    public char getLetter() {
        return letter;
    }

    public static Direction changeDirection(Direction initDirection, Instruction instruction) {
        return getFromAngle(computeAngle(initDirection.angle + instruction.getAngle()));
    }

    public static Coordinate getForwardCoordinates(Direction orientation, Coordinate coordinates) {
        int x = coordinates.getX() + orientation.xStep;
        int y = coordinates.getY() + orientation.yStep;
        return new Coordinate(x, y);
    }

    public static Direction directionCommandConverter(char ch) throws Exception{
        for (Direction orientation : Direction.values()) {
            if (orientation.letter == ch) {
                return orientation;
            }
        }
        throw new Exception("This direction is not supported: " + ch);
    }

    public static Direction getFromAngle(int angle) {
        for (Direction direction : Direction.values()) {
            if (direction.angle == angle) {
                return direction;
            }
        }
        return null;
    }

    private static int computeAngle(int angle) {
        return (((angle % CIRCLE_DEGREE) + CIRCLE_DEGREE) % CIRCLE_DEGREE);
    }
}
