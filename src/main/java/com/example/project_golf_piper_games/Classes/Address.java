package com.example.project_golf_piper_games.Classes;

import javax.persistence.*;

@Entity
@Table(name = "adress")

public class Address {


    //Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adress_id")
    private int adressId;

    @Column(name = "adress")
    private String adress;

    @Column(name = "zip")
    private int zip;

    //Foreign key:

    @ManyToOne
    @JoinColumn(name = "city_id")
    private PostalAddress CityId;

    //Constructor

    public Address() {

    }

    public Address(int adressId, String adress, int zip) {
        this.adressId = adressId;
        this.adress = adress;
        this.zip = zip;

    }


    // Methods


    //SET AND GET METHODS
    public int getAdressId() {
        return adressId;
    }

    public void setAdressId(int adressId) {
        this.adressId = adressId;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public PostalAddress getCityId() {
        return CityId;
    }

    public void setCityId(PostalAddress cityId) {
        CityId = cityId;
    }

    @Override
    public String toString() {
        return "address{" +
                "adressId=" + adressId +
                ", adress='" + adress + '\'' +
                ", zip=" + zip +
                ", CityId=" + CityId +
                '}';
    }
}
