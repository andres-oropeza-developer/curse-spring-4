package com.udemy.backendninja.crudcontacts.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;

@Entity
@Table(name = "contact")
public class ContactEntity {

    @Id
    @GeneratedValue
    @Column(name="id", unique = true, nullable = false)
    private int id;

    @Column(name="first_name", nullable = false, length = 80)
    private String firstName;

    @Column(name="last_name", nullable = false, length = 80)
    private String lastName;

    @Column(name="phone", nullable = false, length = 9)
    private int phone;

    @Column(name="city", nullable = false, length = 250)
    private String city;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public ContactEntity(int id, String firstName, String lastName, int phone, String city) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.city = city;
    }

    public ContactEntity() {
    }

    @Override
    public String toString() {
        return "ContactEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone=" + phone +
                ", city='" + city + '\'' +
                '}';
    }
}
