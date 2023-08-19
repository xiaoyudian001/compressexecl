package com.xyd.teststudy.designpatterns.ChainOfResponsibilityPattern;

/**
 * 让我们以一个报销申请的审批流程为例来详细说明责任链模式的应用。
 *
 * 假设有一个报销系统，涉及多个层级的审批，包括员工、主管、部门经理和财务经理。
 * 当员工提交报销申请时，需要按照一定的规则和层级进行审批，直到最终决定是否批准报销。
 */
public class ReimbursementApproval {
    private Handler approvalChain;

    public ReimbursementApproval() {
        // 创建处理者对象
        Handler employee = new Employee();
        Handler supervisor = new Supervisor();
        Handler departmentManager = new DepartmentManager();
        Handler financeManager = new FinanceManager();

        // 设置处理者之间的顺序
        employee.setNextHandler(supervisor);
        supervisor.setNextHandler(departmentManager);
        departmentManager.setNextHandler(financeManager);

        // 设置责任链的入口
        approvalChain = employee;
    }

    public void processRequest(double amount) {
        approvalChain.handleRequest(amount);
    }
}
