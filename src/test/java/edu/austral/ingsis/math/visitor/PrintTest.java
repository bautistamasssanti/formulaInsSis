package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitor.operation.*;
import edu.austral.ingsis.math.visitor.operation.Module;
import edu.austral.ingsis.math.visitor.visitors.PrintVisitor;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PrintTest {
    final private static Visitor<String> visitor = new PrintVisitor();


    /**
     * Case 1 + 6
     */
    @Test
    public void shouldPrintFunction1() {
        final String expected = "1 + 6";
        final String result = visitor.visit(new Sum(new Number(1d), new Number(6d)));

        assertThat(result, equalTo(expected));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldPrintFunction2() {
        final String expected = "12 / 2";
        final String result = visitor.visit(new Div(new Number(12d), new Number(2d)));

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldPrintFunction3() {
        final String expected = "(9 / 2) * 3";
        final String result = visitor.visit(new Mult(new Parenthesis(new Div(new Number(9d),new Number(2d))), new Number(3d)));

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldPrintFunction4() {
        final String expected = "(27 / 6) ^ 2";
        final String result = visitor.visit(new Power(new Parenthesis(new Div(new Number(27d),new Number(6d))), new Number(2d)));

        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction6() {
        final String expected = "|value| - 8";
        final String result = visitor.visit(new Sub(new Module(new Variable("value")), new Number(8d)));

        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction7() {
        final String expected = "|value| - 8";
        final String result = visitor.visit(new Sub(new Module(new Variable("value")), new Number(8d)));

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldPrintFunction8() {
        final String expected = "(5 - i) * 8";
        final String result = visitor.visit(new Mult(new Parenthesis(new Sub(new Number(5d), new Variable("i"))), new Number(8d)));

        assertThat(result, equalTo(expected));
    }
}
