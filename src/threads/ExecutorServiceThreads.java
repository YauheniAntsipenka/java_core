package threads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ExecutorServiceThreads {
    public static void start() throws InterruptedException {
        System.out.println("executor service");
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<Integer> future = executorService.submit(() -> {
            System.out.println("from another thread");
            Thread.sleep(1000);
            return 777;
        });

       /* while (!future.isDone()) {
            System.out.println("future not done!");
            Thread.sleep(100);
        }*/

        try {
            System.out.println(future.get(2, TimeUnit.SECONDS));
//            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
        System.out.println("==================");
    }
}
