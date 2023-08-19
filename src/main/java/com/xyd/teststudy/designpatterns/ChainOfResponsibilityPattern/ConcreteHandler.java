package com.xyd.teststudy.designpatterns.ChainOfResponsibilityPattern;

public class ConcreteHandler  extends Handler{
    @Override
    public void handleRequest(double amount) {
        if (amount <= 100) {
            System.out.println("Employee approves the reimbursement.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(amount);
        }
    }
}
