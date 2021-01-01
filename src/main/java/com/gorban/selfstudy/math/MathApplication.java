package com.gorban.selfstudy.math;

public class MathApplication {
    CalculatorService calculatorService;

    public void setCalculatorService(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public double add(double input1, double input2){
//        return calculatorService.add(input1, input2);
        return  input1 + input2;
    }

    public double subtract(double input1, double input2){
        return calculatorService.subtract(input1, input2);
    }

    public double multiply(double input1, double input2){
        return calculatorService.multiply(input1, input2);
    }

    public double divide(double input1, double input2){
        return calculatorService.divide(input1, input2);
    }
}