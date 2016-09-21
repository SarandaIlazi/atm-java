package com.si.view;

import com.si.Utils;
import com.si.domain.Account;

import java.util.List;

/**
 * Created by Saranda Ilazi on 17/09/2016.
 */
public class ConsoleOutput {

    public static void showWelcomeScreen() {
        System.out.println("===========================");
        System.out.println("=== Welcome to Sara ATM ===");
        System.out.println("===========================");
    }

    public static int askId() {
        System.out.print("Enter your id: ");
        return ConsoleInput.readInt();
    }

    public static String askPin() {
        String pin;
        while (true) {
            System.out.println("Enter your pin code: ");
            pin = ConsoleInput.readString();
            // Validate pin (4 digits)
            if (pin.length() != 4 || !pin.matches("[0-9]+") ) { // Pin should be 4 digits and not a letter
                System.out.println("Pin is not in valid format (4 digits) or is not a number!");
            } else {
                break;
            }
        }
        return pin;
    }

    public static Account askAccount(List<Account> clientAccounts) {
        int inputAccountNumber = 0;
        while (true) {
            System.out.println("Choose which account you want to use: ");
            for (int i = 0; i < clientAccounts.size(); i++) {
                System.out.println(i + 1 + " - " + clientAccounts.get(i).getAccountNumber() +
                        "(" + clientAccounts.get(i).getAccountType() + ")");
            }
            System.out.print("Enter the number: ");
            inputAccountNumber = ConsoleInput.readInt();
            if (inputAccountNumber > clientAccounts.size() || clientAccounts.size() < 0) {
                System.out.println("Your choice is invalid.");
            } else {
                break;
            }
        }
        return clientAccounts.get(inputAccountNumber - 1);
    }

    public static int askAction() {
        int chosenAction = 0;
        while (true) {
            System.out.println("Chose the action");
            System.out.println("1 - Withdraw");
            System.out.println("2 - Deposit");
            System.out.println("3 - Balance");
            chosenAction = ConsoleInput.readInt();
            if (chosenAction < 0 || chosenAction > 3) { // Checking for hardcoded 3 since we only have 3 options
                System.out.println("You have choosen an invalid option, try again.");
            } else {
                break;
            }
        }
        return chosenAction;
    }

    public static int askWithdrawAmount() {
        System.out.printf("Enter withdraw Amount: ");
        return ConsoleInput.readInt();
    }

    public static int askDepositAmount() {
        System.out.printf("Enter deposit Amount: ");
        return ConsoleInput.readInt();
    }

    public static void showBalance(double amount) {
        System.out.println("Your balance is: " + Utils.formatAmount(amount));
    }

    public static char askAnotherService() {
        char continueAnswer;
        while(true) {
            System.out.print("Do you want to continue? Press 'y' for YES and 'n' for NO: ");
            continueAnswer = ConsoleInput.readChar();
            if(continueAnswer != 'y' && continueAnswer != 'n') {
                System.out.println("You selected an invalid option, please try again.");
            } else {
                break;
            }
        }
        return continueAnswer;
    }

    public static void showInvalidLogin() {
        System.out.println("Please verify your data!");
    }
}
