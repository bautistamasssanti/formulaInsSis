package edu.austral.ingsis.math.visitor.visitors;

import edu.austral.ingsis.math.visitor.Number;
import edu.austral.ingsis.math.visitor.Variable;
import edu.austral.ingsis.math.visitor.Visitor;
import edu.austral.ingsis.math.visitor.operation.*;
import edu.austral.ingsis.math.visitor.operation.Module;

public class PrintVisitor implements Visitor<String> {
    @Override
    public String visit(Number number) {
        return (number.getValue() % 1 != 0) ? Double.toString(number.getValue()) : Integer.toString(number.getValue().intValue());
    }

    @Override
    public String visit(Variable variable) {
        return variable.getName();
    }

    @Override
    public String visit(Sum sum) {
        return sum.getTerm1().accept(this) + " + " + sum.getTerm2().accept(this);
    }

    @Override
    public String visit(Sub sub) {
        return sub.getTerm1().accept(this) + " - " + sub.getTerm2().accept(this);
    }

    @Override
    public String visit(Mult mult) {
        return mult.getTerm1().accept(this) + " * " + mult.getTerm2().accept(this);
    }

    @Override
    public String visit(Div div) {
        return div.getTerm1().accept(this) + " / " + div.getTerm2().accept(this);
    }

    @Override
    public String visit(Power power) {
        return power.getTerm1().accept(this) + " ^ " + power.getTerm2().accept(this);
    }

    @Override
    public String visit(Parenthesis parenthesis) {
        return "(" + parenthesis.getTerm1().accept(this) + ")";
    }

    @Override
    public String visit(Sqrt sqrt) {
        return "sqrt(" + sqrt.getTerm1().accept(this) + ")";
    }

    @Override
    public String visit(Module module) {
        return "|" + module.getTerm1().accept(this) + "|";
    }
}
