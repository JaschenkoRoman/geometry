package com.epam.geometry.director;

import com.epam.geometry.entity.Cone;
import com.epam.geometry.entity.Point;
import com.epam.geometry.exception.DataException;
import com.epam.geometry.exception.ParseException;
import com.epam.geometry.parser.DataParser;
import com.epam.geometry.reader.DataReader;
import com.epam.geometry.validator.ConeValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ConeDirector {
    private DataReader dataReaderImpl;
    private DataParser coneParser;
    private ConeValidator coneValidator;
    private Logger logger = LoggerFactory.getLogger(ConeDirector.class);

    public ConeDirector(DataReader dataReaderImpl, DataParser coneParser, ConeValidator coneValidator) {
        this.dataReaderImpl = dataReaderImpl;
        this.coneParser = coneParser;
        this.coneValidator = coneValidator;
    }

    public List<Cone> process() throws DataException, ParseException {
        logger.info("process() method of " + this.toString() + " has been launched");
        List<String> inputLines = dataReaderImpl.readLines();
        List<double[]> cones = coneParser.parse(inputLines);
        List<Cone> conesList = createValidCones(cones);
        return conesList;
    }

    private List<Cone> createValidCones(List<double[]> cones){
        List<Cone> conesList = new ArrayList<Cone>();
        for (double[] coneData: cones) {
            if(coneValidator.isCone(coneData)){
                Point point = new Point(coneData[0], coneData[1], coneData[2]);
                Cone cone = new Cone(point, coneData[3], coneData[4]);
                conesList.add(cone);
            }
        }
        return conesList;
    }
}
