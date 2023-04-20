
package com.example.btracker.correctMonth;


import com.example.btracker.exception.CustomException;
import org.testng.annotations.Test;

import static com.example.btracker.correctMonth.CorrectMonth.correctMonth;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class CorrectMonthTests {

    @Test

    public void returnMonth() {
        String result = correctMonth("may");

        assertEquals("may", result);
    }

    @Test

    public void returnEmptyMonthException() {
        boolean exceptionThrown = false;
        try {
            correctMonth("");
        } catch (CustomException e) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }

    @Test

    public void returnWrongMonthException() {
        boolean exceptionThrown = false;
        try {
            correctMonth("ghhd");
        } catch (CustomException e) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }

}
