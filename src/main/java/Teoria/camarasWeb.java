/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Teoria;

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
public class camarasWeb {

    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
        //Se crea el factory  del DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        //Crear el objeto Document con el archivo XML.
        Document document = builder.parse(new File("camaraWeb.xml"));
        System.out.println("El fichero existe.");

        //Validar el XML
        document.getDocumentElement().normalize();
        System.out.println("El fichero esta normalizado.");

        //Extraemos el nodo raiz
        Element root = document.getDocumentElement();
        System.out.println(root.getNodeName());

        //Metemos todo en un NodeList
        NodeList nList = root.getElementsByTagName("camara");
        System.out.println("================================");
        
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node node = nList.item(temp);
            System.out.println("");
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
                System.out.println("Camara: " + eElement.getAttribute("id"));
                System.out.println("Modelo: " + eElement.getElementsByTagName("modelo").item(0).getTextContent());
                System.out.println("Marca: " + eElement.getElementsByTagName("marca").item(0).getTextContent());
                
                int megapixel = Integer.parseInt(eElement.getElementsByTagName("megapixeles").item(0).getTextContent());
                System.out.println(megapixel + 100 + " px.");
            }
        }
    }
}
