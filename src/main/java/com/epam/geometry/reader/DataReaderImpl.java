package com.epam.geometry.reader;

import com.epam.geometry.exception.DataException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataReaderImpl implements DataReader {
    private final String path;
    public DataReaderImpl(String path) {
        this.path = path;
    }
    private Logger logger = LoggerFactory.getLogger(DataReaderImpl.class);

    public List<String> readLines() throws DataException {
        List<String> inputLines = new ArrayList<>();
        try (FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader)){
            while(bufferedReader.ready()){
                String line = bufferedReader.readLine();
                String trimLine = line.trim();
                inputLines.add(trimLine);
            }
        } catch (IOException e) {
            logger.error("DataException has occurred while reading file: " + path, e);
            throw new DataException("Cannot read file", e.getCause());
        }
        return inputLines;
    }
}
