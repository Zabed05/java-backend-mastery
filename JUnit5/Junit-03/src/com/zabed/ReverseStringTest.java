package com.zabed;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

public class ReverseStringTest {

    ReverseString rev = new ReverseString();

    @Test
    void testReverseString_OneWord() {

        assertEquals("AVAJ", rev.reverseString("JAVA"));
    }

    @Test
    void testReverseString_MultipleWords() {
        // ReverseString rev = new ReverseString(); //we are intiate object in class level

        assertEquals("repoleveD avaJ", rev.reverseString("Java Developer"));

        // if we want to pass any message when this test will failed it will be shown -->
        assertEquals("repoleveD avaJ", rev.reverseString("Java Developer"), "Wrong output");
    }

    // efficient way to this -->(here message is not evaluate at first its only evaluate when the test case will failed)
    // assertEquals("repoleveD avaJ", rev.reverseString("Java Developer"), ()->"this is wrong"); //using Lambda exp.


    // also have (assertNotEquals) // Opposite of assertEquals (means expected should != actual)
    @Test
    void testReverseString_MultipleWords_rev() {

        assertNotEquals("repolevD avaJ", rev.reverseString("Java Developer"));
    }

    // More methods--------->

    @Test
    void test(){
        String str = "Junit";
        assertTrue(str.equals("JuNNit"));
    }

}