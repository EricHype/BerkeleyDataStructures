package com.ericheitmuller.week1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArrayTests {

    @Test
    public void shiftingToTheRightShouldHandleEmptyArray(){
        int[] temp = {};
        int[] result = Arrays.shiftArrayToTheRightOnePosition(temp);
        assertEquals(result, temp);
    }

    @Test
    public void shiftingToTheRightShouldShift(){
        int[] test = {1, 2, 3};
        int[] expected = {3, 1, 2};
        int[] shifted = Arrays.shiftArrayToTheRightOnePosition(test);
        for(int i=0; i< shifted.length; i++){
            assertEquals(expected[i], shifted[i]);
        }
    }

    @Test
    public void shiftingToTheLeftShouldHandleEmptyArray(){
        int[] temp = {};
        int[] result = Arrays.shiftArrayToTheLeftOnePosition(temp);
        assertEquals(result, temp);
    }

    @Test
    public void shiftingToTheLeftShouldShift(){
        int[] test = {1, 2, 3};
        int[] expected = { 2, 3, 1};
        int[] shifted = Arrays.shiftArrayToTheLeftOnePosition(test);
        for(int i=0; i< shifted.length; i++){
            assertEquals(expected[i], shifted[i]);
        }
    }

    @Test
    public void removeElementShouldHandleEmptyArray(){
        int[] temp = {};
        int[] result = Arrays.removeElementFromArray(temp, 1);
        assertEquals(result, temp);
    }

    @Test
    public void removeElementShouldNotRemoveElementNotPresentInArray(){
        int[] temp = {1, 2, 3};
        int[] result = Arrays.removeElementFromArray(temp, 4);
        assertEquals(result, temp);
    }

    @Test
    public void removeElementShouldRemoveAnElement(){
        int[] test = {1, 2, 3};
        int[] expected = { 2, 3 };
        int[] removed = Arrays.removeElementFromArray(test, 1);
        for(int i=0; i< removed.length; i++){
            assertEquals(expected[i], removed[i]);
        }
    }

}
