package threads;

public class ThreadViaRunnable {
    public static void start() throws InterruptedException {
        System.out.println("Create thread via interface Runnable");
        SubThreadViaRunnable subThread = new SubThreadViaRunnable();
        Thread thread = new Thread(subThread);
        thread.start();
        System.out.println("main thread closed");
        Thread.sleep(1000);
        System.out.println("==================");
    }
}


class SubThreadViaRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("text from SubThreadViaRunnable");
    }
}
