package com.db.cars.service;

import com.db.cars.dto.CarDTO;
import com.db.cars.model.Car;
import com.db.cars.repository.CarRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CarService {
    @Autowired
    CarRepository carRepository;


    public Map<String, Object> getAllCars(boolean darkMode) {
        List<Car> cars = carRepository.findAll();
        List<Map<String, String>> carList = new ArrayList<>();

        for (Car car : cars) {
            Map<String, String> carFinal = new HashMap<>();
            carFinal.put("name", car.getName());
            carFinal.put("model", car.getModel());
            carList.add(carFinal);
        }

        Map<String, Object> result = new HashMap<>();
        result.put("darkMode", darkMode);
        result.put("cars", carList);

        return result;
    }
}
