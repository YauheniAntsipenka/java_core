package streams.xml.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class DOMParser {
    public static void start(){
        File input = new File("d:\\data\\books.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(input);

            System.out.println("Root elem: " + document.getDocumentElement().getNodeName());

            NodeList children = document.getElementsByTagName("book");
            for (int i = 0; i < children.getLength(); i++){
                Node node = children.item(i);
                System.out.println(node.getNodeName());

                if (node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;
                    System.out.println("Book id: " + element.getAttribute("id"));
                    System.out.println("author: " + element.getElementsByTagName("author").item(0).getTextContent());
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}
