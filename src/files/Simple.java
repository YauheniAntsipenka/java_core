package files;

import java.io.File;

public class Simple {
    public static void start(){
        File file = new File("d:\\data\\test.txt");
        System.out.println(file.exists());
        System.out.println(file.length());
        /*if (file.renameTo(new File("d:\\data\\2.txt"))){
            System.out.println(file.exists());
            file.delete();
            System.out.println(file.exists());
        }*/

        File dir = new File("d:\\data\\newFolder");
        System.out.println(dir.exists());
        if (dir.mkdir()){
            System.out.println("dir is exists: " + dir.exists());
            System.out.println("dir isDirectory: " + dir.isDirectory());
        }

        String[] fileNames = dir.list();
        for (String fileName: fileNames){
            System.out.println(fileName);
        }
        File[] files = dir.listFiles();
    }
}
