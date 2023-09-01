package com.db.cars.controller;

import com.db.cars.dto.CarDTO;
import com.db.cars.dto.DarkModeDTO;
import com.db.cars.model.Car;
import com.db.cars.service.CarService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class CarController {

    @Autowired
    CarService carService;
    @GetMapping("/cars")
    public Map<String, Object> getAllCars(@CookieValue(name = "darkmode", defaultValue = "false") boolean darkMode){
        return carService.getAllCars(darkMode);
    }

    @PutMapping("/dark-mode")
    public ResponseEntity<Void> setDarkMode(@RequestBody Map<String, Boolean> DarkMode, HttpServletResponse response) {
        Boolean darkMode = DarkMode.get("darkMode");

        if (darkMode != null) {
            ResponseCookie springCookie = ResponseCookie.from("darkmode", String.valueOf(darkMode))
                    .path("/")
                    .build();
            return ResponseEntity.ok()
                    .header(HttpHeaders.SET_COOKIE, springCookie.toString()).build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
