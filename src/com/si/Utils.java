package com.si;

/**
 * Created by Saranda Ilazi on 18/09/2016.
 */
public class Utils {

    public static double formatAmount(double amount) {
        return Math.round(amount * 100.0) / 100.0;
    }
}
