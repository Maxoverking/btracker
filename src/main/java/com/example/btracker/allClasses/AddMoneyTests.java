package com.example.btracker.allClasses;

import com.example.btracker.exception.CustomException;
import org.testng.annotations.Test;

import static com.example.btracker.allClasses.Calculation.addMoney;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class AddMoneyTests {

    @Test
    public void positiveIntegers() {
        int result = addMoney(10, 20, 100);
        assertEquals(30, result);
    }

    @Test
    public void PriceMinus() {
        boolean exceptionThrown = false;
        try {
            addMoney(-500, 100, 200);
        } catch (CustomException e) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }

    @Test
    public void PriceZero() {
        boolean exceptionThrown = false;
        try {
            addMoney(0, 100, 200);
        } catch (CustomException e) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }

    @Test
    public void PriceGreaterBudget() {
        boolean exceptionThrown = false;
        try {
            addMoney(500, 100, 200);
        } catch (CustomException e) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }
}
