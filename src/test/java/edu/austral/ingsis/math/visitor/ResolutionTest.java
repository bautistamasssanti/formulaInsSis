package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitor.operation.*;
import edu.austral.ingsis.math.visitor.operation.Module;
import edu.austral.ingsis.math.visitor.visitors.EvaluateVisitor;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionTest {

    private final static Visitor<Double> visitor = new EvaluateVisitor();

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldResolveSimpleFunction1() {
        final Visitable term1 = new Number(1d);
        final Visitable term2 = new Number(6d);
        final Double result = visitor.visit(new Sum(term1, term2));

        assertThat(result, equalTo(7d));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldResolveSimpleFunction2() {
        final Visitable term1 = new Number(12d);
        final Visitable term2 = new Number(2d);
        final Double result = visitor.visit(new Div(term1, term2));

        assertThat(result, equalTo(6d));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldResolveSimpleFunction3() {
        final Visitable term1 = new Div(new Number(9d), new Number(2d));
        final Visitable term2 = new Number(3d);
        final Double result = visitor.visit(new Mult(term1, term2));

        assertThat(result, equalTo(13.5d));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldResolveSimpleFunction4() {
        final Visitable term1 = new Div(new Number(27d), new Number(6d));
        final Visitable term2 = new Number(2d);
        final Double result = visitor.visit(new Power(term1, term2));

        assertThat(result, equalTo(20.25d));
    }

    /**
     * Case 36 ^ (1/2)
     */
    @Test
    public void shouldResolveSimpleFunction5() {
        final Visitable term1 = new Number(36d);
        final Visitable term2 = new Div(new Number(1d), new Number(2d));
        final Double result = visitor.visit(new Power(term1, term2));

        assertThat(result, equalTo(6d));
    }

    /**
     * Case |136|
     */
    @Test
    public void shouldResolveSimpleFunction6() {
        final Visitable term1 = new Number(136d);
        final Double result = visitor.visit(new Module(term1));

        assertThat(result, equalTo(136d));
    }

    /**
     * Case |-136|
     */
    @Test
    public void shouldResolveSimpleFunction7() {
        final Visitable term1 = new Number(-136d);
        final Double result = visitor.visit(new Module(term1));

        assertThat(result, equalTo(136d));
    }

    /**
     * Case (5 - 5) * 8
     */
    @Test
    public void shouldResolveSimpleFunction8() {
        final Visitable term1 = new Sub(new Number(5d), new Number(5d));
        final Visitable term2 = new Number(8d);
        final Double result = visitor.visit(new Mult(term1, term2));

        assertThat(result, equalTo(0d));
    }
}
