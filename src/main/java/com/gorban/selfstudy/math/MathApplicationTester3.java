package com.gorban.selfstudy.math;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;

@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester3 {

    private MathApplication mathApplication;
    private CalculatorService calcService;

    @Before
    public void setUp(){
        mathApplication = new MathApplication();
        Calculator calculator = new Calculator();
        calcService = spy(calculator);
        mathApplication.setCalculatorService(calcService);
    }

    @Test
    public void testAdd(){
        //perform operation on real object
        //test the add functionality
        assertEquals(mathApplication.add(20.0, 10.0), 30.0, 0);
    }


    class Calculator implements CalculatorService {
        @Override
        public double add(double input1, double input2) {
            return input1 + input2;
        }

        @Override
        public double divide(double input1, double input2) {
            return 0;
        }

        @Override
        public double multiply(double input1, double input2) {
            return 0;
        }

        @Override
        public double subtract(double input1, double input2) {
            return 0;
        }
    }

}
