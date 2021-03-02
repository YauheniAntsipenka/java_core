import collections.CollectionsTasks;
import enums.EnumTask;
import files.FilesTask;
import finalVars.FinalTask;
import innerClasses.InnerClassesTask;
import jdbc.JDBCTask;
import jdbc.JDBCTask2;
import jdbc.TransactionTask;
import staticVars.StatTask;
import streams.StreamTask;
import strings.StringsTask;

import java.io.IOException;

public class Main {
    public static void main(String[] args){
        /* Strings*/
        System.out.println("/* Strings*/");
        StringsTask.start();
        /* InnerClasses*/
        System.out.println("/* InnerClasses*/");
        InnerClassesTask.start();


        /* Static    */
        System.out.println("/* Static    */");
        StatTask.start();

        /* final */
        System.out.println("/* final */");
        FinalTask.start();

        /* Enums */
        System.out.println("/* Enums */");
        EnumTask.start();

        /* Collections */
        System.out.println("/* Collections */");
        CollectionsTasks.start();

        /* Files */
        System.out.println("/* Files */");
        FilesTask.start();

        /* streams */
        System.out.println("/* streams */");
        try {
            StreamTask.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /* JDBC */
        System.out.println("/* JDBC */");
        JDBCTask.start();
        /* JDBC2 */
        System.out.println("/* JDBC2 */");
        JDBCTask2.start();
        /* Transaction */
        System.out.println("/* Transaction */");
        TransactionTask.start();
    }
}


abstract class A{
    public static void getqeqwe(){
        System.out.println("dfsdf");
    }
}
