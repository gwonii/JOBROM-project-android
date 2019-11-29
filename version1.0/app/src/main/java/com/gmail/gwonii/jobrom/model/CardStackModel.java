package com.gmail.gwonii.jobrom.model;

public class CardStackModel {

    private int id;
    private String name;
    private String city;
    private String url;

    public CardStackModel(int id, String name, String city, String url) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "CardStackModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

}
