package com.example.project_golf_piper_games.Classes;

import javax.persistence.*;

@Entity
@Table(name = "adress")

public class Address {


    //Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adress_id")
    private int addressId;

    @Column(name = "adress")
    private String address;

    @Column(name = "zip")
    private int zip;

    //Foreign key:

    @ManyToOne
    @JoinColumn(name = "city_id")
    private PostalAddress cityId;

    // Constructor
    public Address() {
    }

    public Address(String address, int zip, PostalAddress cityId) {
        this.address = address;
        this.zip = zip;
        this.cityId = cityId;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public PostalAddress getCityId() {
        return cityId;
    }

    public void setCityId(PostalAddress cityId) {
        this.cityId = cityId;
    }

}
