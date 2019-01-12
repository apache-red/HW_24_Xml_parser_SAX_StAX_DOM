package com.redcompany.red.start.stax;

import com.redcompany.red.entity.behavior.Hobby;
import com.redcompany.red.entity.behavior.HobbyDayAndTime;
import com.redcompany.red.entity.behavior.Schema;
import com.redcompany.red.entity.person.*;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class FamilyStaxHandler {

    private Society society;
    private Family family;
    private FamilyMember familyMember;
    private Hobby hobby;
    private Schema schema;
    private HobbyDayAndTime hobbyDayAndTime;
    private String attr;
    private String tagName;
    private String textValue;

    public Society parseDocument(XMLStreamReader reader) throws XMLStreamException {
        while (reader.hasNext()) {
            switch (reader.next()) {
                case XMLStreamConstants.START_ELEMENT:
                    if (reader.getAttributeValue(0)!= null){
                        attr = reader.getAttributeValue(0);
                    }
                        tagName = reader.getLocalName();
                        entityMatch(tagName);
                    break;
                case XMLStreamConstants.CHARACTERS:
                    if (!reader.isWhiteSpace()) {
                        textValue = reader.getText();
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    tagName = reader.getLocalName();
                    setEntityData(tagName, textValue);
                    break;
            }
        }
        return society;
    }

    private void entityMatch(String tagName) {
        switch (tagName) {
            case "Families":
                this.society = new Society();
                break;
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

