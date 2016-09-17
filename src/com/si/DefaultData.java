package com.si;

import com.si.domain.Account;
import com.si.domain.AccountType;
import com.si.domain.Client;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Saranda Ilazi on 06/09/2016.
 */
public class DefaultData {

     private static Client getDefaultClient() {
        Client client = new Client();
        client.setId(1);
        client.setName("Saranda");
        client.setSurname("Ilazi");
        client.setCity("Prizren");
        client.setAddress("Xhevat Berisha");
        client.setPinCode(0000);
        client.setAccounts(getDefaultAccounts());
        return client;
    }

    private static List<Account> getDefaultAccounts() {
        Account defaultAcc = new Account(1, "4101123456789101", AccountType.DEFAULT, 100.565);
        Account savingsAcc = new Account(2, "4532257702999371", AccountType.SAVINGS, 2000.0);
        Account creditAcc = new Account(3, "4024007189418535", AccountType.CREDITCARD, 500.0);
        List<Account> accounts = new ArrayList<Account>();
        accounts.add(defaultAcc);
        accounts.add(savingsAcc);
        accounts.add(creditAcc);
        return accounts;
    }

    public static Client getClientData() {
        return getDefaultClient();
    }
}
