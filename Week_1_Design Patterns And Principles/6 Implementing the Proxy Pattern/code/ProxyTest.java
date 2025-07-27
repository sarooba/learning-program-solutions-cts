public class ProxyTest {
    public static void main(String[] args) {
        Image image = new ProxyImage("photo.jpg");
        image.display(); // loads and displays
        image.display(); // only displays (cached)
    }
}
