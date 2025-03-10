package org.example.domain;

public class Airport {

    private long id;
    private String name;
    private String code;

    public Airport() {
    }

    public Airport(String code) {
        this.code = code;
    }

    public Airport(long id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString(){
        return "\u001B[31m" + "Airport: " + "\u001B[97m" +  name + "," + "\u001B[31m"+ "Code: " +  "\u001B[97m" + code;
    }
}
