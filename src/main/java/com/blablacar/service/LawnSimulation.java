package com.blablacar.service;

import com.blablacar.model.Lawn;
import com.blablacar.model.Mower;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public final class LawnSimulation {
    private final MowerServices mowerServices = new MowerServices();
    public Lawn lawn;

    /**
     * This method can be considered as the entry point of the application.
     * It mainly task is to initialize the lawn and mowers working inside it.
     *
     * 1. Retrieve width and length of lawn from the input file
     * 2. Retrieve the number of mowers from input file which is (total lines number -1)%2
     * 3. Retrieve commands for each mower from input file
     * 4. Generate mower and put it in the lawn
     *
     * @param file  the input file
     * @return
     * @throws Exception
     */
    public void lawnSimulator(final String file) throws Exception {
        final String[] lines = StringUtils.split(file, '\n');
        if ((lines.length % 2) == 1 && (lines[0].matches("[0-9]* [0-9]*"))) {
            String[] coordinates = StringUtils.split(lines[0], ' ');

            final int width = Integer.parseInt(coordinates[0]);
            final int length = Integer.parseInt(coordinates[1]);

            final int mowerNumber = (lines.length - 1) / 2;
            final List<Mower> mowers = new ArrayList<>();

            for (int i = 0; i < mowerNumber; i++) {
                final String initPosition = lines[(2 * i) + 1].trim();
                final String commands = lines[(2 * i) + 2].trim();
                //create mower
                mowers.add(mowerServices.mowerCreation(initPosition, commands, width, length));
            }
            //create lawn with mowers
            lawn = new Lawn(width, length, mowers);
        } else {
            throw new Exception("The input file is not formatted correctly");
        }
    }

    /**
     * As mentioned in the description, it is required to have several mowers work together
     * This method is used to trigger all mowers to mow
     */
    public void mowerRunInParallel() {
        for (Mower mower : lawn.getMowers()) {
            mowerServices.mow(mower);
            System.out.println(mower.getPosition().getX() + " " +
                    mower.getPosition().getY() + " " + mower.getDirection().getLetter());
        }
    }

//    public static void main(String[] args) {
//        String input = "5 5\n1 2 N\nLFLFLFLFF\n3 3 E\nFFRFFRFRRF\n";
//        LawnSimulation lawnSimulation = new LawnSimulation();
//        try {
//            lawnSimulation.lawnSimulator(input);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        lawnSimulation.mowerRunInParallel();
//    }

}
