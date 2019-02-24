package com.sing.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.sing.algorithms.OrderByShow;
import com.sing.model.NamesWithCars;
import com.sing.utils.DataCleanupUtils;
import com.sing.utils.HttpUtils;

import java.io.IOException;
import java.util.List;

/**
 * Service Class for forming process
 *
 */
public class SortOrderService {


    /**
     *
     * Supplies the URL and gets the sorted data
     * @param url
     * @return
     * @throws Exception
     */
    public List<NamesWithCars> getOderedData(final String url) throws Exception {

        final HttpResponse<JsonNode> response = getHttpUtils().getResponseEntity(url);

        //data received from external system
        final JsonArray receivedData = new JsonParser().parse(String.valueOf(response.getBody())).getAsJsonArray();

        //data to clean the empty values
        //Assumption not considering the empty values for sorting
        final List<NamesWithCars> cleanedDatas = getDataCleanupUtils().redeivedDataClueanUp(receivedData);


        //sorting by Brand and then by color
        final List<NamesWithCars> sortedData = getOrderByShow().doSortingByShow(cleanedDatas);

        //Contains the Sorted data
        return sortedData;

    }



    protected HttpUtils getHttpUtils() {
        return new HttpUtils();
    }

    protected DataCleanupUtils getDataCleanupUtils() {
        return new DataCleanupUtils();
    }

    protected OrderByShow getOrderByShow() { return new OrderByShow(); }

    public Boolean printAndWriteDate(final List<NamesWithCars> sortedData) {

        return WriteDataToFileService.writeData(sortedData);

    }
}
