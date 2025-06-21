public class BuilderTest {
    public static void main(String[] args) {
        Computer myPC = new Computer.Builder()
                .setCPU("Intel i7")
                .setRAM("16GB")
                .setStorage("1TB SSD")
                .build();
        myPC.showSpecs();
    }
}
