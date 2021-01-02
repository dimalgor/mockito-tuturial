package com.gorban.selfstudy.math;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

//@RunWith attaches a runner with the test class to initialize the test data
@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester2 {

    private MathApplication mathApplication;
    private CalculatorService calcService;

    @Before
    public void setUp(){
        mathApplication = new MathApplication();
        calcService = mock(CalculatorService.class);
    }

    @Test
    public void addAndSubtract(){
        when(calcService.add(10.0, 20.0)).thenReturn(30.0);
        when(calcService.subtract(20.0, 10.0)).thenReturn(10.0);

        assertEquals(mathApplication.subtract(20.0, 10.0), 10.0, 0);
        assertEquals(mathApplication.add(10.0, 20.0), 30.0, 0);

        verify(calcService).add(10.0, 20.0);
        verify(calcService).subtract(20.0, 10.0);
    }

    @Test
    public void inOrderAddAndSubtract(){
        when(calcService.add(20.0, 10.0)).thenReturn(30.0);
        when(calcService.subtract(20.0, 10.0)).thenReturn(10.0);

        assertEquals(calcService.add(20.0, 10.0), 30.0, 0);
        assertEquals(calcService.subtract(20.0, 10.0), 10.0, 0);

        // create inOrder verifier for a single mock
        InOrder inOrder = inOrder(calcService);

        // following will make sure that add is first called than subtract is called
        inOrder.verify(calcService).subtract(20.0, 10.0);
        inOrder.verify(calcService).add(20.0, 10.0);
    }

    @Test
    public void testAddWithAnswer(){
        when(calcService.add(20.0, 10.0)).thenAnswer(new Answer<Double>() {
            @Override
            public Double answer(InvocationOnMock invocationOnMock) throws Throwable {

                // get the arguments passed to mock
                Object[] args = invocationOnMock.getArguments();

                // get the mock
                Object mock = invocationOnMock.getMock();

                // return the result
                return 30.0;
            }
        });

        // test the add functionality
        assertEquals(mathApplication.add(20.0, 10.0), 30.0, 0);
    }

    @Test
    public void testAddAndSubtract(){

        //add the behavior to add numbers
        when(calcService.add(20.0, 10.0)).thenReturn(30.0);

        //test the add functionality
        assertEquals(mathApplication.add(20.0, 10.0), 30.0, 0);

        //reset the mock
        reset(calcService);

        //test the add functionality after resetting the mock
        assertEquals(mathApplication.add(20.0, 10.0), 30.0, 0);
    }

    @Test
    public void testAddWithBDD(){
        //Given
        given(calcService.add(10.0, 20.0)).willReturn(30.0);

        //when
        double result = calcService.add(10.0, 20.0);

        //then
        assertEquals(30.0, result, 0);
    }
}
