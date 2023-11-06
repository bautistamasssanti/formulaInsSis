package edu.austral.ingsis.math.composite;

import edu.austral.ingsis.math.composite.operation.*;
import edu.austral.ingsis.math.composite.operation.Module;
import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldResolveSimpleFunction1() {
        final Function term1 = new Number(1d);
        final Function term2 = new Number(6d);
        HashMap<String, Double> variables = new HashMap<>();
        Function function = new Sum(term1, term2);
        final Double result = function.evaluate(variables);

        assertThat(result, equalTo(7d));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldResolveSimpleFunction2() {
        final Function term1 = new Number(12d);
        final Function term2 = new Number(2d);
        HashMap<String, Double> variables = new HashMap<>();
        Function function = new Div(term1, term2);
        final Double result = function.evaluate(variables);

        assertThat(result, equalTo(6d));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldResolveSimpleFunction3() {
        final Function term1 = new Number(9d);
        final Function term2 = new Number(2d);
        final Function term3 = new Number(3d);
        Function operation1 = new Div(term1, term2);
        HashMap<String, Double> variables = new HashMap<>();
        Function function = new Mult(operation1, term3);
        final Double result = function.evaluate(variables);

        assertThat(result, equalTo(13.5d));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldResolveSimpleFunction4() {
        final Function term1 = new Number(27d);
        final Function term2 = new Number(6d);
        final Function term3 = new Number(2d);
        Function operation1 = new Div(term1, term2);
        HashMap<String, Double> variables = new HashMap<>();
        Function function = new Power(operation1, term3);
        final Double result = function.evaluate(variables);

        assertThat(result, equalTo(20.25d));
    }

    /**
     * Case 36 ^ (1/2)
     */
    @Test
    public void shouldResolveSimpleFunction5() {
        final Function term1 = new Number(36d);
        final Function term2 = new Number(1d);
        final Function term3 = new Number(2d);
        final Function operation1 = new Div(term2, term3);
        HashMap<String, Double> variables = new HashMap<>();
        Function function = new Power(term1, operation1);
        final Double result = function.evaluate(variables);

        assertThat(result, equalTo(6d));
    }

    /**
     * Case |136|
     */
    @Test
    public void shouldResolveSimpleFunction6() {
        final Function term1 = new Number(136d);
        final Function function = new Module(term1);
        HashMap<String, Double> variables = new HashMap<>();
        final Double result = function.evaluate(variables);

        assertThat(result, equalTo(136d));
    }

    /**
     * Case |-136|
     */
    @Test
    public void shouldResolveSimpleFunction7() {
        final Function term1 = new Number(-136d);
        final Function function = new Module(term1);
        HashMap<String, Double> variables = new HashMap<>();
        final Double result = function.evaluate(variables);

        assertThat(result, equalTo(136d));
    }

    /**
     * Case (5 - 5) * 8
     */
    @Test
    public void shouldResolveSimpleFunction8() {
        final Function term1 = new Number(5d);
        final Function term2 = new Number(5d);
        final Function term3 = new Number(8d);
        final Function operation1 = new Sub(term1, term2);
        Function function = new Mult(operation1, term3);
        HashMap<String, Double> variables = new HashMap<>();
        final Double result = function.evaluate(variables);

        assertThat(result, equalTo(0d));
    }
}
