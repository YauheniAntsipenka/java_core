package collectionsConcurrent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class ConcurrentCollectionsTasks {
    public static void start() throws ExecutionException, InterruptedException {

        /*Fail-fast iterator (hasNext, next, remove) - when running in collection, if checked that collection
         is modified => exception (ConcurrentModificationException)*/

        /*while(iter.hasNext()) {
            list.add("str");
        }*/


        /*Collections.synchronizedSet*/
        /*iterators not synchronized!!1*/
        System.out.println("Collections.synchronizedSet");
        Set<String> defHashSet = new HashSet<>();
        defHashSet.add("ww");
        Set<String> synchronizedSet = Collections.synchronizedSet(defHashSet);
        System.out.println(defHashSet);
        System.out.println(synchronizedSet);
        System.out.println("===========");

        /*ConcurrentHashMap*/
        System.out.println("ConcurrentHashMap");
        //hashmap with group of hashmaps inside
        //default 16 segments inside
        //if key-value in 10 segment => blocked will be only 10th segment and others will be available
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(12, 75);
        concurrentHashMap.put(1, "one");
        concurrentHashMap.put(2, "two");
        concurrentHashMap.put(3, "three");
        System.out.println(concurrentHashMap);
        System.out.println("==============");

        /*CopyOnWriteArrayList*/
        //def arraylist need to be blocked all in 2+ threads app
        //lock only at modification of list
        //CopyOnWrite - create copy of list when adding/modifying/...
        //fail-safe iterator (when running - no ConcurrentModificationException)
        System.out.println("CopyOnWriteArrayList");
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add("234");
        copyOnWriteArrayList.add("123");
        copyOnWriteArrayList.add("345");
        copyOnWriteArrayList.add("456");
        System.out.println(copyOnWriteArrayList);
        System.out.println("============");
        //CopyOnWriteArraySet as CopyOnWriteArrayList


        List<Integer> list1 = Collections.synchronizedList(new ArrayList<>());
        List<Integer> list2 = new CopyOnWriteArrayList<>();

        for (int i = 0; i < 100; i++){
            list1.add(i);
            list2.add(i);
        }

        checkList(list1);
        checkList(list2);
    }


    public static void checkList(List<Integer> list) throws ExecutionException, InterruptedException {
        class ListRunner implements Callable {
            private int start;
            private int end;
            private List list;
            private CountDownLatch latch;

            public ListRunner(int start, int end, List list, CountDownLatch latch) {
                this.start = start;
                this.end = end;
                this.list = list;
                this.latch = latch;
            }

            @Override
            public Object call() throws Exception {
                latch.await();

                long startTime = System.nanoTime();
                for (int i = start; i < end; i++) {
                    list.get(i);
                }
                return System.nanoTime() - startTime;
            }
        }

        CountDownLatch latch = new CountDownLatch(1);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer> future1 = executorService.submit(new ListRunner(0, 50, list, latch));
        Future<Integer> future2 = executorService.submit(new ListRunner(51, 100, list, latch));
        latch.countDown();

        System.out.println("Thread 1: " + future1.get());
        System.out.println("Thread 2: " + future2.get());

        executorService.shutdown();
    }


}
