package com.si;

import com.si.dao.ClientDao;
import com.si.domain.Account;
import com.si.domain.ActionTypeEnum;
import com.si.domain.Client;
import com.si.service.ActionService;
import com.si.view.ConsoleOutput;
import com.si.service.ClientService;

import javax.swing.*;


public class Main {

    public static void main(String[] args) {
        // TODO: Refactor and extract all the code below to Controller classes (main should be empty)

        int inputId = ConsoleOutput.askId();
        String inputPinCode = ConsoleOutput.askPin();

        // Check Login
        ClientService clientService = new ClientService();
        Client client = clientService.login(inputId, inputPinCode);
        if (client == null) return; // Stop if invalid login

        while (true) {
            ConsoleOutput.showWelcomeScreen();

            // Choose Account
            Account selectedAccount = ConsoleOutput.askAccount(client.getAccounts());

            // Choose Action
            int selectedAction = ConsoleOutput.askAction();


            // TODO: Extract selected action case handling on ActionService class
            // Process Action
            ActionService actionService = new ActionService();
            ActionTypeEnum action = ActionTypeEnum.getEnumValue(selectedAction);
            switch (action) {
                case WITHDRAWAL: {
                    actionService.withdraw(selectedAccount, ConsoleOutput.askWithdrawAmount());
                    ConsoleOutput.showBalance(actionService.balance(selectedAccount));
                    break;
                }
                case DEPOSIT: {
                    actionService.deposit(selectedAccount, ConsoleOutput.askDepositAmount());
                    ConsoleOutput.showBalance(actionService.balance(selectedAccount));
                    break;
                }
                case BALANCE: {
                    double balance = actionService.balance(selectedAccount);
                    ConsoleOutput.showBalance(balance);
                    break;
                }
            }
            // Check program flow
            char continueAnswer = ConsoleOutput.askAnotherService();
            if (continueAnswer == 'y' || continueAnswer == 'Y') {
                continue;
            } else {
                break;
            }
        }
    }
}