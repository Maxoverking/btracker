package com.example.btracker.Tests;

import org.testng.annotations.Test;

import static com.example.btracker.allClasses.Calculation.calculateBudgetReturn;
import static org.testng.AssertJUnit.assertEquals;

public class CalculateBudgetReturnTests {

    @Test
    public void addPositiveIntegers() {
        int result = calculateBudgetReturn(150, 40);
        assertEquals(190, result);
    }

    @Test
    public void equalBudgetPrice() {
        int result = calculateBudgetReturn(150, 150);
        assertEquals(300, result);
    }

    @Test
    public void positiveBudgetZeroPrice() {
        int result = calculateBudgetReturn(100, 0);
        assertEquals(100, result);
    }
}
