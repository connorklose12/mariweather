// package com.example.demo;

// import org.springframework.web.bind.annotation.*;
// import org.springframework.web.client.RestTemplate;

// @RestController
// @RequestMapping("/api")
// //the main Java file
// public class WeatherController {

//     private final RestTemplate restTemplate = new RestTemplate();

//     @GetMapping("/weather")
//     public String getWeather(@RequestParam String city) {
//         // Step 1: Turn city name into lat/lon (US only)
//         String geoUrl = "https://geocoding-api.open-meteo.com/v1/search?name="
//                 + city + "&count=1&country=US";
//         String geoResponse = restTemplate.getForObject(geoUrl, String.class);

//         if (geoResponse == null || !geoResponse.contains("\"latitude\"")) {
//             return "{\"error\":\"City not found\"}";
//         }

//         double lat = extractNumber(geoResponse, "\"latitude\":");
//         double lon = extractNumber(geoResponse, "\"longitude\":");
//         String name = extractName(geoResponse);

//         // Step 2: Get current weather for that location
//         String weatherUrl = "https://api.open-meteo.com/v1/forecast?latitude="
//                 + lat + "&longitude=" + lon
//                 + "&current_weather=true&temperature_unit=fahrenheit";
//         String weatherResponse = restTemplate.getForObject(weatherUrl, String.class);

//         return "{\"city\":\"" + name + "\",\"weather\":" + weatherResponse + "}";
//     }

//     private double extractNumber(String json, String key) {
//         int start = json.indexOf(key) + key.length();
//         int end = json.indexOf(",", start);
//         return Double.parseDouble(json.substring(start, end).trim());
//     }

//     private String extractName(String json) {
//         int start = json.indexOf("\"name\":\"") + 8;
//         int end = json.indexOf("\"", start);
//         return json.substring(start, end);
//     }
// }