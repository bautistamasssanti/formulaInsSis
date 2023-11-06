package edu.austral.ingsis.math.composite;

import edu.austral.ingsis.math.composite.operation.*;
import edu.austral.ingsis.math.composite.operation.Module;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PrintTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldPrintFunction1() {
        final String expected = "1 + 6";
        final Function term1 = new Number(1d);
        final Function term2 = new Number(6d);
        Function function = new Sum(term1, term2);
        final String result = function.functionToString();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldPrintFunction2() {
        final String expected = "12 / 2";
        final Function term1 = new Number(12d);
        final Function term2 = new Number(2d);
        Function function = new Div(term1, term2);
        final String result = function.functionToString();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldPrintFunction3() {
        final String expected = "(9 / 2) * 3";
        final Function term1 = new Number(9d);
        final Function term2 = new Number(2d);
        final Function term3 = new Number(3d);
        final Function operation1 = new Div(term1, term2);
        Function function = new Mult(operation1, term3);
        final String result = function.functionToString();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldPrintFunction4() {
        final String expected = "(27 / 6) ^ 2";
        final Function term1 = new Number(27d);
        final Function term2 = new Number(6d);
        final Function term3 = new Number(2d);
        final Function operation1 = new Div(term1, term2);
        Function function = new Power(operation1, term3);
        final String result = function.functionToString();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction6() {
        final String expected = "|value| - 8";
        final Function term1 = new Variable("value");
        final Function term2 = new Number(8d);
        final Function operation1 = new Module(term1);
        Function function = new Sub(operation1, term2);
        final String result = function.functionToString();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction7() {
        final String expected = "|value| - 8";
        final Function term1 = new Variable("value");
        final Function term2 = new Number(8d);
        final Function operation1 = new Module(term1);
        Function function = new Sub(operation1, term2);
        final String result = function.functionToString();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldPrintFunction8() {
        final String expected = "(5 - i) * 8";
        final Function term1 = new Number(5d);
        final Function term2 = new Variable("i");
        final Function term3 = new Number(8d);
        final Function operation1 = new Sub(term1, term2);
        Function function = new Mult(operation1, term3);
        final String result = function.functionToString();

        assertThat(result, equalTo(expected));
    }
}
