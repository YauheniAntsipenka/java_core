package streams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serialization {
    public static void start() throws IOException, ClassNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream("tmp.out");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        TestSerial testSerial = new TestSerial();
        testSerial.version = 1000;
        objectOutputStream.writeObject(testSerial);
        objectOutputStream.flush();
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("tmp.out");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        TestSerial testSerial1 = (TestSerial) objectInputStream.readObject();
        System.out.println(testSerial1.version);
    }
}
class TestParent implements Serializable{

}

class TestSerial extends TestParent{
    public transient int version = 2;
    public byte count = 0;

    @Override
    public String toString() {
        return "TestSerial{" +
            "version=" + version +
            ", count=" + count +
            '}';
    }
}
