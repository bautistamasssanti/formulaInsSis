package edu.austral.ingsis.math.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Variable implements Function {

    private final String name;

    public Variable (String name) {this.name = name;}


    @Override
    public Double evaluate(Map<String, Double> variables) {
        if(variables.get(name) == null) throw new RuntimeException("Variable " + name + " not found");
        return variables.get(name);
    }

    @Override
    public String functionToString() {
        return name;
    }

    @Override
    public List<String> getVariables(List<String> variables) {
        List<String> names = new ArrayList<>();
        names.add(name);
        return Stream.concat(variables.stream(), names.stream()).collect(Collectors.toList());
    }


}
