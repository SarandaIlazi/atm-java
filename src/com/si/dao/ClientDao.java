package com.si.dao;

import com.si.database.DBConnection;
import com.si.domain.Client;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Created by Saranda Ilazi on 20/09/2016.
 */
public class ClientDao extends DBConnection {

    public ClientDao() {}

    public Client getClient(int id) {
        Client client = null;
        try {
            String sql = "SELECT * FROM client WHERE id=? LIMIT 1;";

            // Prepare SQL statement with parameter
            PreparedStatement statement = dbConnection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet dbResult = statement.executeQuery();

            client = new Client();
            while(dbResult.next()) {
                // Fill client attributes with DB Results
                client.setId(dbResult.getInt("id"));
                client.setName(dbResult.getString("name"));
                client.setSurname(dbResult.getString("surname"));
                client.setCity(dbResult.getString("city"));
                client.setAddress(dbResult.getString("address"));
                client.setBirthday(dbResult.getDate("birthday"));
                client.setPinCode(dbResult.getString("pinCode"));
            }
        } catch(SQLException exception){
            exception.printStackTrace();
        }
        return client;
    }
}
