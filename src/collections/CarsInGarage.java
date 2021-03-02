package collections;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CarsInGarage {
    public static void start() {
        Map<String, Integer> garage= new HashMap<>();
        garage.put("Audi", 2);
        garage.put("Mercedes", 4);
        garage.put("BMW", 1);
        System.out.println(garage);
        garage.put("BMW", 34);
        System.out.println(garage);
        garage.put(null, 10);
        System.out.println(garage);
        garage.put(null, null);
        System.out.println(garage);
        garage.put("BMW", null);
        System.out.println(garage);
        garage.put(null, 123);
        System.out.println(garage);
        System.out.println(garage.get(null));
        System.out.println(garage.containsKey(null));
        System.out.println("size: " + garage.size());
        garage.put("Zhiguli", 2);
        System.out.println("size: " + garage.size());
        System.out.println(garage.containsValue(null));
        System.out.println(garage);
        garage.keySet().forEach(e-> {
            if (e == null){
                e = "NULLLLL";
            }
            System.out.print(e + " ");
        });

        garage.forEach((k, v)->System.out.println(k + " " + v));




        Queue<String> stringQueue = new LinkedList<>();
        stringQueue.add("elem 1");
        stringQueue.add("elem 2");
        stringQueue.add("elem 3");
        stringQueue.add("elem 4");
        System.out.println(stringQueue.element());
        System.out.println(stringQueue.poll());
    }




}
