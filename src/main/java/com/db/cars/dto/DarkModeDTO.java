package com.db.cars.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class DarkModeDTO {
    private boolean darkMode;
    public boolean isDarkMode() {
        return darkMode;
    }
}
