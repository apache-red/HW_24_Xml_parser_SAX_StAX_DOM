package com.redcompany.red.start.dom;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DOM {

    private static final String XML_FILE_PATH = "resources/Families.xml";

    public static void main(String[] arg) {
        DOM dom = new DOM();
        dom.readXmlDom();

    }

    public void readXmlDom() {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(XML_FILE_PATH);
            FamilyDomHandler familyDomHandler = new FamilyDomHandler();
            familyDomHandler.parseDocument(document);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private void parseDocument(Document document) {

        Element element = document.getDocumentElement();


    }


}
