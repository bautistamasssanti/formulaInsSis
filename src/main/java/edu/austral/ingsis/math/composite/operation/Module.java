package edu.austral.ingsis.math.composite.operation;

import edu.austral.ingsis.math.composite.Function;

import java.util.List;
import java.util.Map;

public class Module implements Function {
    private final Function term1;

    public Module(Function term1) {
        this.term1 = term1;
    }

    @Override
    public Double evaluate(Map<String, Double> variables) {
        return Math.abs(term1.evaluate(variables));
    }

    @Override
    public String functionToString() {
        return "|" + term1.functionToString() + "|";
    }

    @Override
    public List<String> getVariables(List<String> variables) {
        return term1.getVariables(variables);
    }


}
