package helpers;

public class TimeHelper {
    public static long startTime = 0;
    public static long endTime = 0;

    public static String getRangeInSeconds(){
        double range = (endTime - startTime)/1000.0;
        return range + " seconds";
    }
}
