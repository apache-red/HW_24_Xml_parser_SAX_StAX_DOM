package com.redcompany.red.entity.person;

import com.redcompany.red.entity.behavior.Hobby;

public abstract class FamilyMember {
    public abstract void setAge(int parseInt);

    public abstract void setSurname(String textValue);

    public abstract void setName(String textValue);

    public abstract void setGender(String textValue);

    public abstract void setMaidenname(String textValue);

    public abstract void addHobby(Hobby hobby);

}
