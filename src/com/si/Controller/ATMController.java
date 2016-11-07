package com.si.Controller;

import com.si.domain.Account;
import com.si.domain.ActionTypeEnum;
import com.si.domain.Client;
import com.si.service.ActionService;
import com.si.view.ConsoleOutput;

/**
 * Created by Saranda Ilazi on 07/11/2016.
 */
public class ATMController {
    public void useATM(Client client) {
        ConsoleOutput.showWelcomeScreen();

        // Choose Account
        Account selectedAccount = ConsoleOutput.askAccount(client.getAccounts());

        // Choose Action
        int selectedAction = ConsoleOutput.askAction();

        // Process Action
        ActionService actionService = new ActionService();
        actionService.doAction(ActionTypeEnum.getEnumValue(selectedAction), selectedAccount);
    }
}
