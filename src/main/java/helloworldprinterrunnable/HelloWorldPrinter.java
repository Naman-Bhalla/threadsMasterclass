package helloworldprinterrunnable;

public class HelloWorldPrinter implements Runnable {

    public void run() {
        System.out.println("Hello World " + Thread.currentThread().getName());
    }
}
