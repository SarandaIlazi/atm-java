package com.si.Controller;

import com.si.domain.Client;
import com.si.service.ClientService;
import com.si.view.ConsoleOutput;

/**
 * Created by Saranda Ilazi on 08/10/2016.
 */
public class UserController {

    public Client authenticate() {
        // TODO: FIX retry login mechanism

        int inputId = ConsoleOutput.askId();
        String inputPinCode = ConsoleOutput.askPin();

        ClientService clientService = new ClientService();
        return clientService.login(inputId, inputPinCode);

    }
}