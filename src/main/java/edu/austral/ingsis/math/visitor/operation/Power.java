package edu.austral.ingsis.math.visitor.operation;

import edu.austral.ingsis.math.visitor.Visitable;
import edu.austral.ingsis.math.visitor.Visitor;

public class Power implements Visitable {
    private final Visitable term1;
    private final Visitable term2;

    public Power(Visitable term1, Visitable term2) {
        this.term1 = term1;
        this.term2 = term2;
    }
    public Visitable getTerm1() {
        return term1;
    }
    public Visitable getTerm2() {
        return term2;
    }
    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
