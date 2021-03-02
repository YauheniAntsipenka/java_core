package streams;

import streams.xml.dom.DOMParser;
import streams.xml.sax.XMLParser;

import java.io.IOException;

public class StreamTask {
    public static void start() throws IOException {
        /* Byte in/out */
        System.out.println("/* Byte in/out */");
        InputOutputStreams.start();

        /* Char in/out */
        System.out.println("/* Char in/out */");
        ReaderWriters.start();

        /* serialization */
        System.out.println("/* serialization */");
        try {
            Serialization.start();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        /* NIO */
        System.out.println("/* NIO */");
        NIOTask.start();

        /* XML SAX*/
        System.out.println("/* XML */");
        XMLParser.start();

        /* XML DOM */
        System.out.println("/* XML DOM */");
        DOMParser.start();
    }
}
