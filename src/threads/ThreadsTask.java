package threads;

public class ThreadsTask {
    public static void start(){
        try {
            ThreadViaRunnable.start();

            ThreadViaThread.start();

            DaemonThreads.start();

            ExecutorServiceThreads.start();

//            CompletableFutureThreads.start();

//            SimpleThreadTask.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
