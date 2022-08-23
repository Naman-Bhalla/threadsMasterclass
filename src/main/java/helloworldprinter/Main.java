package helloworldprinter;

public class Main {

    public static void main(String[] args) {
        Thread t = new Thread(new HelloWorldPrinter());
        t.start();
    }
}
