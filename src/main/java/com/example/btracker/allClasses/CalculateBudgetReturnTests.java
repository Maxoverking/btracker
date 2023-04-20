package com.example.btracker.allClasses;

import com.example.btracker.exception.CustomException;
import org.testng.annotations.Test;

import static com.example.btracker.allClasses.Calculation.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

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

    @Test
    public void PriceMinus() {
        boolean exceptionThrown = false;
        try {
            calculateBudgetReturn(500, -100);
        } catch (CustomException e) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }
}
