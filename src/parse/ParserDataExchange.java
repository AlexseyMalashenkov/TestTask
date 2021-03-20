package parse;

import dto.ExchangeDTO;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;

public class ParserDataExchange {
    private static final ArrayList<ExchangeDTO> exchanges = new ArrayList<>();

    public ArrayList<ExchangeDTO> parseXMLExchange(String url) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser();

            AdvancedXMLHandler handler = new AdvancedXMLHandler();

            parser.parse(url, handler);
        } catch (ParserConfigurationException | SAXException | IOException exception) {
            System.out.println(exception.getMessage());
        }

        return exchanges;
    }

    private static class AdvancedXMLHandler extends DefaultHandler {
        private String numCode, charCode, nominal, name, value, date, lastElement;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            lastElement = qName;
            if (lastElement.equals("ValCurs")) {
                date = attributes.getValue("Date");
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            String information = new String(ch, start, length);

            information = information.replace("\n", "").trim();

            if (!information.isEmpty()) {
                if (lastElement.equals("NumCode")) {
                    numCode = information;
                }
                if (lastElement.equals("CharCode")){
                    charCode = information;
                }
                if (lastElement.equals("Nominal")) {
                    nominal = information;
                }
                if (lastElement.equals("Name")) {
                    name = information;
                }
                if (lastElement.equals("Value")) {
                    value = information;
                }
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            if ( (numCode != null && !numCode.isEmpty()) && (charCode != null && !charCode.isEmpty()) && (nominal != null && !nominal.isEmpty()) && (name != null && !name.isEmpty()) && (value != null && !value.isEmpty()) && (date != null && !date.isEmpty()) ) {
                exchanges.add(new ExchangeDTO(numCode, charCode, nominal, name, value, date));
                numCode = null;
                charCode = null;
                nominal = null;
                name = null;
                value = null;
            }
        }
    }
}
