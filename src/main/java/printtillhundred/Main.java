package printtillhundred;

public class Main {

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            Thread t = new Thread(new PrintNumber(i));
            t.start();
        }
    }
}
