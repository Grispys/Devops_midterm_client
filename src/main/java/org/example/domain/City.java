package org.example.domain;

public class City {
    private long id;
    private String name;
    private String province;
    private int population;

    public City() {
    }

    public City(String name) {
        this.name = name;
    }

    public City(long id, String name, String province, int population) {
        this.id = id;
        this.name = name;
        this.province = province;
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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
