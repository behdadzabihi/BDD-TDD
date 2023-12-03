package org.sample.bdd.tdd.kata.fizzbuzz;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    public List<String> start(int count) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            String output = i % 3 ==0 ? "Fizz" : "";
            output += i % 5 ==0 ? "Buzz" : "";
            output += output.equals("") ? String.valueOf(i) : "";
            result.add(output);
        }
        return result;
    }
}

