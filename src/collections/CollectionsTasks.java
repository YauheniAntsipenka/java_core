package collections;

public class CollectionsTasks {
    public static void start(){
        Demo1.start();

        System.out.println();

        DynamicVector dynamicVector = new DynamicVector();
        dynamicVector.add("qqq");
        System.out.println(dynamicVector);
        System.out.println(dynamicVector.getLast());
        System.out.println(dynamicVector.getFirst());

        System.out.println();

        CommonDynamicVector<Integer> commonDynamicVector = new CommonDynamicVector<>();
        commonDynamicVector.add(213);
        commonDynamicVector.add(123);
        System.out.println(commonDynamicVector);
        System.out.println(commonDynamicVector.getLast());
        System.out.println(commonDynamicVector.getFirst());

        CarsInGarage.start();
    }
}
