package edu.berkeley.aep;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChanceTest {

    @Test
    public void chanceOfOneNotHappeningShouldBeZero() {
        var chance = new Chance(1);
        var chanceZero = new Chance(0);
        assertEquals(chanceZero, chance.not());
    }

    @Test
    public void notShouldProduceTheComplementOfADieThrow() {
        var chance = new Chance(1d/6d);
        assertEquals(new Chance(5d/6d), chance.not());

    }

    @Test
    public void andOfOneAndOneShouldBeOne() {
        var chance = new Chance(1);
        assertEquals(chance, chance.and(chance));
    }

    @Test
    public void andOfTwoEventsShouldReturnTheProductOfTheirProbabilities() {
        var dieTwo = new Chance(1d/6d);
        var coinHeads = new Chance(1d/2d);
        var twoAndHeads = new Chance(1d/12d);
        assertEquals(twoAndHeads, dieTwo.and(coinHeads));
    }

    @Test
    public void orOfTwoFairCoinFlipsShouldReturnTheirSumMinusProduct() {
        var coin = new Chance(1d/2d);
        assertEquals(new Chance(3d/4d), coin.or(coin));
    }
}
