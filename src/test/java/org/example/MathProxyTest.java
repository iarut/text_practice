package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;



import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MathProxyTest {
    @Mock
    Math math;
    @InjectMocks
    MathProxy mathProxy= new MathProxy(math);

    @Test
    void add() {
        when(math.add(2.0,4.0)).thenReturn(6.0);
        assertEquals(mathProxy.add(2.0,4.0),6.0);
    }

    @Test
    void sub() {
        when( math.sub(4.0,2.0)).thenReturn(2.0);
        assertEquals(mathProxy.sub(4.0,2.0),2.0);
    }

    @Test
    void mul() {
        when(math.mul(4.0,2.0)).thenReturn(8.0);
        assertEquals(mathProxy.mul(4.0,2.0),8.0);
    }

    @Test
    void div() {
        when(math.div(4.0,2.0)).thenReturn(2.0);
        assertEquals(mathProxy.div(4.0,2.0),2.0);
    }
}