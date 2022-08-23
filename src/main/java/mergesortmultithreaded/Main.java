package mergesortmultithreaded;

import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> numbers = List.of(
          7, 2, 9, 1, 5, 6
        );

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<List<Integer>> sortedArrayFuture = executorService.submit(new Sorter(numbers));

        List<Integer> sortedArray = sortedArrayFuture.get();

        for (Integer in: sortedArray) {
            System.out.println(in);
        }
    }
}
