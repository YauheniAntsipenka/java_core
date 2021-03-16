package collectionsv2;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollectionsTask {
    public static void start(){
        System.out.println(Collections.EMPTY_LIST);
        System.out.println(Collections.EMPTY_MAP);
        System.out.println(Collections.EMPTY_SET);

        System.out.println("CHECKED LIST");
        List<Integer> checkedList = new ArrayList<>();
        checkedList.add(2);
        checkedList.add(1);
        checkedList.add(-4);
        checkedList.add(4);
        List<Integer> dd = Collections.checkedList(
            new ArrayList<>(checkedList.size()), Integer.class);
        dd.addAll(checkedList);
        System.out.println(dd);
        for (Integer elem: dd){
            System.out.println("value: " + elem + " byteValue: " + elem.byteValue() + " compareTo(2): " + elem.compareTo(2));
        }
        System.out.println("=============");

        System.out.println("ARRAY LIST");
        List<Integer> integerList = new ArrayList<>();
        integerList.add(3);
        integerList.add(2);
        integerList.add(1);
        System.out.println(integerList);
        for(Integer q: integerList){
            System.out.print(q + " ");
        }
        System.out.println();
        Collections.shuffle(integerList);
        System.out.println("shuffle: " + integerList);
        Collections.reverse(integerList);
        System.out.println("reverse: " + integerList);
        System.out.println("binary search: " +  Collections.binarySearch(integerList, 1));
        System.out.println("synchronized: " + Collections.synchronizedCollection(integerList));
        System.out.println("=============");

        System.out.println("HASH MAP");
        Map<Integer, Integer> lilMap = new HashMap<>();
        lilMap.put(1, 2);
        lilMap.put(null, 3);
        lilMap.put(2, 2);
        lilMap.put(3, 2);
        System.out.println(lilMap);
        System.out.println("keys: " + lilMap.keySet() + " values: " + lilMap.values() + " is contain key null: " + lilMap.containsKey(null));
        System.out.println(lilMap.get(null).hashCode());
        System.out.println("=============");


        System.out.println("LINKED HASH MAP");
        Map<Integer, Integer> lilLinkedMap = new LinkedHashMap<>();
        lilLinkedMap.put(1, 2);
        lilLinkedMap.put(null, 3);
        lilLinkedMap.put(2, 2);
        lilLinkedMap.put(3, 2);
        System.out.println(lilLinkedMap);
        System.out.println("keys: " + lilLinkedMap.keySet() + " values: " + lilLinkedMap.values() + " is contain key null: " + lilLinkedMap.containsKey(null));
        System.out.println(lilLinkedMap.get(null).hashCode());
        System.out.println("=============");

        System.out.println("ENUM MAP");
        EnumMap<MONTH, String> enumMap = new EnumMap<>(MONTH.class);
        enumMap.put(MONTH.NOVEMBER, "rainy");
        enumMap.put(MONTH.SEPTEMBER, "sunny");
        enumMap.put(MONTH.OCTOBER, "cloudy");
        System.out.println(enumMap);
        System.out.println("=============");

        System.out.println("SORTED MAP");
        SortedMap<Integer, Integer> sortedMap = new TreeMap<>();
        sortedMap.put(1, 1);
        sortedMap.put(-1, -1);
        sortedMap.put(0, 0);
        sortedMap.put(-3, -3);
        sortedMap.put(5, 5);
        System.out.println(sortedMap);
        System.out.println("submap(): " + sortedMap.subMap(-1, 1));
        System.out.println("firstKey: " + sortedMap.firstKey());
        System.out.println("=============");

        System.out.println("NAVIGABLE MAP");
        NavigableMap<Double, Integer> navigableMap = new TreeMap<>();
        navigableMap.put(1.0,1);
        navigableMap.put(-1.0,-1);
        navigableMap.put(0.0,0);
        navigableMap.put(-3.0,-3);
        navigableMap.put(4.0,4);
        System.out.println(navigableMap);
        System.out.println("descending key set: " + navigableMap.descendingKeySet());
        System.out.println("descending map: " + navigableMap.descendingMap());
        System.out.println("first entry: " + navigableMap.firstEntry());
        System.out.println("floor entry(1.5): " + navigableMap.floorEntry(1.5)); ///элт с наиб ключом, кот <= данному значению или null, если такого ключа в мапе нет
        System.out.println("ceiling entry(1.5): " + navigableMap.ceilingEntry(1.5));//элт с наиб ключом, кот >= данному значению или null, если такого ключа в мапе нет
        System.out.println("lower entry(1.5): " + navigableMap.lowerEntry(1.5));//элт с наиб ключом, кот < данного значению или null, если такого ключа в мапе нет
        System.out.println("higher entry(1.5): " + navigableMap.higherEntry(1.5));//элт с наиб ключом, кот > данного значению или null, если такого ключа в мапе нет
        System.out.println("tail map(-1): " + navigableMap.tailMap(-1.0));
        System.out.println("head map(-1): " + navigableMap.headMap(-1.0));
        System.out.println();
        System.out.println("=============");

        System.out.println("TREE MAP");
        TreeMap<Integer, Integer> lilTreeMap = new TreeMap<>();
        lilTreeMap.put(1, -3);
        lilTreeMap.put(2, 5);
        lilTreeMap.put(-3, 2);
        lilTreeMap.put(0, 5);
        lilTreeMap.put(-7, -9);
        System.out.println(lilTreeMap);
        System.out.println(lilTreeMap.firstEntry());
        System.out.println(lilTreeMap.containsKey(3));
        System.out.println(lilTreeMap.floorKey(3));
        lilTreeMap.remove(0);
        System.out.println(lilTreeMap);
        System.out.println("=============");


        System.out.println("HASH SET");
        Set<Integer> lilSet = new HashSet<>();
        lilSet.add(1);
        lilSet.add(-2);
        lilSet.add(3);
        lilSet.add(0);
        System.out.println(lilSet);
        lilSet.remove(-2);
        System.out.println(lilSet);
        Set<Integer> lilSet2 = lilSet;
        Set<Integer> lilSet3 = (Set<Integer>) ((HashSet<Integer>) lilSet).clone();
        System.out.println(lilSet == lilSet2);
        System.out.println(lilSet == lilSet3);
        System.out.println("=============");

        System.out.println("QUEUE");
        Queue<Integer> integerQueue = new LinkedList<>();
        integerQueue.add(1);
        integerQueue.add(3);
        integerQueue.add(-3);
        integerQueue.add(5);
        System.out.println(integerQueue);
        integerQueue.remove();
        System.out.println(integerQueue);
        integerQueue.poll();
        System.out.println(integerQueue);
        Integer q = integerQueue.element();
        System.out.println(q);
        Integer z = integerQueue.peek();
        System.out.println(z);
        integerQueue.add(-5);
        integerQueue.add(-7);
        integerQueue.add(-6);
        System.out.println(integerQueue);
        System.out.println(((LinkedList<Integer>) integerQueue).getFirst());
        ((LinkedList<Integer>) integerQueue).sort((a, b)-> {
            return a.compareTo(b);
        });
        System.out.println(integerQueue);
        System.out.println("=============");

        System.out.println("COPY ON WRITE ARRAYLIST");
        CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add(1);
        copyOnWriteArrayList.add(2);
        copyOnWriteArrayList.add(-3);
        copyOnWriteArrayList.add(3);
        System.out.println(copyOnWriteArrayList);
        Iterator iterator = copyOnWriteArrayList.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        copyOnWriteArrayList.add(555);
        iterator = copyOnWriteArrayList.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        ListIterator<Integer> listIterator = copyOnWriteArrayList.listIterator(copyOnWriteArrayList.size());
        while (listIterator.hasPrevious()){
            System.out.print(listIterator.previous() + " ");
        }
        System.out.println();
        System.out.println("=============");

    }
}


enum MONTH{
    SEPTEMBER, OCTOBER, NOVEMBER
}
