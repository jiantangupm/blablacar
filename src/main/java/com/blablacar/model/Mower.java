package com.blablacar.model;

import com.blablacar.model.enums.Direction;
import com.blablacar.model.enums.Instruction;

import java.util.List;


/**
 * Business model class for mower information
 * including its status (position, direction, and its mow area bounds)
 */
public class Mower {
    private Coordinate position;
    private Direction direction;
    private List<Instruction> instructions;
    private int xBound;
    private int yBound;


    public Mower(Coordinate position, Direction direction, List<Instruction> instructions, int xBound, int yBound) {
        this.position = position;
        this.direction = direction;
        this.instructions = instructions;
        this.xBound = xBound;
        this.yBound = yBound;
    }

    public Coordinate getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }

    public int getxBound() {
        return xBound;
    }

    public int getyBound() {
        return yBound;
    }

    public void setPosition(Coordinate position) {
        this.position = position;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "Mower{" +
                "position=" + position +
                ", direction=" + direction +
                ", instructions=" + instructions +
                ", xBound=" + xBound +
                ", yBound=" + yBound +
                '}';
    }
}
