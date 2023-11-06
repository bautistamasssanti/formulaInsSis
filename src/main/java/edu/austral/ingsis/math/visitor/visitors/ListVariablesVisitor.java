package edu.austral.ingsis.math.visitor.visitors;

import edu.austral.ingsis.math.visitor.Number;
import edu.austral.ingsis.math.visitor.Variable;
import edu.austral.ingsis.math.visitor.Visitor;
import edu.austral.ingsis.math.visitor.operation.*;
import edu.austral.ingsis.math.visitor.operation.Module;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListVariablesVisitor implements Visitor<List<String>> {
    @Override
    public List<String> visit(Number number) {
        return new ArrayList<>();
    }

    @Override
    public List<String> visit(Variable variable) {
        return new ArrayList<>(Collections.singleton(variable.getName()));
    }

    @Override
    public List<String> visit(Sum sum) {
        return merge(sum.getTerm1().accept(this), sum.getTerm2().accept(this));
    }

    @Override
    public List<String> visit(Sub sub) {
        return merge(sub.getTerm1().accept(this), sub.getTerm2().accept(this));
    }

    @Override
    public List<String> visit(Mult mult) {
        return merge(mult.getTerm1().accept(this), mult.getTerm2().accept(this));
    }

    @Override
    public List<String> visit(Div div) {
        return merge(div.getTerm1().accept(this), div.getTerm2().accept(this));
    }

    @Override
    public List<String> visit(Power power) {
        return merge(power.getTerm1().accept(this), power.getTerm2().accept(this));
    }

    @Override
    public List<String> visit(Parenthesis parenthesis) {
        return parenthesis.getTerm1().accept(this);
    }

    @Override
    public List<String> visit(Sqrt sqrt) {
        return sqrt.getTerm1().accept(this);
    }

    @Override
    public List<String> visit(Module module) {
        return module.getTerm1().accept(this);
    }
    private List<String> merge(List<String> term1, List<String> term2) {
        return Stream.concat(term1.stream(), term2.stream()).collect(Collectors.toList());
    }
}
