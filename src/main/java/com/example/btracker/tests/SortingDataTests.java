package com.example.btracker.tests;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.btracker.sortingData.SortingData.convertMap;
import static org.testng.AssertJUnit.assertEquals;

public class SortingDataTests {

    @Test
    public void sortDownTests() {
        Map<String, List<String>> budgetByMonth = new HashMap<>();
        List<String> cat = new ArrayList<>();
        cat.add("INCOME=150");
        cat.add("FOOD=50");
        cat.add("HOUSE=70");
        cat.add("TRANSPORT=90");

        budgetByMonth.put("december",cat);

        List<String> expexted = new ArrayList<>();
        expexted.add("FOOD=50");
        expexted.add("HOUSE=70");
        expexted.add("TRANSPORT=90");

        List<String> result;
        result = convertMap(budgetByMonth, "december",false);

        assertEquals(expexted, result);
    }

    @Test
    public void sortUpTests() {
        Map<String, List<String>> budgetByMonth = new HashMap<>();
        List<String> cat = new ArrayList<>();
        cat.add("INCOME=150");
        cat.add("FOOD=50");
        cat.add("HOUSE=70");
        cat.add("TRANSPORT=90");

        budgetByMonth.put("december", cat);

        List<String> expexted = new ArrayList<>();
        expexted.add("TRANSPORT=90");
        expexted.add("HOUSE=70");
        expexted.add("FOOD=50");

        List<String> result;
        result = convertMap(budgetByMonth, "december", true);

        assertEquals(expexted, result);
    }

}
