package com.example.btracker.Tests;

import com.example.btracker.correctMonth.CorrectMonth;
import com.example.btracker.exception.CustomException;
import org.testng.annotations.Test;



import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;


public class CorrectMonthTests {
    @Test
    public void returnMonth() {
        String result = CorrectMonth.correctMonth("may");
        assertEquals("may", result);
    }

    @Test
    public void returnExceptionEmptyMonth() {
        boolean exceptionThrown = false;
        try {
            CorrectMonth.correctMonth("");
        } catch (CustomException e) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }

    @Test
    public void returnExceptionWrongMonth() {
        boolean exceptionThrown = false;
        try {
            CorrectMonth.correctMonth("sdfsf");
        } catch (CustomException e) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }
}
