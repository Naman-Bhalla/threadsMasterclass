package printtillhundred;

public class PrintNumber implements Runnable {
    private int numberToPrint;

    public PrintNumber(int numberToPrint) {
        this.numberToPrint = numberToPrint;
    }

    @Override
    public void run() {
        System.out.println(numberToPrint + " Thread: " + Thread.currentThread().getName());
    }
}
