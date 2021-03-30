package threads;

public class ThreadViaThread {
    public static void start() throws InterruptedException {
        System.out.println("Create thread via Thread");
        Thread thread = new SubThreadViaThread();
        thread.start();
        System.out.println(thread.getName() + " " + thread.getId());
        System.out.println("main thread closed");
        Thread.sleep(1000);
        System.out.println("==================");
        String a = "ss" + "s";
    }
}

class SubThreadViaThread extends Thread {
    public void run() {
        System.out.println("text from SubThreadViaThread");
    }
}
