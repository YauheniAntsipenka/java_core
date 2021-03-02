package enums;

import java.util.Arrays;

public class EnumTask {
    public static void start(){
        Month[] months = Month.values();
        for (Month month: months) {
            System.out.println(month);
        }

        System.out.println(Arrays.toString(kekEnum.values()));
    }
}
