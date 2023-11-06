package edu.austral.ingsis.math.visitor.visitors;

import edu.austral.ingsis.math.visitor.Number;
import edu.austral.ingsis.math.visitor.Variable;
import edu.austral.ingsis.math.visitor.Visitor;
import edu.austral.ingsis.math.visitor.operation.*;
import edu.austral.ingsis.math.visitor.operation.Module;

import java.util.Map;

public class EvaluateVisitor implements Visitor<Double> {
    private final Map<String, Double> variables;

    public EvaluateVisitor(Map<String, Double> variables) {
        this.variables = variables;
    }
    public EvaluateVisitor(){
        this(Map.of());
    }


    @Override
    public Double visit(Number number) {
        return number.getValue();
    }

    @Override
    public Double visit(Variable variable) {
        return variables.containsKey(variable.getName()) ? variables.get(variable.getName()) : 0;
    }

    @Override
    public Double visit(Sum sum) {
        return sum.getTerm1().accept(this) + sum.getTerm2().accept(this);
    }

    @Override
    public Double visit(Sub sub) {
        return sub.getTerm1().accept(this) - sub.getTerm2().accept(this);
    }

    @Override
    public Double visit(Mult mult) {
        return mult.getTerm1().accept(this) * mult.getTerm2().accept(this);
    }

    @Override
    public Double visit(Div div) {
        return div.getTerm1().accept(this) / div.getTerm2().accept(this);
    }

    @Override
    public Double visit(Power power) {
        return Math.pow(power.getTerm1().accept(this), power.getTerm2().accept(this));
    }

    @Override
    public Double visit(Parenthesis parenthesis) {
        return parenthesis.getTerm1().accept(this);
    }

    @Override
    public Double visit(Sqrt sqrt) {
        return Math.sqrt(sqrt.getTerm1().accept(this));
    }

    @Override
    public Double visit(Module module) {
        return Math.abs(module.getTerm1().accept(this));
    }
}
