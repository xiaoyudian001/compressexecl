package com.xyd.teststudy.designpatterns.ChainOfResponsibilityPattern;

public class DepartmentManager extends Handler {
    public void handleRequest(double amount) {
        if (amount <= 1000) {
            System.out.println("Department Manager approves the reimbursement.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(amount);
        }
    }
}
