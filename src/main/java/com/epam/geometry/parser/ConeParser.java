package com.epam.geometry.parser;

import com.epam.geometry.exception.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ConeParser implements DataParser {

    private static final String REGEX = " ";
    private Logger logger = LoggerFactory.getLogger(ConeParser.class);

    public List<double[]> parse(List<String> inputLines) throws ParseException {
        if(inputLines.size() == 0){
            logger.error("ParseException has occurred: input is empty");
            throw new ParseException("Input is empty");
        }
        List<double[]> coneData = new ArrayList<>();
        for (String line: inputLines) {
            String[] doubles = line.split(REGEX);
            double[] doublesArray = new double[5];
                try {
                    for (int i = 0; i < 5; i++) {
                    double data = Double.parseDouble(doubles[i]);
                    doublesArray[i] = data;
                }
                    coneData.add(doublesArray);
                } catch (Exception ignore) {
                    /*NOP*/
                }

        }
        if(coneData.size() == 0){
            logger.error("ParseException has occurred: input does not have valid lines");
            throw new ParseException("Input does not have valid lines");
        }
        return coneData;
    }

}
