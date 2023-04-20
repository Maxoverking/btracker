package com.example.btracker.allClasses;

import com.example.btracker.exception.CustomException;
import org.testng.annotations.Test;

import static com.example.btracker.allClasses.Calculation.calculateBudget;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

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

    @Test
    public void negativeBudget() {
        boolean exceptionThrown = false;
        try {
            calculateBudget(-500, 100);
        } catch (CustomException e) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }

    @Test
    public void zeroBudget() {
        boolean exceptionThrown = false;
        try {
            calculateBudget(0, 100);
        } catch (CustomException e) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }

    @Test
    public void priceGreaterBudget() {
        boolean exceptionThrown = false;
        try {
            calculateBudget(20, 100);
        } catch (CustomException e) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }
}
