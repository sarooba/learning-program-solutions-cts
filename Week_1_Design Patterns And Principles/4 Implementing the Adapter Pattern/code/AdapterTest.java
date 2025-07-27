public class AdapterTest {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentAdapter();
        processor.processPayment(500.00);
    }
}
