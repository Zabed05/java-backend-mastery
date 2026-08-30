package com.zabed;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // only one instance will be created
public class ShapesTest {

    ShapesTest(){
        System.out.println("Test Object is created");
    }

    @BeforeAll
    void beforeAll(){ 
        System.out.println("Before all test");
    }

    @AfterAll
    void afterAll(){
        System.out.println("After all test");
    }

    
    Shapes shape;

    @BeforeEach
    void init(){ // Execute before every Test cases
        shape = new Shapes();
        System.out.println("Before Test");
    }

    @Test
    void testCalculateSquareArea(){
        assertEquals(25, shape.calculateSquareArea(5));
        System.out.println("Actual test running");
    }

    @Test
    void testCalculatecircleArea(){
        assertEquals(78.5, shape.calculateCircularArea(5));
        System.out.println("Actual test running");
    }

    @AfterEach
    void destroy(){
        System.out.println("AfterTest");
    }
}