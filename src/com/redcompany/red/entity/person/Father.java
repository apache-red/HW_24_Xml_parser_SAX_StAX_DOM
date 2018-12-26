package com.redcompany.red.entity.person;

import com.redcompany.red.entity.behavior.Hobby;

public class Father  extends  FamilyMember {
	
	private String name;	
	private String surname;
	private int age;
	private String gender;

	public Father() {
	}

	public Father(String name, String surname, int age, String gender) {
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.gender = gender;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}



	@Override
	public void setMaidenname(String textValue) {
	}

	@Override
	public void addHobby(Hobby hobby) {

	}


	@Override
	public String toString() {
		return "Father{" +
				"name='" + name + '\'' +
				", surname='" + surname + '\'' +
				", age=" + age +
				", gender='" + gender + '\'' +
				'}';
	}
}
