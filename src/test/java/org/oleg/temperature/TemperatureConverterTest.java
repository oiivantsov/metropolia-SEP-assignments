package org.oleg.temperature;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TemperatureConverterTest {

    private final TemperatureConverter converter = new TemperatureConverter();

    @Test
    void testFahrenheitToCelsius() {
        assertEquals(0, converter.fahrenheitToCelsius(32), 0.001);
        assertEquals(100, converter.fahrenheitToCelsius(212), 0.001);
        assertEquals(-40, converter.fahrenheitToCelsius(-40), 0.001);
    }

    @Test
    void testCelsiusToFahrenheit() {
        assertEquals(32, converter.celsiusToFahrenheit(0), 0.001);
        assertEquals(212, converter.celsiusToFahrenheit(100), 0.001);
        assertEquals(-40, converter.celsiusToFahrenheit(-40), 0.001);
    }

    @Test
    void testIsExtremeTemperature() {
        assertTrue(converter.isExtremeTemperature(-50));  // Below -40°C
        assertTrue(converter.isExtremeTemperature(60));   // Above 50°C
        assertFalse(converter.isExtremeTemperature(20));  // Normal temperature
        assertFalse(converter.isExtremeTemperature(-40)); // Exactly -40°C (not extreme)
        assertFalse(converter.isExtremeTemperature(50));  // Exactly 50°C (not extreme)
    }
}

