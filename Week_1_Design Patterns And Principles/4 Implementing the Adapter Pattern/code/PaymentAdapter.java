public class PaymentAdapter implements PaymentProcessor {
    private ThirdPartyGateway gateway = new ThirdPartyGateway();

    public void processPayment(double amount) {
        gateway.makePayment(amount);
    }
}
