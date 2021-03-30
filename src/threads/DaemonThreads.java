package threads;

public class DaemonThreads {
    public static void start() throws InterruptedException {
        System.out.println("daemon");
        Thread thread = new SubDaemonThread();
        thread.setDaemon(true);
        thread.start();
        System.out.println("main thread closed");
        Thread.sleep(1000);
        System.out.println("==================");
    }
}

class SubDaemonThread extends Thread {
    @Override
    public void run() {
        System.out.println("From daemon");
    }
}
