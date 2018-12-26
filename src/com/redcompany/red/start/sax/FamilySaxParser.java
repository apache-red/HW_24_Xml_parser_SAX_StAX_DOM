package com.redcompany.red.start.sax;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class FamilySaxParser {



	public static void main (String[] arg) {
		try {
			parserFamilyXML();
		} catch (FamilyParserExeption e) {
			e.printStackTrace();
		}
	}
		
	public static void parserFamilyXML () throws FamilyParserExeption{
		try {
		SAXParserFactory parserFactory = SAXParserFactory.newInstance();
		SAXParser parser = parserFactory.newSAXParser();
		FamilyDefaultHandler fdhtr = new FamilyDefaultHandler();
		parser.parse("resources/Families.xml", fdhtr );

			fdhtr.getSociety().showSiciety();

		} catch (SAXException | ParserConfigurationException | IOException e) {
			throw new FamilyParserExeption("some problem during SAX parser",e);
		}
	}
	
}
