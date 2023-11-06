package edu.austral.ingsis.math.composite;

import java.util.List;
import java.util.Map;

public interface Function {
    Double evaluate(Map<String,Double> variables);

    String functionToString();
    List<String> getVariables(List<String> variables);




}
