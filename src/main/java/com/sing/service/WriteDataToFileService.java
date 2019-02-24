package com.sing.service;

import com.sing.model.NamesWithCars;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Writes the data to file and prints the data to console
 */
public class WriteDataToFileService {

    private static String make = null;
    private static String model = null;
    private static final String TABSPACE = "\t";

    /**
     *
     * @param sortedData
     * @return
     */
    public static Boolean writeData(final List<NamesWithCars> sortedData) throws IOException {

        Boolean success = false;

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("./output-" + System.currentTimeMillis() + ".txt")))) {

            for (NamesWithCars namesWithCars : sortedData) {

                if (make == null && model == null) {

                  printCompleteData(namesWithCars, bufferedWriter);

                } else if (make != null && make.equalsIgnoreCase(namesWithCars.getMake()) && model.equalsIgnoreCase(namesWithCars.getModel()) ) {

                    printData(new StringBuilder().append(TABSPACE).append(TABSPACE).append(namesWithCars.getName()).toString(), bufferedWriter);

                } else if(make != null && make.equalsIgnoreCase(namesWithCars.getMake()) && !model.equalsIgnoreCase(namesWithCars.getModel())){

                    printData(new StringBuilder().append(TABSPACE).append(namesWithCars.getModel()).toString(), bufferedWriter);
                    printData(new StringBuilder().append(TABSPACE).append(TABSPACE).append(namesWithCars.getName()).toString(), bufferedWriter);

                } else if (make != null && !make.equalsIgnoreCase(namesWithCars.getMake()) && !model.equalsIgnoreCase(namesWithCars.getModel())) {

                    printCompleteData(namesWithCars, bufferedWriter);

                }

                success = true;
            }
        }

        return success;
    }

    /**
     * Prints the Entire data to console
     * @param namesWithCars
     * @param bufferedWriter
     * @throws IOException
     */
    private static void printCompleteData(NamesWithCars namesWithCars, BufferedWriter bufferedWriter) throws IOException {
        make = namesWithCars.getMake();
        model = namesWithCars.getModel();
        printData(namesWithCars.getMake(), bufferedWriter);
        printData(new StringBuilder().append(TABSPACE).append(namesWithCars.getModel()).toString(), bufferedWriter);
        printData(new StringBuilder().append(TABSPACE).append(TABSPACE).append(namesWithCars.getName()).toString(), bufferedWriter);
    }

    /**
     * Writes the data to console
     *
     * @param data
     * @param bufferedWriter
     * @throws IOException
     */
    private static void printData(String data, BufferedWriter bufferedWriter) throws IOException {
        bufferedWriter.write("\n" + data);
        System.out.println(data);
    }
}
