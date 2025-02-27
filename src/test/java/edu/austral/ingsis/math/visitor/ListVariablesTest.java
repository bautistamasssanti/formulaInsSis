package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitor.operation.*;
import edu.austral.ingsis.math.visitor.operation.Module;
import edu.austral.ingsis.math.visitor.visitors.ListVariablesVisitor;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;


public class ListVariablesTest {
    final private static Visitor<List<String>> visitor = new ListVariablesVisitor();

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldListVariablesFunction1() {
        final List<String> result = visitor.visit(new Sum(new Number(1d), new Number(6d)));

        assertThat(result, empty());
    }

    /**
     * Case 12 / div
     */
    @Test
    public void shouldListVariablesFunction2() {
        final List<String> result = visitor.visit(new Div(new Number(12d), new Variable("div")));

        assertThat(result, containsInAnyOrder("div"));
    }

    /**
     * Case (9 / x) * y
     */
    @Test
    public void shouldListVariablesFunction3() {
        final List<String> result = visitor.visit(new Mult(new Div(new Number(9d), new Variable("x")), new Variable("y")));

        assertThat(result, containsInAnyOrder("x", "y"));
    }

    /**
     * Case (27 / a) ^ b
     */
    @Test
    public void shouldListVariablesFunction4() {
        final List<String> result = visitor.visit(new Power(new Div(new Number(27d), new Variable("a")), new Variable("b")));

        assertThat(result, containsInAnyOrder("a", "b"));
    }

    /**
     * Case z ^ (1/2)
     */
    @Test
    public void shouldListVariablesFunction5() {
        final List<String> result = visitor.visit(new Power(new Variable("z"), new Div(new Number(1d), new Number(2d))));

        assertThat(result, containsInAnyOrder("z"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction6() {
        final List<String> result = visitor.visit(new Sub(new Module(new Variable("value")), new Number(8d)));

        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction7() {
        final List<String> result = visitor.visit(new Sub(new Module(new Variable("value")), new Number(8d)));

        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldListVariablesFunction8() {
        final List<String> result = visitor.visit(new Mult(new Sub(new Number(5d), new Variable("i")), new Number(8d)));

        assertThat(result, containsInAnyOrder("i"));
    }
}
