package com.si.dao;

import com.si.database.DBConnection;
import com.si.domain.Account;
import com.si.domain.AccountType;
import com.si.domain.Client;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;

/**
 * Created by Saranda Ilazi on 05/10/2016.
 */
public class AccountDao extends DBConnection {

    public List<Account> getClientAccounts(int clientId) {
        Account account = new Account();
        List<Account> accountList = null;
        try {
            String sql = "SELECT * FROM account WHERE clientId=?;";
            PreparedStatement statement = dbConnection.prepareStatement(sql);
            statement.setInt(1, clientId);
            ResultSet dbResult = statement.executeQuery();

            if(!dbResult.next()){
                return accountList;
            }

            accountList = new ArrayList<Account>();
            while (dbResult.next()) {
                account.setId(dbResult.getInt("id"));
                account.setAccountNumber(dbResult.getString("accountNumber"));
                account.setAmount(dbResult.getDouble("amount"));
                account.setAccountType(AccountType.valueOf(dbResult.getString("accountType")));

                accountList.add(account);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return accountList;
    }

    public void updateAmount(Account account) {
        try {
            String sql ="UPDATE account SET amount=? WHERE id=?";
            PreparedStatement statement = dbConnection.prepareStatement(sql);
            statement.setDouble(1, account.getAmount());
            statement.setInt(2, account.getId());
            statement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
    public double getAmount(Account account){
        double amount = account.getAmount();
        try{
            String sql= "SELECT amount FROM account WHERE id=?";
            PreparedStatement statement = dbConnection.prepareStatement(sql);
            statement.setInt(1, account.getId());
            ResultSet dbResult = statement.executeQuery();
            while(dbResult.next()){
                 amount = dbResult.getDouble("amount");
            }

        }catch(SQLException exception){
            exception.printStackTrace();
        }
        return amount;
    }

}

