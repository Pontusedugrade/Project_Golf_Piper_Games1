package com.example.project_golf_piper_games.Classes;

import javax.persistence.*;

@Entity
@Table(name = "postal_adress")

public class PostalAddress {

    //Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private int cityId;

    //Foreign KEY:
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country countryId;

    @Column(name = "city")
    private String city;

    //Constructor

    public PostalAddress() {

    }

    public PostalAddress(int cityId, int countryId, String city) {
        this.cityId = cityId;
        this.city = city;
    }

    //METHODS


    //GETTER AND SETTER METHODS


    public int getEmployeeId() {
        return cityId;
    }

    public void setEmployeeId(int employeeId) {
        this.cityId = employeeId;
    }

    public Country getCountryId() {
        return countryId;
    }

    public void setCountryId(Country countryId) {
        this.countryId = countryId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "postalAddress{" +
                "employeeId=" + cityId +
                ", countryId=" + countryId +
                ", city='" + city + '\'' +
                '}';
    }
}

