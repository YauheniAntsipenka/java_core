package streams;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class ReaderWriters {
    public static void start() throws IOException {
        Writer writer = new FileWriter("d:\\data\\4.txt");
        writer.write("TADADAM");
        writer.close();

        read("d:\\data\\3.txt");
        System.out.println();
        read("d:\\data\\4.txt");
    }

    private static void read(String path) throws IOException {
        Reader reader = new FileReader(path);
        int data = reader.read();
        while (data != -1){
            char dataChar = (char) data;
            System.out.print(dataChar);
            data = reader.read();
        }
        reader.close();
    }
}
