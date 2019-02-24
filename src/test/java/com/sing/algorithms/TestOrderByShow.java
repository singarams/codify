package com.sing.algorithms;

import com.sing.model.NamesWithCars;
import com.sing.start.CodeChallenge;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@DisplayName("Algorithm - Order By Show Test")
class TestOrderByShow {

    @DisplayName("Do sorting by show")
    @Test
    void doSortingByShow() {


        NamesWithCars namesWithCars1 = new NamesWithCars();
        namesWithCars1.setName("Melbourne Show");
        namesWithCars1.setMake("Nissan");
        namesWithCars1.setModel("Qashqai");

        NamesWithCars namesWithCars2 = new NamesWithCars();
        namesWithCars2.setName("Sydney Show");
        namesWithCars2.setMake("Nissan");
        namesWithCars2.setModel("x-trail");

        NamesWithCars namesWithCars3 = new NamesWithCars();
        namesWithCars3.setName("Melbourne Show");
        namesWithCars3.setMake("Porsche");
        namesWithCars3.setModel("Cayenne");

        List<NamesWithCars> inputData = new ArrayList<>();

        inputData.add(namesWithCars1);
        inputData.add(namesWithCars2);
        inputData.add(namesWithCars3);

        OrderByShow orderByShow = new OrderByShow();

        List<NamesWithCars> s = orderByShow.doSortingByShow(inputData);

//        System.out.println(s);

        Assertions.assertEquals(namesWithCars1, s.get(0));
        Assertions.assertEquals(namesWithCars2, s.get(1));
        Assertions.assertEquals(namesWithCars3, s.get(2));



    }

//    @Test
//    void abc(){
//        CodeChallenge codeChallenge = new CodeChallenge().getClass().getin;
//        codeChallenge
//    }
}