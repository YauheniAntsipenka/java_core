package strings;

public class StringsTask {
    public static void start(){
        String s1 = "123";
        String s2 = "123";
        System.out.println(s1 == s2); //пул строк
        String s3 = new String("123");
        System.out.println(s1 == s3); //сравниваем ссылки
        System.out.println(s2 == s3); //сравниваем ссылки
        String s4 = new String("123").intern(); //грубо говоря, тот же пул строк. hashset.
        System.out.println(s2 == s4); //строка с интернированой строкой
        System.out.println(s3 == s4); //ссылка на объект с интернированной строкой


        System.out.println("Text".length());

        String text = "Im Groot";
        StringBuffer sb = new StringBuffer(text);
        text = sb.reverse().toString();
        System.out.println(text);
    }
}
