package edu.austral.ingsis.math.composite;

import edu.austral.ingsis.math.composite.operation.*;
import edu.austral.ingsis.math.composite.operation.Module;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class ListVariablesTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldListVariablesFunction1() {
        final Function term1 = new Number(1d);
        final Function term2 = new Number(6d);
        Function function = new Sum(term1, term2);
        List<String> variables = Collections.emptyList();
        final List<String> result = function.getVariables(variables);

        assertThat(result, empty());
    }

    /**
     * Case 12 / div
     */
    @Test
    public void shouldListVariablesFunction2() {
        final Function term1 = new Number(12d);
        final Function term2 = new Variable("div");
        Function function = new Div(term1, term2);
        List<String> variables = Collections.emptyList();
        final List<String> result = function.getVariables(variables);

        assertThat(result, containsInAnyOrder("div"));
    }

    /**
     * Case (9 / x) * y
     */
    @Test
    public void shouldListVariablesFunction3() {
        final Function term1 = new Number(9d);
        final Function term2 = new Variable("x");
        Function function = new Div(term1, term2);
        final Function term3 = new Variable("y");
        function = new Sum(function, term3);
        List<String> variables = Collections.emptyList();
        final List<String> result = function.getVariables(variables);

        assertThat(result, containsInAnyOrder("x", "y"));
    }

    /**
     * Case (27 / a) ^ b
     */
    @Test
    public void shouldListVariablesFunction4() {
        final Function term1 = new Number(27d);
        final Function term2 = new Variable("a");
        Function function = new Div(term1, term2);
        final Function term3 = new Variable("b");
        function = new Sum(function, term3);
        List<String> variables = Collections.emptyList();
        final List<String> result = function.getVariables(variables);

        assertThat(result, containsInAnyOrder("a", "b"));
    }

    /**
     * Case z ^ (1/2)
     */
    @Test
    public void shouldListVariablesFunction5() {
        final Function term1 = new Variable("z");
        final Function term2 = new Number(0.5d);
        Function function = new Div(term1, term2);
        List<String> variables = Collections.emptyList();
        final List<String> result = function.getVariables(variables);

        assertThat(result, containsInAnyOrder("z"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction6() {
        final Function term1 = new Variable("value");
        Function function = new Module(term1);
        final Function term2 = new Number(8d);
        function = new Sum(function, term2);
        List<String> variables = Collections.emptyList();
        final List<String> result = function.getVariables(variables);

        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction7() {
        final Function term1 = new Variable("value");
        Function function = new Module(term1);
        final Function term2 = new Number(8d);
        function = new Sum(function, term2);
        List<String> variables = Collections.emptyList();
        final List<String> result = function.getVariables(variables);

        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldListVariablesFunction8() {
        final Function term1 = new Number(5d);
        final Function term2 = new Variable("i");
        Function function = new Sub(term1, term2);
        final Function term3 = new Number(8d);
        function = new Mult(function, term3);
        List<String> variables = Collections.emptyList();
        final List<String> result = function.getVariables(variables);

        assertThat(result, containsInAnyOrder("i"));
    }
}
