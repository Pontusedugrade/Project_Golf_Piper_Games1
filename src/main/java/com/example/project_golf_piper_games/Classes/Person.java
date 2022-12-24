package com.example.project_golf_piper_games.Classes;

import javax.persistence.*;

@Entity
@Table(name = "person")

public class Person {

    //Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private int personID;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "e_mail")
    private String mailAddress;

    //Foreign KEY
    @ManyToOne
    @JoinColumn(name = "adress_id")
    private Address addressId;


    //Constructor
    public Person() {
    }

    public Person(String firstName, String lastName, String nickName, String eMail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.mailAddress = eMail;
    }

    public Person(String firstName, String lastName, String nickName, String mailAddress, Address addressId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.mailAddress = mailAddress;
        this.addressId = addressId;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public Address getAddressId() {
        return addressId;
    }

    public void setAddressId(Address addressId) {
        this.addressId = addressId;
    }
}

