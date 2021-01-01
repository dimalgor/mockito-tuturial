package com.gorban.selfstudy;

import com.gorban.selfstudy.math.MathApplication;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Main {

    public static void main(String[] args){
        /*PortfolioTester portfolioTester = new PortfolioTester();
        portfolioTester.setUp();
        System.out.println(portfolioTester.testMarketValue() ? "passed" : "failed");*/

        Result result = JUnitCore.runClasses(MathApplication.class);

        for (Failure failure : result.getFailures()){
            System.out.println(failure.toString());
        }

        System.out.println("result.wasSuccessful:" + result.wasSuccessful());
    }
}
