package com.blablacar.service;

import com.blablacar.model.Lawn;
import com.blablacar.model.enums.Direction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LawnSimulationTest {
    private LawnSimulation lawnSimulation;
    private String inputFile;

    @BeforeEach
    public void setUp() {
        lawnSimulation = new LawnSimulation();
        inputFile = "5 5\n1 2 N\nLFLFLFLFF\n3 3 E\nFFRFFRFRRF\n";
    }

    @Test
    public void testLawnSimulatorWithTwoMowers() throws Exception {
        lawnSimulation.lawnSimulator(inputFile);
        assertEquals(2, lawnSimulation.lawn.getMowers().size());
    }

    @Test
    public void testLawnSimulatorMowed() throws Exception {
        lawnSimulation.lawnSimulator(inputFile);
        assertEquals(Direction.NORTH, lawnSimulation.lawn.getMowers().get(0).getDirection());
        assertEquals(Direction.EAST, lawnSimulation.lawn.getMowers().get(1).getDirection());
        assertEquals(1, lawnSimulation.lawn.getMowers().get(0).getPosition().getX());
    }

}