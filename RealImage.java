public class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromServer();
    }

    private void loadFromServer() {
        System.out.println("Loading " + filename + " from server...");
    }

    public void display() {
        System.out.println("Displaying " + filename);
    }
}
