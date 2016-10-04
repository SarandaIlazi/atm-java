package com.si.service;

import com.si.domain.Account;

/**
 * Created by Saranda Ilazi on 16/09/2016.
 */
public class ActionService {
    // TODO: Implement each method with DB calls via DAO layer

    public void withdraw(Account account, int amount) {
        double actualAmount = account.getAmount();
        if (actualAmount >= amount) {
            account.setAmount(actualAmount - amount);
        }
    }

    public void deposit(Account account, int amount) {
        double actualAmount = account.getAmount();
        account.setAmount(actualAmount + amount);
    }

    public double balance(Account account) {
        return account.getAmount();
    }

}
