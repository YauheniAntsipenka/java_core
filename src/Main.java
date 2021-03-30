import collections.CollectionsTasks;
import collectionsConcurrent.ConcurrentCollectionsTasks;
import collectionsv2.CollectionsTask;
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
import strings.TruncateString;
import threads.ThreadsTask;
import threadsV2.ThreadsV2Tasks;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args){
        /* Strings*/
        System.out.println("/* Strings*/");
        StringsTask.start();
        System.out.println("/* Strings*/");
        TruncateString.start();
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


        /*Collectionsv2*/
        System.out.println("/*Collectionsv2*/");
        CollectionsTask.start();

        /*Threads*/
        System.out.println("/*Threads*/");
        ThreadsTask.start();

        /*ThreadsV2*/
        System.out.println("/*ThreadsV2*/");
        try {
            ThreadsV2Tasks.start();
            Thread.sleep(1000);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("==================");

        /*ConcurrentCollections*/
        System.out.println("/*ConcurrentCollections*/");
        try {
            ConcurrentCollectionsTasks.start();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


abstract class A{
    public static void getqeqwe(){
        System.out.println("dfsdf");
    }
}
