package edu.berkeley.aep;

import java.util.List;


public class Bester {

    public static Bestable largestObject(List<Bestable> objectList) {
        Bestable max = objectList.get(0);
        for (Bestable ob: objectList) {
            if (!(max.betterThan(ob))) {
                max = ob;
            }
        }
        return max;
    }
}
