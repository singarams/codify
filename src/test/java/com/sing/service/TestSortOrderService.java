package com.sing.service;

import com.sing.model.NamesWithCars;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Sort Order testing")
class TestSortOrderService {

    private static List<NamesWithCars> expectedData = new ArrayList<>();

    @BeforeAll
    static void setupTransactionList(){

        expectedData.add(new NamesWithCars("Nissan","X-trail","Melbourne Show"));
        expectedData.add(new NamesWithCars("BMW", "X6", "India Show"));

    }

    @DisplayName("Test if sorting is correct")
    @Test
    void sortingService() throws Exception {
        String expectedData = "[NamesWithCars(make=BMW, model=Black, name=show Matilda), NamesWithCars(make=BMW, model=Green, name=show Andre), NamesWithCars(make=George Motors, model=George 15, name=New York Car Show), NamesWithCars(make=Holden, model=Black, name=show Andre), NamesWithCars(make=Holden, model=Blue, name=show Demetrios), NamesWithCars(make=Hondaka, model=Elisa, name=New York Car Show), NamesWithCars(make=Hondaka, model=Elisa, name=Melb Car Show), NamesWithCars(make=MG, model=Blue, name=show Bradley), NamesWithCars(make=Mercedes, model=Green, name=show Kristin), NamesWithCars(make=Mercedes, model=Yellow, name=show Kristin), NamesWithCars(make=Toyota, model=Blue, name=show Kristin), NamesWithCars(make=Toyota, model=Green, name=show Demetrios), NamesWithCars(make=Toyota, model=Purple, name=show Iva)]";
        SortOrderService sortOrderService = new SortOrderService();
        List<NamesWithCars> namesWithCars =  sortOrderService.getOderedData("https://exxzwdkw7i.execute-api.ap-southeast-2.amazonaws.com/test/v1/cars");
        assertEquals(namesWithCars.toString(), expectedData);
    }


    @DisplayName("Write Data to list testing")
    @Test
    void writeDataToList() {

        SortOrderService sortOrderService = new SortOrderService();
        boolean success = sortOrderService.printAndWriteDate(expectedData);
        assertTrue(success);
    }


}