package com.si;

import com.si.dao.ClientDao;
import com.si.domain.Account;
import com.si.domain.Client;
import com.si.service.ActionService;
import com.si.view.ConsoleOutput;

public class Main {

    public static void main(String[] args) {

        // Dummy Data (DB Simulation)
        Client client = DefaultData.getClientData();


ClientDao clientDao = new ClientDao();
        System.out.println(clientDao.getClient(1));



        int inputId = ConsoleOutput.askId();
        String inputPinCode = ConsoleOutput.askPin();

        // Check Login
        // TODO: Extract login check on ClientService
        if (inputId != client.getId() || !inputPinCode.equals(client.getPinCode())) {
            return;
        }
        while (true) {
            ConsoleOutput.showWelcomeScreen();

            // Choose Account
            Account selectedAccount = ConsoleOutput.askAccount(client.getAccounts());

            // Choose Action
            int selectedAction = ConsoleOutput.askAction();

            // TODO: Extract selected action case handling on ActionService class
            // Process Action
            ActionService actionService = new ActionService();
            switch (selectedAction) { // TODO: For later change int with Enum for Action types
                case 1: {
                    actionService.withdraw(selectedAccount, ConsoleOutput.askWithdrawAmount());
                    ConsoleOutput.showBalance(actionService.balance(selectedAccount));
                    break;
                }
                case 2: {
                    actionService.deposit(selectedAccount, ConsoleOutput.askDepositAmount());
                    ConsoleOutput.showBalance(actionService.balance(selectedAccount));
                    break;
                }
                case 3: {
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