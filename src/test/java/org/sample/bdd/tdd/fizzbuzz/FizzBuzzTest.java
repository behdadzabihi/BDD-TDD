//package org.sample.bdd.tdd.fizzbuzz;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.experimental.theories.DataPoint;
//import org.junit.experimental.theories.Theory;
//
//import java.util.List;
//
//public class FizzBuzzTest {
//
//   @Test
//    public void start_shouldReturnAListGivenRoundsLength(){
//        int round=100;
//        List<String> result=FizzBuzz.start(round);
//        Assert.assertEquals(round,result.size());
//    }
//
//    @Test
//    public void start_shouldReturnAFizzValue(){
//        int round=100;
//        List<String> result=FizzBuzz.start(round);
//        Assert.assertEquals("Fizz",result.get(2));
//    }
//
//    @Test
//    public void start_shouldReturnABuzzValue(){
//        int round=100;
//        List<String> result=FizzBuzz.start(round);
//        Assert.assertEquals("Buzz",result.get(4));
//    }
//    @Test
//    public void start_shouldReturnAFizzBuzzValue(){
//        int round=100;
//        List<String> result=FizzBuzz.start(round);
//        Assert.assertEquals("FizzBuzz",result.get(14));
//    }
//}
