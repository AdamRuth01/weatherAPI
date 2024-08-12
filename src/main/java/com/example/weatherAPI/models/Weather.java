package com.example.weatherAPI.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Weather")
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;


    String country;
    String city;
    String description;
    double temprature;
    double wind_M_S;
    double humidity;
    String feelsLike;


    public Weather() {
    }
    public Weather(String country, String city, String description, double temprature, double wind_M_S, double humidity, String feelsLike) {
        this.country = country;
        this.city = city;
        this.description = description;
        this.temprature = temprature;
        this.wind_M_S = wind_M_S;
        this.humidity = humidity;
        this.feelsLike = feelsLike;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTemprature() {
        return temprature;
    }

    public void setTemprature() {
        this.temprature = temprature;
    }

    public double getWind_M_S() {
        return wind_M_S;
    }

    public void setWind_M_S(double wind_M_S) {
        this.wind_M_S = wind_M_S;
    }

    public double getHumidity() {
        return this.humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public String getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(String feelsLike) {
        this.feelsLike = feelsLike;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Weather{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", description='" + description + '\'' +
                ", temprature=" + temprature +
                ", wind_M_S=" + wind_M_S +
                ", humidity=" + humidity +
                ", feelsLike='" + feelsLike + '\'' +
                '}';
    }
}

