package org.sample.bdd.tdd.kata.fizzbuzz;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class FizzBuzzTest {

    @Test
    public void should_returnAtListRoundWhenARoundPassed() {
        int count = 100;
        FizzBuzz fizzBuzz = new FizzBuzz();
        List<String> actual = fizzBuzz.start(count);
        Assert.assertEquals(count, actual.size());
    }

    @Test
    public void should_returnFizz() {
        int count = 100;
        FizzBuzz fizzBuzz = new FizzBuzz();
        List<String> actual = fizzBuzz.start(count);
        Assert.assertEquals("Fizz", actual.get(2));
    }

    @Test
    public void should_returnBuzz() {
        int count = 100;
        FizzBuzz fizzBuzz = new FizzBuzz();
        List<String> actual = fizzBuzz.start(count);
        Assert.assertEquals("Buzz", actual.get(4));
    }

    @Test
    public void should_returnFizzBuzz() {
        int count = 100;
        FizzBuzz fizzBuzz = new FizzBuzz();
        List<String> actual = fizzBuzz.start(count);
        Assert.assertEquals("FizzBuzz", actual.get(14));
    }
}
