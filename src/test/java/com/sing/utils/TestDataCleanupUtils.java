package com.sing.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.stream.JsonReader;
import com.sing.model.NamesWithCars;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Filter the input and get the valid data testing")
class TestDataCleanupUtils {

    private static List<NamesWithCars> validData = new ArrayList<>();
    private static List<NamesWithCars> invalidData = new ArrayList<>();

    @BeforeAll
    static void setupTransactionList(){

        validData.add(new NamesWithCars("Nissan","X-trail","Melbourne Show"));
        validData.add(new NamesWithCars("BMW", "X6", "India Show"));

        invalidData.add(new NamesWithCars("X-trail","Nissan"," "));
        invalidData.add(new NamesWithCars("X-trail"," ","dummy Show"));
        invalidData.add(new NamesWithCars(" ", "BMW", "India Show"));

    }

    @DisplayName("When only Valid data is given as input")
    @Test
    void redeivedDataClueanUpForValidData() throws Exception {
        JsonReader reader = new JsonReader(new FileReader("src/test/resources/DataCleanupUtilsTestValid.json"));
        JsonArray namesWithCarsJson = new Gson().fromJson(reader, JsonArray.class);
        DataCleanupUtils dataCleanupUtils = new DataCleanupUtils();
        List<NamesWithCars> namesWithCarsObject  = dataCleanupUtils.redeivedDataClueanUp(namesWithCarsJson);
        assertEquals(validData.toString(), namesWithCarsObject.toString());
    }

    @DisplayName("When only inValid data is given as input")
    @Test
    void redeivedDataClueanUpForInvalidData() throws Exception {
        JsonReader reader = new JsonReader(new FileReader("src/test/resources/DataCleanupUtilsTestInvalid.json"));
        JsonArray namesWithCarsJson = new Gson().fromJson(reader, JsonArray.class);
        DataCleanupUtils dataCleanupUtils = new DataCleanupUtils();
        Exception exception = assertThrows(Exception.class, () -> {
            dataCleanupUtils.redeivedDataClueanUp(namesWithCarsJson);
        });
        assertEquals("Check the input, Data supplied is invalid", exception.getMessage());
    }

    @DisplayName("When mixed data is given as input")
    @Test
    void redeivedDataClueanUpForMixedData() throws Exception {
        JsonReader reader = new JsonReader(new FileReader("src/test/resources/DataCleanupUtilsTestMixedData.json"));
        JsonArray namesWithCarsJson = new Gson().fromJson(reader, JsonArray.class);
        DataCleanupUtils dataCleanupUtils = new DataCleanupUtils();
        List<NamesWithCars> namesWithCarsObject  = dataCleanupUtils.redeivedDataClueanUp(namesWithCarsJson);
        System.out.println(namesWithCarsObject);
        System.out.println(validData);
        assertEquals(validData.toString(), namesWithCarsObject.toString());
    }





}