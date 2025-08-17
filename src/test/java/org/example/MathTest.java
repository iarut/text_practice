package org.example;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class MathTest {

    private Math math;



        @org.junit.jupiter.api.BeforeEach
        void setUp() {
            math = new Math();
        }

        @org.junit.jupiter.api.AfterEach
        void tearDown() {
            math = null;
        }
    @Disabled
    @Test
    @DisplayName("Addition: 4 + 2 = 6")
    void add() {
        double result = math.add(4, 2);
        assertEquals(6, result, "4 + 2 should equal 6");
    }

    @Test
    @DisplayName("Substraction: 4 - 2 = 2")
    void sub() {
            double result = math.sub(4,2);
            assertEquals(2,result,"4-2=2");
    }

    @Test
    @DisplayName("Multiplication: 4*2=8")
    void mul() {
            double result = math.mul(4,2);
            assertEquals(8,result,"4*2=8");
    }

    @Test
    @DisplayName("Division by zero throws ArithmeticException")
    void divisionByZeroThrowsException() {
        assertThrows(ArithmeticException.class, () -> math.div(4, 0), "Division by zero should throw ArithmeticException");
    }

    @Test
    void div() {
            double result = math.div(4,2);
            assertEquals(2,result,"4/2=2");
//            assertThrows(ArithmeticException.class, ()-> math.div(4,0), "Division by zero should throw an exception");
//            assertThrows(ArithmeticException.class, () -> math.div(1, 0), "Division by zero should throw ArithmeticException");

    }
}