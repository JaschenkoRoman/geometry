package com.epam.geometry.parser;

import com.epam.geometry.exception.ParseException;

import java.util.List;

public interface DataParser {
        List<double[]> parse(List<String> input) throws ParseException;
}
