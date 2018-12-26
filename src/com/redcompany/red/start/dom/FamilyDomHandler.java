package com.redcompany.red.start.dom;

import com.redcompany.red.entity.behavior.Hobby;
import com.redcompany.red.entity.behavior.HobbyDayAndTime;
import com.redcompany.red.entity.behavior.Schema;
import com.redcompany.red.entity.person.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FamilyDomHandler {
    private Element element;
    private NodeList nodeList;

    private Society society;
    private Family family;
    private FamilyMember familyMember;
    private Hobby hobby;
    private Schema schema;
    private HobbyDayAndTime hobbyDayAndTime;
    private String textValue;
    private String tagName;


    public FamilyDomHandler() {
        society = new Society();
    }

    public void parseDocument(Document document) {

        this.element = document.getDocumentElement();

        getElement(element);
        combineWithEntity(nodeList);
        System.out.println();

    }

    private void getElement(Element element) {
        this.nodeList = element.getChildNodes();
    }

    private void combineWithEntity(NodeList nodeList) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i) instanceof Element) {
                tagName = ((Element) nodeList.item(i)).getTagName();
                choice();
                family.setAdress(((Element) nodeList.item(i)).getAttribute("adress"));
                Element current = (Element) nodeList.item(i);
                NodeList childElements = current.getChildNodes();
                for (int j = 0; j < childElements.getLength(); j++) {
                    if (nodeList.item(j) instanceof Element) {
                        tagName = ((Element) nodeList.item(j)).getTagName();
                        choice();
                        Element current2 = (Element) nodeList.item(j);
                        NodeList childElements2 = current.getChildNodes();

                        for (int k = 0; k < childElements2.getLength(); k++) {
                            if (nodeList.item(k) instanceof Element) {
                                tagName = ((Element) nodeList.item(k)).getTagName();
                                System.out.println(tagName);
                            }
                        }


                    }

                }

            }
        }
    }


    private void choice() {
        switch (tagName) {
            case "family":
                family = new Family();
                society.addFamilyToFamilyList(family);
                break;
            case "mother":
                familyMember = new Mother();
                family.setMother((Mother) familyMember);
                break;
            case "father":
                familyMember = new Father();
                family.setFather((Father) familyMember);
                break;
            case "child":
                familyMember = new Child();
                family.addChildToChaildList((Child) familyMember);
                break;
            case "maidenname":

                break;
            case "name":
                break;
            case "surname":
                break;
            case "age":
                break;
            case "gender":
                break;
            case "hobby":
                hobby = new Hobby();
                familyMember.addHobby(hobby);
                break;
            case "title":
                break;
            case "times-per-week":
                break;
            case "schedule":
                schema = new Schema();
                hobby.setSchema(schema);
                break;
            case "day_name":
                hobbyDayAndTime = new HobbyDayAndTime();
                schema.addDayAndTimeToSchemaList(hobbyDayAndTime);
                break;
            case "time":
                break;
            default:
                break;
        }

    }
}
