package threads;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureThreads {
    public static void start() throws InterruptedException {
        System.out.println("completable future");
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "hi");
//        String result = completableFuture.join(); //analog get in future
//        System.out.println(result);
//        completableFuture.complete(777);
        completableFuture.thenApplyAsync(result -> {
            System.out.println(result + " everybody!");
            return result;
        });
        Thread.sleep(100);
        System.out.println("=========");
    }
}
