package com.redcompany.red.start.dom;

import com.redcompany.red.entity.behavior.Hobby;
import com.redcompany.red.entity.behavior.HobbyDayAndTime;
import com.redcompany.red.entity.behavior.Schema;
import com.redcompany.red.entity.person.*;
import org.w3c.dom.*;

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
    private String attr;


    public FamilyDomHandler() {
        society = new Society();
    }


    public void parseDocument(Document document) {
        this.element = document.getDocumentElement();

            this.nodeList = getNodeList(element);
            parseNodList(this.nodeList);

society.showSiciety();
    }


    private NodeList getNodeList(Element element) {
        return element.getChildNodes();
    }

    private void parseNodList(NodeList nodeList) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i).getNodeType() == 1) {
                if (nodeList.item(i).getAttributes() != null) {
                    this.attr = ((Element) nodeList.item(i)).getAttribute("adress");
                }
                tagName = nodeList.item(i).getNodeName();
                entityMatch(tagName);
                Text text = (Text) nodeList.item(i).getFirstChild();
                textValue = text.getData().trim();
                setEntityData(tagName, textValue);
                Element current = (Element) nodeList.item(i);
                NodeList childList = getNodeList(current);
                parseNodList(childList);
            }
        }

    }

    private void entityMatch(String tagName) {
        switch (tagName) {
            case "family":
                this.family = new Family();
                break;
            case "mother":
                this.familyMember = new Mother();
                break;
            case "father":
                this.familyMember = new Father();
                break;
            case "child":
                this.familyMember = new Child();
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
                this.hobby = new Hobby();
                break;
            case "title":
                break;
            case "times-per-week":
                break;
            case "schedule":
                this.schema = new Schema();
                break;
            case "day_name":
                this.hobbyDayAndTime = new HobbyDayAndTime();
                break;
            case "time":
                break;
            default:
                break;
        }
    }

    private void setEntityData(String tagName, String textValue) {
        switch (tagName) {
            case "family":
                family.setAdress(attr);
                society.addFamilyToFamilyList(family);
                break;
            case "mother":
                  family.setMother((Mother) familyMember);
                break;
            case "father":
                family.setFather((Father) familyMember);
                break;
            case "child":
                family.addChildToChaildList((Child) familyMember);
                break;
            case "maidenname":
                familyMember.setMaidenname(textValue);
                break;
            case "name":
                familyMember.setName(textValue);
                break;
            case "surname":
                familyMember.setSurname(textValue);
                break;
            case "age":
                familyMember.setAge(Integer.parseInt(textValue));
                break;
            case "gender":
                familyMember.setGender(textValue);
                break;
            case "hobby":
                familyMember.addHobby(hobby);
                break;
            case "title":
                hobby.setHobby_name(textValue);
                break;
            case "times-per-week":
                hobby.setTimes_per_week(textValue);
                break;
            case "schedule":
                hobby.setSchema(schema);
                break;
            case "day_name":
                hobbyDayAndTime.setDay(textValue);
                break;
            case "time":
                hobbyDayAndTime.setTime(textValue);
                schema.addDayAndTimeToSchemaList(hobbyDayAndTime);
                break;
            default:
                break;
        }
    }

}
