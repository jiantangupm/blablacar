package com.blablacar.service;

import com.blablacar.model.Coordinate;
import com.blablacar.model.Mower;
import com.blablacar.model.enums.Direction;
import com.blablacar.model.enums.Instruction;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static com.blablacar.model.enums.Instruction.commandConverter;

public class MowerServices {


    /**
     * This method is used to initiate a mower
     *
     * @param initPosition mower start location
     * @param command mower instruction given in the input file
     * @param width  lawn's width
     * @param length lawn's length
     * @return
     * @throws Exception
     */
    public Mower mowerCreation(final String initPosition, final String command, final int width, final int length)
            throws Exception {

        final String[] initStatus = StringUtils.split(initPosition, ' ');
        //e.g., initStatus = ["1", "2", "N"]
        final int x = Integer.parseInt(initStatus[0]);
        final int y = Integer.parseInt(initStatus[1]);
        final Direction direction = Direction.directionCommandConverter(initStatus[2].toCharArray()[0]);

        List<Instruction> commands = new ArrayList<>();
        for (char letter : command.toCharArray()) {
            commands.add(commandConverter(letter));
        }
        return new Mower( new Coordinate(x, y), direction, commands, width, length);

    }

    /**
     * This is the executor of the mower
     * 1. if the command is forward, then it move 1 step
     * 2. if the command is turn RIGHT/LEFT, it will rotate 90 degrees according to its current direction
     *
     * @param mower
     */
    public void mow(Mower mower) {
        for (Instruction instruction:mower.getInstructions()) {
            if (instruction.equals(Instruction.FORWARD)) {
                moveForward(mower);
            } else {
               rotate(mower, instruction);
            }
        }
    }

    private void moveForward(Mower mower) {
        Coordinate newCoordinates = Direction.getForwardCoordinates(mower.getDirection(), mower.getPosition());
        if (isValidPosition(newCoordinates, mower.getxBound(), mower.getyBound())) {
            mower.setPosition(newCoordinates);
        }
    }

    private void rotate(Mower mower, Instruction instruction) {
        Direction newDirection = Direction.changeDirection(mower.getDirection(), instruction);
        if (newDirection != null) {
            mower.setDirection(newDirection);
        }
    }

    /**
     * Check if a position is validated in lawn
     * @param coordinate
     * @return
     */
    private boolean isValidPosition(Coordinate coordinate, int xLimitation, int yLimitation) {
        return (coordinate.getX() >= 0 && coordinate.getX() <= xLimitation &&
                coordinate.getY() >= 0 && coordinate.getY() <= yLimitation);
    }
}
