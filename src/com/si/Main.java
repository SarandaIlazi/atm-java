package com.si;

import java.util.*;

import com.si.domain.Account;
import com.si.domain.AccountType;
import com.si.domain.Client;


public class  Main {

    public static void main(String[] args) {

        Client client = new Client();
        System.out.print("Enter your id: ");
        Scanner scan1 = new Scanner(System.in);
        int inputId = scan1.nextInt();
        System.out.print("Enter your pin code: ");
        Scanner scan2 = new Scanner(System.in);
        int inputPinCode = scan2.nextInt();

        if (inputId == client.getId() && inputPinCode == client.getPinCode()) {
            System.out.println("Welcome to Sara ATM ");
        } else {
            System.out.println("PLease verify your data!");
        }

       int defaultNum = 1;
        int savingNum = 2;
        int creditCardNum = 3

        Scanner scan3 = new Scanner(System.in);

        System.out.println("Choose which account you want to use: ");
        System.out.println("1. Defualt ");
        System.out.println("2. Savings ");
        System.out.println("3. CreditCard ");
        System.out.print("Enter the number: ");

        int choice = scan3.nextInt();

       /* if(choice == 1){
            choice = client.getAccounts();
        }else if(choice == 2){
            choice = client.getAccounts();
        }else(choice ==3){
            choice = client.getAccounts();
        }*/

    }

}
