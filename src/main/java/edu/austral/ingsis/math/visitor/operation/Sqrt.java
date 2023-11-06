package edu.austral.ingsis.math.visitor.operation;

import edu.austral.ingsis.math.visitor.Visitable;
import edu.austral.ingsis.math.visitor.Visitor;

public class Sqrt implements Visitable {
    private final Visitable term1;

    public Sqrt(Visitable term1) {
        this.term1 = term1;
    }
    public Visitable getTerm1() {
        return term1;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
