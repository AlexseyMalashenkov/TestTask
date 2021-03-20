package taskB;

import dto.ExchangeDTO;
import parse.ParserDataExchange;

import java.util.ArrayList;

public class TaskB {
    public static void main(String[] args) {
        printRate("http://www.cbr.ru/scripts/XML_daily.asp", "JPY");
    }

    private static void printRate(String url, String charCode) {
        ParserDataExchange parserDataExchange = new ParserDataExchange();

        ArrayList<ExchangeDTO> exchanges = parserDataExchange.parseXMLExchange(url);

        for (ExchangeDTO exchange : exchanges) {
            if(exchange.getCharCode().equals(charCode)) {
                System.out.println(exchange.toString());
            }
        }
    }
}
