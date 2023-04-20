package com.example.btracker.allClasses;

import com.example.btracker.exception.CustomException;
import org.testng.annotations.Test;

import static com.example.btracker.allClasses.Calculation.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class ReturnMoneyTests {

    @Test
    public void positiveIntegers() {
        int result = returnMoney(100, 10);
        assertEquals(90, result);
    }

    @Test
    public void priceGreaterBudget() {
        boolean exceptionThrown = false;
        try {
            returnMoney(100, 1000);
        } catch (CustomException e) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }

    @Test
    public void BudgetZero() {
        boolean exceptionThrown = false;
        try {
            returnMoney(0, 100);
        } catch (CustomException e) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }

    @Test
    public void BudgetMinus() {
        boolean exceptionThrown = false;
        try {
            returnMoney(-5, 100);
        } catch (CustomException e) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }

    @Test
    public void PriceMinus() {
        boolean exceptionThrown = false;
        try {
            returnMoney(500, -100);
        } catch (CustomException e) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }
}
