package com.si.service;

import com.si.dao.ClientDao;
import com.si.domain.Client;

/**
 * Created by Saranda Ilazi on 22/09/2016.
 */
public class ClientService {

    public Client login(int id, String pinCode) {
        ClientDao clientDao = new ClientDao();
        Client client = clientDao.getClient(id);

        if (client != null && pinCode.equals(client.getPinCode())) {
            return client;
        } else {
            return null;
        }


    }
}
