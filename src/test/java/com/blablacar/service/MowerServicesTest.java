package com.blablacar.service;

import com.blablacar.model.Mower;
import com.blablacar.model.enums.Direction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MowerServicesTest {
    private MowerServices mowerServices;
    private String initPosition;
    private String command;
    private int width;
    private int length;

    @BeforeEach
    public void setUp() {
      initPosition = "1 2 N";
      command = "LFLFLFLFF";
      width = 5;
      length = 5;
      mowerServices = new MowerServices();
    }

    @Test
    public void testMowerCreation() throws Exception {

        final Mower mower = mowerServices.mowerCreation(initPosition, command, width, length);
        assertEquals(Direction.NORTH, mower.getDirection());
        assertEquals(1, mower.getPosition().getX());
    }
    //String input = "5 5\n1 2 N\nLFLFLFLFF\n3 3 E\nFFRFFRFRRF\n";

    @Test
    public void testMowerMow() throws Exception {
        final Mower mower = mowerServices.mowerCreation(initPosition, command, width, length);
        mowerServices.mow(mower);
        assertEquals(Direction.NORTH, mower.getDirection());
        assertEquals(3, mower.getPosition().getY());
    }


}