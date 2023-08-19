package com.xyd.teststudy.designpatterns;

/**
 *
 * 策略模式
 *    策略模式中包括三种角色：
 *
 *     策略（Strategy）：一个接口，定义了若干个算法（抽象方法）。
 *     具体策略（ConcreteStrategy）：策略的实现。
 *     上下文/环境（Context）：依赖于策略接口的类。
 */
public class TestStrategyPattern {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();

        // 根据用户输入动态设置支付策略
        PaymentStrategy paymentStrategy = new CreditCardStrategy("123456789", "12/23", "123");
        shoppingCart.setPaymentStrategy(paymentStrategy);
        // 执行结账
        shoppingCart.checkout(100.0);
    }
}

// 策略接口
interface PaymentStrategy {
    void pay(double amount);
}

// 具体策略
class CreditCardStrategy implements PaymentStrategy {
    private String cardNumber;
    private String expiryDate;
    private String cvv;

    public CreditCardStrategy(String cardNumber, String expiryDate, String cvv) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    @Override
    public void pay(double amount) {
        System.out.println("使用信用卡支付 " + amount);
        // 执行实际的信用卡支付逻辑
    }
}

class PayPalStrategy implements PaymentStrategy {
    private String email;
    private String password;

    public PayPalStrategy(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public void pay(double amount) {
        System.out.println("使用PayPal支付 " + amount);
        // 执行实际的PayPal支付逻辑
    }
}

// 上下文
class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(double totalAmount) {
        // 计算总金额并执行必要的处理

        // 委托选定的策略进行支付
        paymentStrategy.pay(totalAmount);
    }
}
/**
 *
 * 以上示例展示了策略模式的用法。PaymentStrategy接口定义了支付策略的契约，CreditCardStrategy和PayPalStrategy是具体的策略实现类。
 * ShoppingCart作为上下文类，通过setPaymentStrategy方法设置支付策略，然后调用checkout方法执行结账操作，委托所选的策略进行支付。
 */