package edu.austral.ingsis.math.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Number implements Function {
    private final Double value;

    public Number(Double value) {
        this.value = value;
    }

    @Override
    public Double evaluate(Map<String, Double> variables) {
        return value;
    }

    @Override
    public String functionToString() {
        return (value % 1 != 0) ? Double.toString(value) : Integer.toString(value.intValue());
    }

    @Override
    public List<String> getVariables(List<String> variables) {
        return List.of();
    }
}
