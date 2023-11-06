package edu.austral.ingsis.math.composite.operation;

import edu.austral.ingsis.math.composite.Function;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Div implements Function {
    private final Function term1;
    private final Function term2;

    public Div(Function term1, Function term2) {
        this.term1 = term1;
        this.term2 = term2;
    }

    @Override
    public Double evaluate(Map<String, Double> variables) {
        Double term2Value = term2.evaluate(variables);
        if (term2Value == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return term1.evaluate(variables) / term2Value;
    }

    @Override
    public String functionToString() {
        String term1String = "";
        String term2String = "";
        if (term1.functionToString().contains("+") || term1.functionToString().contains("-") || term1.functionToString().contains("*") || term1.functionToString().contains("/") || term1.functionToString().contains("^")) {
            term1String = "(" + term1.functionToString() + ")";
        } else {
            term1String = term1.functionToString();
        }
        if (term2.functionToString().contains("+") || term2.functionToString().contains("-") || term2.functionToString().contains("*") || term2.functionToString().contains("/") || term1.functionToString().contains("^")) {
            term2String = "(" + term2.functionToString() + ")";
        } else {
            term2String = term2.functionToString();
        }
        return term1String + " / " + term2String;
    }

    @Override
    public List<String> getVariables(List<String> variables) {
        return Stream.concat(term1.getVariables(variables).stream(), term2.getVariables(variables).stream()).collect(Collectors.toList());
    }


}
