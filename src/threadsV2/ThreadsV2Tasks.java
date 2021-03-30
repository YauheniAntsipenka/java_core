package threadsV2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

public class ThreadsV2Tasks {
    public static void start() throws ExecutionException, InterruptedException {
        //Run thread with Runnable
//        Runnable task = () -> {
//            System.out.println("task executed");
//        };
//        Thread thread = new Thread(task);
//        thread.start();

        //Run task with Executor
//        Runnable task = () -> System.out.println("task executed");
//        Executor executor = (runnable) -> {
//            new Thread(runnable).start();
//        };
//        executor.execute(task);
//        executor.execute(task);

        //Run task with ExecutorService
//        Callable<String> task = () -> Thread.currentThread().getName();
//        ExecutorService executorService = Executors.newFixedThreadPool(2); //create pool
//        for (int i = 0; i < 5; i++){
//            Future<String> result = executorService.submit(task); //take a task to a pool
//            System.out.println(result.get()); //sout result of task
//        }
//        executorService.shutdown();

        //Run with CachedThreadPool
//        Object lock = new Object();
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        Callable<String> task = () -> {
//            System.out.println(Thread.currentThread().getName()); //info abouth thread
//            lock.wait(2000);
//            System.out.println("Finished");
//            return "result";
//        };
//        for (int i = 0; i < 5; i++) {
//            executorService.submit(task);//other threads paused and wait for working thread
//        }
//        executorService.shutdown();

        //Run with WorkStealingThreadPool
        Object lock = new Object();
        ExecutorService executorService = Executors.newWorkStealingPool();
        Callable<String> task = () -> {
            System.out.println(Thread.currentThread().getName());
            lock.wait(2000);
            System.out.println("Finished");
            return "result";
        };
        for (int i = 0; i < 5; i++) {
            executorService.submit(task);//other threads will work and forget about paused thread
                                        //ForkJoinPool is under WorkStealingPool
                                        //and ALL CREATED THREADS ARE DAEMONS!11!
        }
        executorService.shutdown();



        //ForkJoinPool - fork tasks -> join threads \\realisation of executorservice for recursive tasks
        ForkJoinPool forkJoinPool = new ForkJoinPool(2); //2 cores of processor

    }
}
