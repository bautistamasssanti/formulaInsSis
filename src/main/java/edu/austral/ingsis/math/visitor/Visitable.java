package edu.austral.ingsis.math.visitor;

public interface Visitable {
    <T> T accept(Visitor<T> visitor);
}
