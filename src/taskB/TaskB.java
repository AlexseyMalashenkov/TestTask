package taskB;

import parse.ParserDataExchange;

public class TaskB {
    public static void main(String[] args) {
        ParserDataExchange parserDataExchange = new ParserDataExchange();

        parserDataExchange.parseXMLExchange("http://www.cbr.ru/scripts/XML_daily.asp");
    }
}
