package com.ericheitmuller.week1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GCDTests {

    @Test
    public void shouldReturnSmallerNumberWhenIsLargestFactor(){
       int result = GCD.findGCD(33, 11);
       assertEquals(result, 11);
    }

    @Test
    public void shouldReturnSameResultWhenParametersFlipped(){
        int result = GCD.findGCD(11, 33);
        assertEquals(result, 11);
    }

    @Test
    public void shouldFindGCD(){
        int result = GCD.findGCD(12, 8);
        assertEquals(result, 4);
    }

    @Test
    public void shouldReturnErrorValueIfPassedNegativeNumber(){
        int result = GCD.findGCD(12, -8);
        assertEquals(result, -1);
    }
}
