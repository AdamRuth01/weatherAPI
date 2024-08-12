package com.example.weatherAPI.controllers;

import com.example.weatherAPI.exception.MissingForecastException;
import com.example.weatherAPI.models.Weather;
import com.example.weatherAPI.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@RequestMapping(path = "/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    // GET: Display all weather data
    @GetMapping
    public String getAllWeathers(Model model) {
        Iterable<Weather> result = weatherService.getAllWeathers();
        model.addAttribute("forecasts", result);
        return "allCities"; // Returns the "allCities.html" template
    }


    @GetMapping("/{country}/cities")
    public String getByCountry(@PathVariable String country, Model model) {
        Collection<Weather> result = (Collection<Weather>) weatherService.getByCountry(country);
        if (result.isEmpty()) {
            throw new MissingForecastException("No weather data found for country: " + country);
        }
        model.addAttribute("forecasts", result);
        return "allCities"; // Returns the "allCities.html" template
    }


    @GetMapping("/add")
    public String showAddWeatherForm(Model model) {
        model.addAttribute("weather", new Weather());
        return "addWeather"; // Returns the "addWeather.html" template
    }


    @PostMapping
    public String postWeather(@ModelAttribute Weather weather, Model model) {
        weatherService.createWeather(weather);
        return "redirect:/weather"; // Redirects to the list of weather data
    }


    @GetMapping("/update/{id}")
    public String showUpdateWeatherForm(@PathVariable Long id, Model model) {
        Weather weather = weatherService.getByCity_Id(id.toString());
        if (weather == null) {
            throw new MissingForecastException("No weather data found for ID: " + id);
        }
        model.addAttribute("weather", weather);
        return "updateWeather"; // Returns the "updateWeather.html" template
}


    @PostMapping("/update/{id}")
    public String updateWeather(@PathVariable String id, @ModelAttribute Weather weather, Model model) {
        weatherService.updateWeatherById(weather);
        return "redirect:/weather";
        // weatherService.updateWeatherById(Long.valueOf(id), weather);
    }


    @GetMapping("/delete/{id}")
    public String deleteWeather(@PathVariable Long id) {
        weatherService.deleteWeatherById(id);
        return "redirect:/weather";
    }

    @ExceptionHandler(MissingForecastException.class)
    public ResponseEntity<String> handleCustomeException(final MissingForecastException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
