package com.si.service;

import com.si.dao.ClientDao;
import com.si.domain.Client;

/**
 * Created by Saranda Ilazi on 22/09/2016.
 */
public class ClientService {

    public Client login(int inputId, String inputPinCode){
        ClientDao clientDao = new ClientDao();
        Client client = clientDao.getClient(inputId);

        if (client != null && inputPinCode.equals(client.getPinCode())) {
            return client;
        } else {
            return null;
        }
    }
}
