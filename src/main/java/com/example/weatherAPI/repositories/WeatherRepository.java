package com.example.weatherAPI.repositories;

import com.example.weatherAPI.models.Weather;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WeatherRepository extends CrudRepository<Weather,Long> {
    @Query("SELECT w FROM Weather w WHERE w.country = :country")
    List<Weather> findByCountry(String country);

    @Query("SELECT w FROM Weather w WHERE w.temprature >= :temp")
    List<Weather> findByTemp(double temp);

    @Query("SELECT w FROM Weather w WHERE w.humidity >= :humi")
    List<Weather> findByHumidity(double humi);

    @Query("SELECT w FROM Weather w WHERE w.city = :city")
    List<Weather> findCityTemprature(String city);

    @Query("SELECT w FROM Weather w WHERE w.id = :id")
    Weather findById(int id);
}

