package edu.austral.ingsis.math.visitor;

public class Number implements Visitable{
    private final Double value;

    public Number(Double value) {
        this.value = value;
    }
    public Double getValue() {
        return value;
    }

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
