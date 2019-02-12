package com.epam.geometry.reader;

import com.epam.geometry.exception.DataException;

import java.util.List;

public interface DataReader {
    List<String> readLines()throws DataException;
}
