package org.example.domain;

public class Passenger {

    private String firstName;
    private String lastName;
    private Integer phoneNumber;
    private long id;

    public Passenger(){

    }

    public Passenger(String firstName, String lastName, Integer phoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString(){
        return "Passenger Name: " + firstName + " " + lastName;
    }

}
