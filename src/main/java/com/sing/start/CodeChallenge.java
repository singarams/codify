package com.sing.start;

import com.sing.model.NamesWithCars;
import com.sing.service.SortOrderService;

import java.util.List;

/**
 * Starter for coding challenge
 */
public class CodeChallenge {

    public static void main(String args[]) throws Exception {

//        final String url = args[0];
        String url = "https://exxzwdkw7i.execute-api.ap-southeast-2.amazonaws.com/test/v1/cars";

        SortOrderService sortOrderService = new SortOrderService();

        List<NamesWithCars> sortedData =  sortOrderService.getOderedData(url);

        Boolean success = sortOrderService.printAndWriteDate(sortedData);

        System.out.println(success ? "Sorting data is successful": "Error occured");

    }

}

