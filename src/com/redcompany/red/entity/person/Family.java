package com.redcompany.red.entity.person;

import java.util.ArrayList;
import java.util.List;

public class Family {
    private String adress;
    private Mother mother;
    private Father father;
    private List<Child> childList;


    public Family() {
        childList = new ArrayList<>();
    }

    public Family(String adress, Mother mother, Father father) {
        this.adress = adress;
        this.mother = mother;
        this.father = father;
    }

    public Family(String adress, Mother mother, Father father, List<Child> childList) {
        this.adress = adress;
        this.mother = mother;
        this.father = father;
        this.childList = childList;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setMother(Mother mother) {
        this.mother = mother;
    }

    public void setFather(Father father) {
        this.father = father;
    }

    public void addChildToChaildList(Child child) {

        childList.add(child);
    }

    @Override
    public String toString() {
        return "Family{" +
                "adress='" + adress + '\'' +
                ", mother=" + mother +
                ", father=" + father +
                ", childList=" + childList +
                '}';
    }
}
