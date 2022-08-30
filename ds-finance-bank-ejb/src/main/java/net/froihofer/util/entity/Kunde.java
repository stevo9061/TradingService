package net.froihofer.util.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Kunde")
public class Kunde implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "STREET")
    private String street;
    @Column(name = "HOUSENO")
    private String houseNo;
    @Column(name = "PLACE")
    private String place;
    @Column(name = "ZIPCODE")
    private Integer zipCode;



    //ID
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void Kunde(){
        this.firstName = "default_firstName";
        this.lastName = "default_lastName";
        this.street = "default_street";
        this.houseNo = "default_houseNo";
        this.place = "default_place";
        this.zipCode = 0000;

    }

    //FirstName
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //LastName
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //Street
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    //HouseNumber
    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    //Place
    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    //Place
    public Integer getZipcode() {
        return zipCode;
    }

    public void setZipcode(Integer zipCode) {
        this.zipCode = zipCode;
    }

}