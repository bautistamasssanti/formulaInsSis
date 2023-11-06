package edu.austral.ingsis.math.composite.operation;

import edu.austral.ingsis.math.composite.Function;

import java.util.List;
import java.util.Map;

public class Sqrt implements Function {
    private final Function term1;

    public Sqrt(Function term1) {
        this.term1 = term1;
    }

    @Override
    public Double evaluate(Map<String, Double> variables) {
        Double term1Value = term1.evaluate(variables);
        if (term1Value < 0) {
            throw new ArithmeticException("Square root of negative number");
        }
        return Math.sqrt(term1Value);    }

    @Override
    public String functionToString() {
        return "sqrt(" + term1.functionToString() + ")";
    }

    @Override
    public List<String> getVariables(List<String> variables) {
        return term1.getVariables(variables);
    }


}
