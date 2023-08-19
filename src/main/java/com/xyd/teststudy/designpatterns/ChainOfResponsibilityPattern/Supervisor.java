package com.xyd.teststudy.designpatterns.ChainOfResponsibilityPattern;

public class Supervisor extends Handler {
    @Override
    public void handleRequest(double amount) {
        if (amount <= 500) {
            System.out.println("Supervisor approves the reimbursement.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(amount);
        }
    }
}
