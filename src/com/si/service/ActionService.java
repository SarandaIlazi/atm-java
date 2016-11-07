package com.si.service;

import com.si.dao.AccountDao;
import com.si.domain.Account;
import com.si.domain.ActionTypeEnum;
import com.si.view.ConsoleOutput;

/**
 * Created by Saranda Ilazi on 16/09/2016.
 */
public class ActionService {

    AccountDao accountDao = new AccountDao();

    public void withdraw(Account account, int withdrawAmount) {
        double actualAmount = account.getAmount();
        double updatedAmount = actualAmount;
        if (actualAmount >= withdrawAmount) {
            updatedAmount = actualAmount - withdrawAmount;
        }
        account.setAmount(updatedAmount); // update Account object with the latest amount (by substracting the withdrawn amount)
        accountDao.updateAmount(account); // Save the latest amount on DB
    }

    public void deposit(Account account, int depositAmount) {
        double actualAmount = account.getAmount();
        double updateAmount = actualAmount + depositAmount;
        account.setAmount(updateAmount);
        accountDao.updateAmount(account);
    }

    public double balance(Account account) {
        double amount = accountDao.getAmount(account);
        account.setAmount(amount);
        return amount;
    }

    public void doAction(ActionTypeEnum action, Account selectedAccount) {
        switch (action) {
            case WITHDRAWAL: {
                withdraw(selectedAccount, ConsoleOutput.askWithdrawAmount());
                ConsoleOutput.showBalance(balance(selectedAccount));
                break;
            }
            case DEPOSIT: {
                deposit(selectedAccount, ConsoleOutput.askDepositAmount());
                ConsoleOutput.showBalance(balance(selectedAccount));
                break;
            }
            case BALANCE: {
                double balance = balance(selectedAccount);
                ConsoleOutput.showBalance(balance);
                break;
            }
        }
    }



}

