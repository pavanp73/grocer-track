package com.pavan.track.services.utils;

public class MathUtility {

    public static double twoDecimalRoundOff(double value) {
        return (double) (Math.round(value) * 100) / 100;
    }
}
