package com.example.btracker.allClasses;

import org.testng.annotations.Test;

import static com.example.btracker.allClasses.Calculation.calculateBudget;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculateBudgetTests {

    @Test
    public void addPositiveIntegers() {
        int result = calculateBudget(150, 40);
        assertEquals(110, result);
    }

    @Test
    public void equalBudgetPrice() {
        int result = calculateBudget(150, 150);
        assertEquals(0, result);
    }

    @Test
    public void positiveBudgetZeroPrice() {
        int result = calculateBudget(100, 0);
        assertEquals(100, result);
    }
}
