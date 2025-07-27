public class DecoratorTest {
    public static void main(String[] args) {
        Notifier notifier = new SMSNotifierDecorator(new EmailNotifier());
        notifier.send("Hello! This is a notification.");
    }
}
