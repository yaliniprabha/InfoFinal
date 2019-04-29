package edu.berkeley.aep;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class NodeTest {

    private static Node nodeA = new Node("A");
    private static Node nodeB = new Node("B");
    private static Node nodeF = new Node("F");
    private static Node nodeC = new Node("C");
    private static Node nodeD = new Node("D");
    private static Node nodeE = new Node("E");
    private static Node nodeH = new Node("H");
    private static Node nodeG = new Node("G");

    static {
        nodeA.addConnection(nodeF, 8);
        nodeB.addConnection(nodeA, 12);
        nodeB.addConnection(nodeC, 10);
        nodeC.addConnection(nodeE, 22);
        nodeC.addConnection(nodeE, 16);
        nodeC.addConnection(nodeD, 6);
        nodeD.addConnection(nodeE, 8);
        nodeE.addConnection(nodeB, 9);
        nodeH.addConnection(nodeB, 20);
    }

    @Test
    public void selfEqualsSelfShouldReturnTrue() {
        assertTrue(nodeA.canReach(nodeA));
    }

    @Test
    public void bCanReachCShouldReturnTrue() {
        assertTrue(nodeB.canReach(nodeC));
    }

    @Test
    public void bCanReachHShouldReturnFalse() {
        assertFalse(nodeB.canReach(nodeH));
    }

    @Test
    public void bCanReachDShouldReturnTrue() {
        assertTrue(nodeB.canReach(nodeE));
    }

    @Test
    public void bCanReachFShouldReturnTrue() {
        assertTrue(nodeB.canReach(nodeF));
    }

    @Test
    public void bCanReachGShouldReturnFalse() {
        assertFalse(nodeB.canReach(nodeG));
    }

    @Test
    public void bCanReachEShouldReturnTrue() {
        assertTrue(nodeB.canReach(nodeE));
    }

    @Test
    public void numberOfHopsBetweenHandHShouldBeZero() {
        assertEquals(new Path(0), nodeH.countHops(nodeH));
    }

    @Test
    public void numberOfHopsBetweenHandDShouldBeThree() {
        assertEquals(new Path(3), nodeH.countHops(nodeD));
    }

    @Test
    public void pathCostFromSelftoSelfShouldBeZero() {
        assertEquals(new Path(0), nodeA.pathCost(nodeA, 2));
    }

    @Test
    public void pathCostFromHtoBShouldBeTwenty() {
        assertEquals(new Path(20), nodeH.pathCost(nodeB, 2));
    }

    @Test
    public void pathCostFromCtoEShouldBeFourteen() {
        assertEquals(new Path(14), nodeC.pathCost(nodeE, 2));
    }

    @Test
    public void pathCostFromCtoBShouldBeTwentyThree() {
        assertEquals(new Path(23), nodeC.pathCost(nodeB, 2));
    }

    @Test
    public void pathCostFromCtoAShouldBeThirtyFive() {
        assertEquals(new Path(35), nodeC.pathCost(nodeA, 2));
    }

}
