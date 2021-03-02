package staticVars;

public class StatTask {
    public static void start(){
        StaticVars obj1 = new StaticVars();
        System.out.println(StaticVars.amountOfObjects);
        StaticVars obj2 = new StaticVars();
        System.out.println(StaticVars.amountOfObjects);
    }
}
