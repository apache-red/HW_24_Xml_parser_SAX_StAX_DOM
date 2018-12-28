package com.redcompany.red.start.stax;

import com.redcompany.red.entity.behavior.Hobby;
import com.redcompany.red.entity.behavior.Schema;
import com.redcompany.red.entity.person.Family;
import com.redcompany.red.entity.person.FamilyMember;
import com.redcompany.red.entity.person.Mother;
import com.redcompany.red.entity.person.Society;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class STAX {


    private static final String XML_FILE_PATH = "resources/Families.xml";

    private static boolean nameFlag;
    private static boolean ageFlag;
    private static boolean languageFlag;
//    private static boolean languageFlag;
//    private static boolean languageFlag;


    private Society society;
    private Family family;
    private FamilyMember familyMember;
    private Hobby hobby;
    private Schema schema;

    public static void main(String[] arg) {
        STAX stax = new STAX();
        stax.readXmlStax();

    }

    public void readXmlStax() {
        InputStream input = null;
        try {
            input = new FileInputStream(new File(XML_FILE_PATH));
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
            FamilyStaxHandler familyStaxHandler = new FamilyStaxHandler();
            familyStaxHandler.parseDocument(reader);
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
    }


}
