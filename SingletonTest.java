public class SingletonTest {
    public static void main(String[] args) {
        Logger log1 = Logger.getInstance();
        Logger log2 = Logger.getInstance();

        log1.log("This is the first log.");
        log2.log("This is the second log.");

        System.out.println(log1 == log2); // should print true
    }
}
