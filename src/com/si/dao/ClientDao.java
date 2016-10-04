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


/**
 * Created by Saranda Ilazi on 20/09/2016.
 */
public class ClientDao extends DBConnection {

    public ClientDao() {
    }

    public Client getClient(int id) {
        Client client = null;
        try {
            String sql = "SELECT * FROM client WHERE id=? LIMIT 1;";
            // Prepare SQL statement with parameter
            PreparedStatement statement = dbConnection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet dbResult = statement.executeQuery();

            client = new Client();
            while (dbResult.next()) {
                // Fill client attributes with DB Results
                client.setId(dbResult.getInt("id"));
                client.setName(dbResult.getString("name"));
                client.setSurname(dbResult.getString("surname"));
                client.setCity(dbResult.getString("city"));
                client.setAddress(dbResult.getString("address"));
                client.setBirthday(dbResult.getDate("birthday"));
                client.setPinCode(dbResult.getString("pinCode"));
            }

            // TODO: Extract the code for getting Account list to AccountDao method
            sql = "SELECT * FROM account WHERE clientId=?;";
            statement = dbConnection.prepareStatement(sql);
            statement.setInt(1, id);
            dbResult = statement.executeQuery();

            List<Account> accountList = new ArrayList<Account>();
            while (dbResult.next()) {
                Account account = new Account();
                account.setId(dbResult.getInt("id"));
                account.setAccountNumber(dbResult.getString("accountNumber"));
                account.setAmount(dbResult.getDouble("amount"));
                account.setAccountType(AccountType.valueOf(dbResult.getString("accountType")));

                accountList.add(account);
            }
            client.setAccounts(accountList);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return client;
    }
}
