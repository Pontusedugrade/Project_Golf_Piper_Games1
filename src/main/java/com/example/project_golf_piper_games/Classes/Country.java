package com.example.project_golf_piper_games.Classes;

import javax.persistence.*;

@Entity
@Table(name = "country")
public class Country {

    @Column(name = "country_name")

    //Properties

    private String countryName;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private int countryId;

    // Constructor

    public Country() {

    }

    public Country(String countryName, int countryId) {
        this.countryName = countryName;
        this.countryId = countryId;
    }

    //GET AND SET METHODS

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    @Override
    public String toString() {
        return "country{" +
                "countryName='" + countryName + '\'' +
                ", countryId=" + countryId +
                '}';
    }
}


