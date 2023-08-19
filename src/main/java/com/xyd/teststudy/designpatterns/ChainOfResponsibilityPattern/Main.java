package com.xyd.teststudy.designpatterns.ChainOfResponsibilityPattern;

/**
 *<p>
 * 责任链模式（Chain of Responsibility Pattern）是一种行为型设计模式，它允许多个对象按照顺序处理请求，每个对象都可以选择处理请求或将其传递给链中的下一个对象。
 *
 * 在责任链模式中，有以下主要角色：
 *
 * Handler（处理者）：它定义了一个处理请求的接口，并持有下一个处理者的引用。处理者可以选择自己处理请求，也可以将请求传递给下一个处理者。
 *
 * ConcreteHandler（具体处理者）：它实现了处理请求的方法。如果可以处理请求，就直接处理；否则，将请求传递给下一个处理者。
 *
 * 在责任链模式中，请求沿着处理者链向下传递，直到有一个处理者可以处理该请求为止。每个处理者都有机会处理请求，但具体由哪个处理者处理取决于其具体实现。
 *</p>
 */
public class Main {
    public static void main(String[] args) {
        ReimbursementApproval approval = new ReimbursementApproval();
        approval.processRequest(200);  // Employee approves the reimbursement.
        approval.processRequest(600);  // Supervisor approves the reimbursement.
        approval.processRequest(1200); // Finance Manager approves the reimbursement.
        approval.processRequest(5000); // Finance Manager approves the reimbursement.
    }
}

