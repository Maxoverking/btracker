package com.example.btracker.collectData;


import org.testng.annotations.Test;

import java.util.List;

import static com.example.btracker.collectData.CollectData.collectData;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CollectDataTests {

    @Test

    public void fillList() {
        List<String> list = collectData(10, 20, 40,50,
                70, 80, 10);
        int result = list.size();

        assertEquals(7, result);
    }

    @Test

    public void checkListsElement() {
        List<String> list = collectData(10, 20, 40,50,
                70, 80, 10);
        String result = list.get(0);

        assertEquals("INCOME=10", result);
    }
}