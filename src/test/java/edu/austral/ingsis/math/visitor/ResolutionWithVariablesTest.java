package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitor.operation.*;
import edu.austral.ingsis.math.visitor.operation.Module;
import edu.austral.ingsis.math.visitor.visitors.EvaluateVisitor;
import org.junit.Test;
import java.util.Collections;
import java.util.HashMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionWithVariablesTest {

    /**
     * Case 1 + x where x = 3
     */
    @Test
    public void shouldResolveFunction1() {
        final EvaluateVisitor visitor = new EvaluateVisitor(Collections.singletonMap("x", 3d));
        final Double result = visitor.visit(new Sum(new Number(1d), new Variable("x")));

        assertThat(result, equalTo(4d));
    }

    /**
     * Case 12 / div where div = 4
     */
    @Test
    public void shouldResolveFunction2() {
        final EvaluateVisitor visitor = new EvaluateVisitor(Collections.singletonMap("div", 4d));
        final Double result = visitor.visit(new Div(new Number(12d), new Variable("div")));

        assertThat(result, equalTo(3d));
    }

    /**
     * Case (9 / x) * y where x = 3 and y = 4
     */
    @Test
    public void shouldResolveFunction3() {
        final EvaluateVisitor visitor = new EvaluateVisitor(new HashMap<>() {{
            put("x", 3d);
            put("y", 4d);
        }});
        final Double result = visitor.visit(new Mult(new Div(new Number(9d), new Variable("x")), new Variable("y")));

        assertThat(result, equalTo(12d));
    }

    /**
     * Case (27 / a) ^ b where a = 9 and b = 3
     */
    @Test
    public void shouldResolveFunction4() {
        final EvaluateVisitor visitor = new EvaluateVisitor(new HashMap<>() {{
            put("a", 9d);
            put("b", 3d);
        }});
        final Double result = visitor.visit(new Power(new Div(new Number(27d), new Variable("a")), new Variable("b")));

        assertThat(result, equalTo(27d));
    }

    /**
     * Case z ^ (1/2) where z = 36
     */
    @Test
    public void shouldResolveFunction5() {
        final EvaluateVisitor visitor = new EvaluateVisitor(Collections.singletonMap("z", 36d));
        final Double result = visitor.visit(new Power(new Variable("z"), new Div(new Number(1d), new Number(2d))));

        assertThat(result, equalTo(6d));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction6() {
        final EvaluateVisitor visitor = new EvaluateVisitor(Collections.singletonMap("value", 8d));
        final Double result = visitor.visit(new Sum(new Module(new Variable("value")), new Number(-8d)));

        assertThat(result, equalTo(0d));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction7() {
        final EvaluateVisitor visitor = new EvaluateVisitor(Collections.singletonMap("value", 8d));
        final Double result = visitor.visit(new Sum(new Module(new Variable("value")), new Number(-8d)));

        assertThat(result, equalTo(0d));
    }

    /**
     * Case (5 - i) * 8 where i = 2
     */
    @Test
    public void shouldResolveFunction8() {
        final EvaluateVisitor visitor = new EvaluateVisitor(Collections.singletonMap("i", 2d));
        final Double result = visitor.visit(new Mult(new Sub(new Number(5d), new Variable("i")), new Number(8d)));

        assertThat(result, equalTo(24d));
    }
}
