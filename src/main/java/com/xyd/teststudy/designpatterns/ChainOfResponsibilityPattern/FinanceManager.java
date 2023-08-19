package com.xyd.teststudy.designpatterns.ChainOfResponsibilityPattern;

public class FinanceManager extends Handler{
    @Override
    public void handleRequest(double amount) {
        if (amount > 1000) {
            System.out.println("Finance Manager approves the reimbursement.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(amount);
        }
    }
}
