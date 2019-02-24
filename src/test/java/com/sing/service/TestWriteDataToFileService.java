package com.sing.service;

import com.sing.model.NamesWithCars;
import com.sing.utils.DataCleanupUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;

class TestWriteDataToFileService {

    @DisplayName("Trying to write and print simple data")
    @Test
    void writeDataSuccess()  throws IOException {
        List<NamesWithCars> validData = new ArrayList<>();
        validData.add(new NamesWithCars("Nissan","X-trail","Melbourne Show"));
        Boolean success = WriteDataToFileService.writeData(validData);
        assertTrue(success);

    }

    @DisplayName("No data to write")
    @Test
    void writeDataFailed() throws IOException {
        List<NamesWithCars> validData = new ArrayList<>();
        Boolean success = WriteDataToFileService.writeData(validData);
        assertFalse(success);

    }

    @DisplayName("Trying to write and print complex data")
    @Test
    void writeDatacomplexData() throws IOException {
        List<NamesWithCars> validData = new ArrayList<>();
        validData.add(new NamesWithCars("Nissan","X-trail","Melbourne Show"));
        validData.add(new NamesWithCars("Nissan","X-trail","India Show"));
        validData.add(new NamesWithCars("Audi","Q5","Endland Show"));
        validData.add(new NamesWithCars("Audi","Q3","Endland Show"));
        Boolean success = WriteDataToFileService.writeData(validData);
        assertTrue(success);

    }
}