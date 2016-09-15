package com.si;

import com.si.domain.Account;
import com.si.domain.AccountType;
import com.si.domain.Client;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Saranda Ilazi on 06/09/2016.
 */
public class DeafultData {

    private Client getDefaultClient() {
        Client client = new Client();
        client.setId(1);
        client.setName("Saranda");
        client.setSurname("Ilazi");
        client.setCity("Prizren");
        client.setAddress("Xhevat Berisha");
        client.setPinCode(0000);
        return client;
    }

    private List<Account> getDefaultAccounts() {
        Account defaultAcc = new Account(1, 00000001, AccountType.DEFAULT, 0.0);
        Account savingsAcc = new Account(1, 00000002, AccountType.SAVINGS,0.0);
        Account creditAcc = new Account(1, 00000003, AccountType.CREDITCARD, 0.0);
        List<Account> accounts = new ArrayList<Account>();
        accounts.add(defaultAcc);
        accounts.add(savingsAcc);
        accounts.add(creditAcc);
        return accounts;
    }

    public Client getClientData() {
        Client client = getDefaultClient();
        client.setAccounts(getDefaultAccounts());
        return client;
    }
}
