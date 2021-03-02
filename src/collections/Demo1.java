package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo1 {
    public static void start(){
        String[] names = {"John", "Smith", "Bob"};
        List<String> listNames = new ArrayList(Arrays.asList(names));
        System.out.println(listNames);
        for (Object name: listNames) {
            System.out.print(name + " ");
        }
        System.out.println();
        listNames.remove(1);
        listNames.forEach(s-> System.out.print(s + " "));
        System.out.println();
        listNames.add("Smithy");
        listNames.forEach(s-> System.out.print(s + " "));
    }
}
