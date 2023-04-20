package com.example.btracker.tests;

import static com.example.btracker.allClasses.Calculation.calculateIncome;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculateIncomeTests {

    @Test
    public void addPositiveIntegers() {
        int result = calculateIncome(150, 40);
        assertEquals(110, result);
    }

    @Test
    public void equalBudgetPrice() {
        int result = calculateIncome(150, 150);
        assertEquals(0, result);
    }

    @Test
    public void positiveBudgetZeroPrice() {
        int result = calculateIncome(100, 0);
        assertEquals(100, result);
    }
}
