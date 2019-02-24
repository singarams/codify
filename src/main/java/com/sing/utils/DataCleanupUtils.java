package com.sing.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.sing.model.Car;
import com.sing.model.NamesWithCars;
import com.sing.model.ReceivedDataObjectMapper;
import com.google.common.base.Strings;
import org.apache.commons.lang3.StringUtils;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.apache.commons.lang3.StringUtils.SPACE;

public class DataCleanupUtils {

    /**
     * Checks for empty objects and removes it from processing
     *  NOTE: If any of `Name` or `make` or `model` is empty or not present then those objects will `NOT` be considered for sorting
     *
     * @param receivedData
     * @return cleaned data by processing
     */
    public List<NamesWithCars> redeivedDataClueanUp(JsonArray receivedData) throws Exception {

        List<NamesWithCars> cleanedDatas = new ArrayList();
        //iterates each data to check for empty values
        for (JsonElement data: receivedData) {

            ReceivedDataObjectMapper receivedDataObjectMapper = new Gson().fromJson(data.getAsJsonObject(), ReceivedDataObjectMapper.class);

            for (Car car: receivedDataObjectMapper.getCars()) {

                //Ignore the empty values
                if(!Stream.of(receivedDataObjectMapper.getName(),
                        car.getMake(),
                        car.getModel()).anyMatch(Strings::isNullOrEmpty) &&
                        !receivedDataObjectMapper.getName().equalsIgnoreCase(SPACE) &&
                        !car.getMake().equalsIgnoreCase(SPACE) &&
                        !car.getModel().equalsIgnoreCase(SPACE)) {

                    //Create a new object and assign the values
                    NamesWithCars namesWithCars = new NamesWithCars();
                    namesWithCars.setName(receivedDataObjectMapper.getName().trim());
                    namesWithCars.setMake(car.getMake().trim());
                    namesWithCars.setModel(car.getModel().trim());
                    cleanedDatas.add(namesWithCars);

                }
            }
        }

        //THrow the error if the entire data supplied is invalid
        if(cleanedDatas.isEmpty()) {
            throw new Exception("Check the input, Data supplied is invalid");
        }

        //Returns the cleaned data that doesn't have empty values
        return cleanedDatas;
    }
}
