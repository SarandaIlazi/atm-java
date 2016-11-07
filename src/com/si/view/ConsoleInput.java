package com.si.view;

import java.util.Scanner;

/**
 * Created by Saranda Ilazi on 17/09/2016.
 */
public class ConsoleInput {
    static Scanner scanner = new Scanner(System.in);

    public static int readInt() {
        return scanner.nextInt();
    }

    public static char readChar() {
        return scanner.next().charAt(0);
    }

    public static String readString(){
        return scanner.next();
    }
}
