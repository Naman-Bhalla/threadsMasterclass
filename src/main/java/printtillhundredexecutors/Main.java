package printtillhundredexecutors;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        Executor executor = Executors.newFixedThreadPool(10);

        for (int i = 1; i <= 100; i++) {
            if (i == 50) {
                System.out.println("STOP");
            }

            executor.execute(new PrintNumber(i));
        }
    }
}
