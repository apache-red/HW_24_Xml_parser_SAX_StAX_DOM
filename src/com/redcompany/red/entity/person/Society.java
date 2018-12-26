package com.redcompany.red.entity.person;

import java.util.ArrayList;
import java.util.List;

public class Society {



    private List<Family> familyList;

    public Society() {
        createFamilyList();
    }
    
    public void createFamilyList(){
        familyList = new ArrayList<>();
    }

    public void addFamilyToFamilyList(Family family) {
       familyList.add(family);
    }

    public List<Family> getFamilyList() {
        return familyList;
    }


    public void showSiciety(){
        for (int i = 0; i <familyList.size() ; i++) {
            System.out.println(familyList.get(i));
        }
    }

    @Override
    public String toString() {
        return "Society{" +
                "familyList=" + familyList +
                '}';
    }
}
