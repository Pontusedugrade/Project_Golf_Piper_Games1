package com.example.project_golf_piper_games.Classes;

import javax.persistence.*;


@Entity
@Table(name = "employee")

public class Employee {

    //Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int employeeId;

    //FK
    @OneToOne
    @JoinColumn(name = "person_id")
    private Person personId;

    //private String firstName;

    //Constructor
    public Employee() {

    }

    public Employee(Person personId) {
        this.personId = personId;

    }



    //METHODS


    //GETTER AND SETTER METHODS


    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    public String getEmployeeFirstName() {
        return this.personId.getFirstName();
    }

    public String getEmployeeLastName(){
        return this.personId.getLastName();
    }

    public String getEmployeeNickName(){
        return this.personId.getNickName();
    }

    public String getEmployeeMailAddress(){
        return this.personId.getMailAddress();
    }

    public String getEmployeeAddress(){
        return this.personId.getAddressId().getAddress();
    }

    public int getEmployeeZip(){
        return this.personId.getAddressId().getZip();
    }

    public String getEmployeeCity(){
        return this.personId.getAddressId().getCityId().getCity();
    }

    public String getEmployeeCountry(){
        return this.personId.getAddressId().getCityId().getCountryId().getCountryName();
    }

    public int getCountryId() {
        return this.personId.getAddressId().getCityId().getCountryId().getCountryId();
    }
}

