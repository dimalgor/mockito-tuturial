package com.gorban.selfstudy.math;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester {

    //@InjectMocks annotation is used to create and inject the mock object
    @InjectMocks
    MathApplication mathApplication = new MathApplication();

    //@Mock annotation is used to create the mock object to be injected
    @Mock
    CalculatorService calcService;

    public void testAdd(){
        // add the behavior of calc service to add two numbers
        when(calcService.add(10.0, 20.0)).thenReturn(30.0);

        // add the behavior of calc service to subtract two numbers
        when(calcService.subtract(20.0, 10.0)).thenReturn(10.00);

        // test the add functionality
        Assert.assertEquals(calcService.add(10.0, 20.0), 30.0,0);
        Assert.assertEquals(calcService.add(10.0, 20.0), 30.0,0);
        Assert.assertEquals(calcService.add(10.0, 20.0), 30.0,0);

        // test the subtraction functionality
        Assert.assertEquals(calcService.subtract(20.0, 10.0), 10.0, 0);

        //verify the behavior
        verify(calcService).add(10.0, 20.0);

        //check if add function is called three times
        verify(calcService, times(3)).add(10.0, 20.0);

        //check if subtract function is called minimum 2 times
        verify(calcService, atLeastOnce()).subtract(20.0, 10.0);

        //check if add function is called at least 2 times
        verify(calcService, atLeast(2)).add(10.0, 20.0);

        // check if add function is called at most 3 times
        verify(calcService, atMost(3)).add(10.0, 20.0);

        //verify that method multiply is never called on calcService;
        verify(calcService, never()).multiply(10.0, 2.0);
    }

}
