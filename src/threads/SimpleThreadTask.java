package threads;

import helpers.TimeHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class SimpleThreadTask {
    public static void start() {
        try {
            TimeHelper.startTime = System.currentTimeMillis(); //start time
            List<CounterTWSCB> threadList = new ArrayList<>(); //list of threads
            for (int i = 0; i < 4; i++) {
                CounterTWSCB thread = new CounterTWSCB(String.valueOf(i)); //create thread
                threadList.add(thread); //add to list
            }

            for (CounterTWSCB thread : threadList) {
                thread.start();
            }

            for (CounterTWSCB thread : threadList) {
                thread.join(); //wait while every thread will stop
            }
//            System.out.println(ValueList.evenNumbersList);
            TimeHelper.endTime = System.currentTimeMillis(); //endtime
            System.out.println(TimeHelper.getRangeInSeconds());
            System.out.println("Exit from main");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class CounterTWSCB extends Thread {
    CounterTWSCB(String threadName){
        super(threadName);
//        System.out.println(this);
    }

    @Override
    public void run() {
        while(Values.value <= 5000){
            System.out.println(getName() + ": " + Values.value); //thread name and value
            Values.increaseValue();
        }
        System.out.println("Exit from thread: " + getName());
    }
}

class Values {
    public static Integer value = 1;
    public static Semaphore semaphore = new Semaphore(2);
    public static ReentrantLock reentrantLock = new ReentrantLock();

    /*public static void increaseValue(){
        synchronized (value) {
            value++;
        }
    }*/

    /*public static synchronized void increaseValue(){
        value++;
    }*/

    /*public static void increaseValue(){
        try {
            semaphore.acquire();
            for(int i = 0; i < 5; i++) {
                value++;
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semaphore.release();
    }*/

    public static void increaseValue(){
        try {
            reentrantLock.lock();
            for(int i = 0; i < 5; i++) {
                value++;
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }
}
