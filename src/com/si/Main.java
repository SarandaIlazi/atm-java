package com.si;

import com.si.Controller.ATMController;
import com.si.Controller.UserController;
import com.si.domain.Client;
import com.si.view.ConsoleOutput;


public class Main {

    public static void main(String[] args) {
        UserController userController = new UserController();
        Client client = userController.authenticate();

        while(client == null) {
            if(!ConsoleOutput.askRetryLogin()) System.exit(0);
            client = userController.authenticate();
        }

        while (true) {
            ATMController atmController = new ATMController();
            atmController.useATM(client);
            if(!ConsoleOutput.askAnotherService()) System.exit(0);
        }
    }
}