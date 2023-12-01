package org.sample.bdd.tdd.kata;

import org.junit.Assert;
import org.junit.Test;

public class EvaluatorTest {

    @Test
    public void evaluate_shouldReturnEvenWhenEvenNumberPassed() {
        int input = 10;
        Evaluator evaluator = new Evaluator();
        String actual = evaluator.evaluate(input);
        Assert.assertEquals("Even", actual);
    }

    @Test
    public void evaluator_shouldReturnOddWhenOddNumberPassed(){
        int input=7;
        Evaluator evaluator=new Evaluator();
        String actual=evaluator.evaluate(input);
        Assert.assertEquals("Odd",actual);
    }
}
