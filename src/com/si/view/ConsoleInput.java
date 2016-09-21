package com.si.view;

import java.util.Scanner;

/**
 * Created by Saranda Ilazi on 17/09/2016.
 */
class ConsoleInput {
    static Scanner scanner = new Scanner(System.in);

    static int readInt() {
        return scanner.nextInt();
    }

    static char readChar() {
        return scanner.next().charAt(0);
    }

    static String readString(){
        return scanner.next();
    }

}
