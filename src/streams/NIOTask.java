package streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NIOTask {
    public static void start(){
        Path path = Paths.get("d:\\data\\4.txt");
        System.out.println(path.getFileName() + " in " + path.getFileSystem());
        System.out.println(path.getParent() + " root: " + path.getRoot());
        for(Path elem: path){
            System.out.println(elem);
        }

        Path pathDir = Paths.get("d:\\data\\newDir2");
        try {
            Path newPath = Files.createDirectory(pathDir);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(Files.isReadable(pathDir));
        System.out.println(Files.isWritable(pathDir));
        System.out.println(Files.isExecutable(pathDir));

        try {
            Files.deleteIfExists(pathDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
