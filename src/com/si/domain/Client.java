package com.si.domain;

import java.util.Date;
import java.util.List;

/**
 * Created by Saranda Ilazi on 06/09/2016.
 */
public class Client {
    private int id;
    private String name;
    private String surname;
    private String city;
    private String address;
    private Date birthday;
    private List<Account> accounts;
    private String pinCode;

    public Client() {
    }

    public Client(int id, String name, String surname, String city, String address, Date birthday, List<Account> accounts, String pinCode) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.address = address;
        this.birthday = birthday;
        this.accounts = accounts;
        this.pinCode = pinCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", birthday=" + birthday +
                ", accounts=" + accounts +
                ", pinCode=" + pinCode +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        return id == client.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
