package com.ericheitmuller.week1;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;

public class CharacterCountTests {

    @Test
    public void shouldReturnNullIfPassedNull() {

        String result = CharacterCounter.countCharacters(null);
        assertNull(result);
    }

    @Test
    public void shouldReturnEmptyStringIfPassedEmptyString() {
        String result = CharacterCounter.countCharacters("");
        assertNotNull(result);
        assertEquals(result, "");
    }

    @Test
    public void shouldTotalCharactersInARow(){
        String result = CharacterCounter.countCharacters("aaaaa");
        assertNotNull(result);
        assertEquals(result, "a5");
    }

    @Test
    public void shouldTotalDifferentCharactersInARow(){
        String result = CharacterCounter.countCharacters("abc");
        assertNotNull(result);
        assertEquals(result, "a1b1c1");
    }

    //undefined behavior - whitespace.
}
