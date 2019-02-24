package com.sing.algorithms;

import com.sing.model.NamesWithCars;

import java.util.*;

/**
 * Algorithms
 */
public class OrderByShow {

    /**
     * Sorting by Make and then by Model
     * @param data
     * @return sorted data list
     */
    public List<NamesWithCars> doSortingByShow(final List<NamesWithCars> data) {
        //sorting first by car and then by color and returns the list
        Collections.sort(data, Comparator.comparing(NamesWithCars::getMake)
                .thenComparing(NamesWithCars::getModel));
        return data;
    }
}
