package edu.berkeley.aep;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class BesterTest {

    @Test
    public void twoFeetIsLargerThanOneFootAndFiveInches() {
        var twoFeet = new ArithmeticQuantity(2, Unit.FEET);
        var oneFoot = new ArithmeticQuantity(1, Unit.FEET);
        var fiveInches = new ArithmeticQuantity(5, Unit.INCHES);
        List<Bestable> obList= List.of(twoFeet, oneFoot, fiveInches);
        assertEquals(twoFeet, Bester.largestObject(obList));
    }

    @Test
    public void threeFourthChanceShouldBeGreaterThanOneHalfChanceAndZero() {
        var chanceThreeFourth = new Chance(3/4d);
        var chanceOneHalf = new Chance(1/2d);
        var zero = new Chance(0);
        List<Bestable> chanceList= List.of(chanceThreeFourth, chanceOneHalf, zero);
        assertEquals(chanceThreeFourth, Bester.largestObject(chanceList));
    }

}
