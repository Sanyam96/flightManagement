package com.nagarro.airlines.utilities;

import java.util.Scanner;

/**
 * @author Sanyam Goel created on 22/8/18
 */
public class ScannerInstance {

    // Scanner class instance
    private static Scanner scn = new Scanner(System.in);

    public static Scanner getScannerInstance() {
        return scn;
    }
}
