package innerClasses;

public class AnonOuter {
    AnonOuter(){}

    public void get(){
        Runnable outerMethod;

        outerMethod = () -> {
            System.out.println("eee");
        };

        outerMethod.run();

        Func func;

        func = () -> {
            return "functext";
        };

        System.out.println(func.getFuncMethod());
        System.out.println(func.getDefaultMethod());
        System.out.println(Func.getStaticMethod());
        System.out.println(Func.getStaticMethod2());
    }
}

@FunctionalInterface
interface Func{
    String getFuncMethod();

    default String getDefaultMethod(){
        return "default method";
    }

    static String getStaticMethod(){
        return "static method in interface";
    }

    static String getStaticMethod2(){
        return "static method2 in interface";
    }
}
