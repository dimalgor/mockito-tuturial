package com.gorban.selfstudy;

public class Main {

    public static void main(String[] args){
        PortfolioTester portfolioTester = new PortfolioTester();
        portfolioTester.setUp();
        System.out.println(portfolioTester.testMarketValue() ? "passed" : "failed");
    }
}
