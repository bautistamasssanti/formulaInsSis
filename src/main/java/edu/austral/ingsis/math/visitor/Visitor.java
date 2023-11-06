package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitor.operation.*;
import edu.austral.ingsis.math.visitor.operation.Module;

public interface Visitor<T> {
    T visit(Number number);
    T visit(Variable variable);
    T visit(Sum sum);

    T visit(Sub sub);

    T visit(Mult mult);

    T visit(Div div);

    T visit(Power power);

    T visit(Parenthesis parenthesis);

    T visit(Sqrt sqrt);

    T visit(Module module);
}
