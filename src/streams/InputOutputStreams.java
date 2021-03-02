package streams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class InputOutputStreams {
    public static void start() throws IOException {
        try (InputStream inputStream = new FileInputStream("d:\\data\\test.txt")) {
            int data = inputStream.read();
            while (data != -1) {
                data = inputStream.read();
                System.out.print(data + " ");
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (OutputStream outputStream = new FileOutputStream("d:\\data\\3.txt")) {
            outputStream.write("Hello,world".getBytes());
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
