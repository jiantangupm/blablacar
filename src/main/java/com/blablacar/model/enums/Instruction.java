package com.blablacar.model.enums;

public enum Instruction {
    RIGHT('R', 90),
    LEFT('L', -90),
    FORWARD('F', 0);

    private char command;
    private int angle;

    private Instruction(char command, int angle) {
        this.command = command;
        this.angle = angle;
    }

    public int getAngle() {
        return angle;
    }


    /**
     * Retrieve readable instruction from the command
     *
     * @param ch
     * @return
     */
    public static Instruction commandConverter(char ch) throws Exception{
        for (Instruction instruction : Instruction.values()) {
            if (instruction.command == ch) {
                return instruction;
            }
        }
        throw new Exception("Invalidated command found in the input: " + ch);
    }
}
