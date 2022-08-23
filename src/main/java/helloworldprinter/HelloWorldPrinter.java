package helloworldprinter;

public class HelloWorldPrinter extends Thread {

    public void run() {
        System.out.println("Hello World " + Thread.currentThread().getName());
    }
}
