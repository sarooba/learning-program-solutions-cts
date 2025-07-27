public class StrategyTest {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        context.setPaymentStrategy(new CreditCardPayment());
        context.pay(200.00);

        context.setPaymentStrategy(new PayPalPayment());
        context.pay(150.00);
    }
}
