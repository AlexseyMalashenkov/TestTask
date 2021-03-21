package parse;

import dto.WeatherDTO;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class ParserDataWeather {
    private static final ArrayList<WeatherDTO> weathers = new ArrayList<>();
    private static boolean key = false;
    private static int count = 0;
    private static String night = null;
    private static String day = null;
    private static String pressure = null;
    private static String date = null;
    private static String altitude = null;
    private static String latitude = null;
    private static String longitude = null;

    public ArrayList<WeatherDTO> parseXMLWeather(String url) {
        InputStream path = null;
        try {
            path = new URL(url).openStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        Document document = null;
        try {
            document = builder.parse(path);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }

        findLocation(document.getDocumentElement());


        findInfo(document.getDocumentElement());

        return weathers;
    }

    private static void findLocation(Node node) {
        NodeList list = node.getChildNodes();

        if (node.getNodeName().equals("location") && node.getNodeType() == Node.ELEMENT_NODE && !key) {
            Element locationElement = (Element) node;

            Element tempElement = (Element) locationElement.getElementsByTagName("location").item(0);
            altitude = tempElement.getAttribute("altitude");
            latitude = tempElement.getAttribute("latitude");
            longitude = tempElement.getAttribute("longitude");
            key = true;
        }

        for (int i = 0; i < list.getLength(); i++) {
            Node currentNode = list.item(i);
            findLocation(currentNode);
        }
    }

    private static void findInfo(Node node) {
        NodeList list = node.getChildNodes();

        if (node.getNodeName().equals("time") && node.getNodeType() == Node.ELEMENT_NODE) {
            Element timeElement = (Element) node;
            date = timeElement.getAttribute("day");

            Element tempElement = (Element) timeElement.getElementsByTagName("temperature").item(0);
            night = tempElement.getAttribute("night");
            day = tempElement.getAttribute("morn");

            Element tempElement2 = (Element) timeElement.getElementsByTagName("pressure").item(0);
            pressure = tempElement2.getAttribute("value");

            if ( (altitude != null && !altitude.isEmpty()) && (latitude != null && !latitude.isEmpty()) && (longitude != null && !longitude.isEmpty()) && count < 5) {
                weathers.add(new WeatherDTO(latitude, longitude, altitude, Double.parseDouble(day), Double.parseDouble(night), Integer.parseInt(pressure), date));
                date = null;
                day = null;
                night = null;
                pressure = null;
                count++;
            }
        }

        for (int i = 0; i < list.getLength(); i++) {
            Node currentNode = list.item(i);
            findInfo(currentNode);
        }
    }
}
