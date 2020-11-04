package com.company.model;

import com.company.entity.Forecast;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DOMParsing {
    private List<Forecast> forecastsList = new ArrayList<>();

    private DocumentBuilderFactory dbf;
    private DocumentBuilder db;
    private Document doc;
    private final String url = "https://xml.meteoservice.ru/export/gismeteo/point/434.xml";

    public DOMParsing() {
        dbf = DocumentBuilderFactory.newInstance();
        try {
            db = dbf.newDocumentBuilder();
            doc = db.parse(new URL(url).openStream());
        } catch (ParserConfigurationException e) {
            System.out.println("Serious configuration error");
            e.printStackTrace();
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }

        doc.getDocumentElement().normalize();

        NodeList forecastElements = doc.getElementsByTagName("FORECAST");

        for (int i = 0; i < forecastElements.getLength(); i++) {
            Node forecast = forecastElements.item(i);

            NamedNodeMap fAttributes = forecast.getAttributes();

            int day = new Integer(fAttributes.getNamedItem("day").getNodeValue()).intValue();
            int month = new Integer(fAttributes.getNamedItem("month").getNodeValue()).intValue();
            int year = new Integer(fAttributes.getNamedItem("year").getNodeValue()).intValue();
            int hour = new Integer(fAttributes.getNamedItem("hour").getNodeValue()).intValue();

            NodeList list = forecast.getChildNodes();

            for (int j = 0; j < list.getLength(); j++) {
                Node node = list.item(j);

                if ("TEMPERATURE".equalsIgnoreCase(node.getNodeName())) {
                    NamedNodeMap tAttributes = node.getAttributes();

                    int min = new Integer(tAttributes.getNamedItem("min").getNodeValue()).intValue();
                    int max = new Integer(tAttributes.getNamedItem("max").getNodeValue()).intValue();
                    forecastsList.add(new Forecast(day, month, year, hour, min, max));
                }
            }
        }
    }

    public List<Forecast> getForecastsList() {
        return forecastsList;
    }
}