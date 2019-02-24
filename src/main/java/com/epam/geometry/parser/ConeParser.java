package com.epam.geometry.parser;

import com.epam.geometry.exception.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ConeParser implements DataParser {

    private static final String SPLIT_REGEX = " ";
    private static final int DOUBLE_QUANTITY = 5;
    private static String DOUBLE_REGEX = "-?\\d+(\\.\\d+)?";
    private Logger logger = LoggerFactory.getLogger(ConeParser.class);

    public List<double[]> parse(List<String> inputLines) throws ParseException {
        if(inputLines.size() == 0) {
            logger.error("ParseException has occurred: input is empty");
            throw new ParseException("Input is empty");
        }
        List<double[]> coneData = new ArrayList<>();
        for (String line: inputLines) {
            String[] inputDoubles = line.split(SPLIT_REGEX);
                if(checkDoubles(inputDoubles)) {
                    double[] doublesArray = stringArrayToDoubleArray(inputDoubles);
                    coneData.add(doublesArray);
                }
        }
        if(coneData.size() == 0) {
            logger.error("ParseException has occurred: input does not have valid lines");
            throw new ParseException("Input does not have valid lines");
        }
        return coneData;
    }
    private boolean checkDoubles(String[] inputDoubles) {
        boolean areValid = true;
        if(inputDoubles.length >= DOUBLE_QUANTITY) {
            for (int i = 0; i <DOUBLE_QUANTITY && areValid; i++) {
                areValid = inputDoubles[i].matches(DOUBLE_REGEX);
            }
        } else {
            areValid = false;
        }

        return areValid;
    }
    private double[] stringArrayToDoubleArray(String[] inputDoubles){
        double[] doublesArray = new double[DOUBLE_QUANTITY];
        for (int i = 0; i < DOUBLE_QUANTITY; i++) {
            String inputDouble = inputDoubles[i];
            double data = Double.parseDouble(inputDouble);
            doublesArray[i] = data;
        }
        return doublesArray;
    }


}
