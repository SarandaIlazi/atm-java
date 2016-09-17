package com.si;

import java.util.*;

import com.si.domain.Account;
import com.si.domain.Client;
import com.si.service.ActionService;

public class  Main {

    public static void main(String[] args) {
        do {
            Client client = DefaultData.getClientData();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your id: ");
            int inputId = scanner.nextInt();
            System.out.print("Enter your pin code: ");
            int inputPinCode = scanner.nextInt();

            // Check Login
            if (inputId == client.getId() && inputPinCode == client.getPinCode()) {
                System.out.println("Welcome to Sara ATM ");

                // Choose Account
                System.out.println("Choose which account you want to use: ");
                List<Account> clientAccounts = client.getAccounts();
                for (int i = 0; i < client.getAccounts().size(); i++) {
                    System.out.println(i + 1 + " - " + clientAccounts.get(i).getAccountNumber() +
                            "(" + clientAccounts.get(i).getAccountType() + ")");
                }
                System.out.print("Enter the number: ");
                int inputAccountNumber = scanner.nextInt();
                Account selectedAccount = clientAccounts.get(inputAccountNumber - 1);

                // Choose Action
                System.out.println("Chose the action");
                System.out.println("1 - Withdraw");
                System.out.println("2 - Deposit");
                System.out.println("3 - Balance");
                int inputActionNumber = scanner.nextInt();

                // Process Action
                ActionService actionService = new ActionService();
                switch (inputActionNumber) {
                    case 1: {
                        System.out.printf("Enter withdraw Amount: ");
                        int withdrawAmount = scanner.nextInt();
                        actionService.withdraw(selectedAccount, withdrawAmount);
                        break;
                    }
                    case 2: {
                        System.out.printf("Enter deposit Amount: ");
                        int depositAmount = scanner.nextInt();
                        actionService.deposit(selectedAccount, depositAmount);
                        break;
                    }
                    case 3: {
                        System.out.println("Your balance is: " + (Math.round(actionService.balance(selectedAccount) * 100.0) / 100.0));
                        break;
                    }
                }

            } else {
                System.out.println("Please verify your data!");
            }

            //check program flow
            System.out.print("Do you want to continue? Press y for YES and n for NO: ");
            char continueAnswer = scanner.next().charAt(0);
           if( continueAnswer == 'y' || continueAnswer == 'Y'){
                continue;
            }else{
                break;
            }

        } while (true);
    }
}