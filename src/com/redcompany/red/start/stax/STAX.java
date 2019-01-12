package com.redcompany.red.start.stax;


import com.redcompany.red.entity.person.Society;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class STAX {



    private static final String XML_FILE_PATH = "resources/Families.xml";
private Society society;

    public static void main(String[] arg) {
        STAX stax = new STAX();
        stax.readXmlStax();

    }

    public void readXmlStax() {

        File file = new File(XML_FILE_PATH);
        XMLInputFactory factory = XMLInputFactory.newInstance();
        try {
            XMLStreamReader streamReader = factory.createXMLStreamReader(new FileReader(file));
            FamilyStaxHandler familyStaxHandler = new FamilyStaxHandler();
            society = familyStaxHandler.parseDocument(streamReader);
           society.showSiciety();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }



}
