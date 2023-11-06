package edu.austral.ingsis.math.composite;

import edu.austral.ingsis.math.composite.operation.*;
import edu.austral.ingsis.math.composite.operation.Module;
import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionWithVariablesTest {

    /**
     * Case 1 + x where x = 3
     */
    @Test
    public void shouldResolveFunction1() {
        final Function term1 = new Number(1d);
        final Function term2 = new Variable("x");
        HashMap<String, Double> variables = new HashMap<>();
        variables.put("x", 3d);
        Function function = new Sum(term1, term2);
        final Double result = function.evaluate(variables);

        assertThat(result, equalTo(4d));
    }

    /**
     * Case 12 / div where div = 4
     */
    @Test
    public void shouldResolveFunction2() {
        final Function term1 = new Number(12d);
        final Function term2 = new Variable("div");
        HashMap<String, Double> variables = new HashMap<>();
        variables.put("div", 4d);
        Function function = new Div(term1, term2);
        final Double result = function.evaluate(variables);

        assertThat(result, equalTo(3d));
    }

    /**
     * Case (9 / x) * y where x = 3 and y = 4
     */
    @Test
    public void shouldResolveFunction3() {
        final Function term1 = new Number(9d);
        final Function term2 = new Variable("x");
        final Function term3 = new Variable("y");
        Function operation1 = new Div(term1, term2);
        HashMap<String, Double> variables = new HashMap<>();
        variables.put("x", 3d);
        variables.put("y", 4d);
        Function function = new Mult(operation1, term3);
        final Double result = function.evaluate(variables);

        assertThat(result, equalTo(12d));
    }

    /**
     * Case (27 / a) ^ b where a = 9 and b = 3
     */
    @Test
    public void shouldResolveFunction4() {
        final Function term1 = new Number(27d);
        final Function term2 = new Variable("a");
        final Function term3 = new Variable("b");
        Function operation1 = new Div(term1, term2);
        HashMap<String, Double> variables = new HashMap<>();
        variables.put("a", 9d);
        variables.put("b", 3d);
        Function function = new Power(operation1, term3);
        final Double result = function.evaluate(variables);

        assertThat(result, equalTo(27d));
    }

    /**
     * Case z ^ (1/2) where z = 36
     */
    @Test
    public void shouldResolveFunction5() {
        final Function term1 = new Variable("z");
        final Function term2 = new Number(1d);
        final Function term3 = new Number(2d);
        final Function operation1 = new Div(term2, term3);
        HashMap<String, Double> variables = new HashMap<>();
        variables.put("z", 36d);
        Function function = new Power(term1, operation1);
        final Double result = function.evaluate(variables);

        assertThat(result, equalTo(6d));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction6() {
        final Function term1 = new Variable("value");
        final Function term2 = new Number(8d);
        final Function operation1 = new Module(term1);
        HashMap<String, Double> variables = new HashMap<>();
        variables.put("value", 8d);
        Function function = new Sub(operation1, term2);
        final Double result = function.evaluate(variables);

        assertThat(result, equalTo(0d));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction7() {
        final Function term1 = new Variable("value");
        final Function term2 = new Number(8d);
        final Function operation1 = new Module(term1);
        HashMap<String, Double> variables = new HashMap<>();
        variables.put("value", 8d);
        Function function = new Sub(operation1, term2);
        final Double result = function.evaluate(variables);

        assertThat(result, equalTo(0d));
    }

    /**
     * Case (5 - i) * 8 where i = 2
     */
    @Test
    public void shouldResolveFunction8() {
        final Function term1 = new Number(5d);
        final Function term2 = new Variable("i");
        final Function term3 = new Number(8d);
        final Function operation1 = new Sub(term1, term2);
        HashMap<String, Double> variables = new HashMap<>();
        variables.put("i", 2d);
        Function function = new Mult(operation1, term3);
        final Double result = function.evaluate(variables);

        assertThat(result, equalTo(24d));
    }
}
