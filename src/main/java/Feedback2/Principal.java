/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Feedback2;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author sepy3
 */
public class Principal {

    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
        //Se crea el factory  del DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        //Crear el objeto Document con el archivo XML.
        Document document = builder.parse(new File("departamento.xml"));

        //Validar el XML
        document.getDocumentElement().normalize();
        System.out.println("El fichero se ha normalizado.");

        //Extraemos el nodo raiz
        Element root = document.getDocumentElement();
        System.out.println("El nodo raiz es " + root.getNodeName());

        //Metemos todo en un NodeList
        NodeList nList = root.getElementsByTagName("departamento");
        System.out.println("==================================================");

        for (int i = 0; i < nList.getLength(); i++) {
            Node node = nList.item(i);
            System.out.println("");
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
                System.out.println("Numero: " + eElement.getElementsByTagName("numero").item(0).getTextContent());
                System.out.println("Nombre: " + eElement.getElementsByTagName("nombre").item(0).getTextContent());
                System.out.println("Localidad: " + eElement.getElementsByTagName("localidad").item(0).getTextContent());
                System.out.println("");
                System.out.println("==================================================");
            }
        }
    }
}
