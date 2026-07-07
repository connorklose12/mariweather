package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	private final RestTemplate restTemplate = new RestTemplate();

	// Returns list of matching cities as raw JSON (just passthrough)
	@GetMapping("/api/cities")
	public String searchCities(@RequestParam String query) {
		String geoUrl = "https://geocoding-api.open-meteo.com/v1/search?name="
				+ query + "&count=10&country=US";
		return restTemplate.getForObject(geoUrl, String.class);
	}

@GetMapping("/api/weather")
public String getWeather(@RequestParam double lat, @RequestParam double lon) {
	String weatherUrl = "https://api.open-meteo.com/v1/forecast?latitude="
			+ lat + "&longitude=" + lon
			+ "&current_weather=true&current=apparent_temperature&temperature_unit=fahrenheit";
	return restTemplate.getForObject(weatherUrl, String.class);
}
}