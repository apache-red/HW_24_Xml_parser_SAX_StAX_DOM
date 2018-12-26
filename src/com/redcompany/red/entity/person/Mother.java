package com.redcompany.red.entity.person;

import com.redcompany.red.entity.behavior.Hobby;

import java.util.Objects;

public class Mother extends  FamilyMember {

	private String name;	
	private String surname;
	private String maidenname;
	private String gender;
	private int age;
	private Hobby hobby;

	public Mother(String name, String surname, String maidenname, String gender, int age, Hobby hobby) {
		this.name = name;
		this.surname = surname;
		this.maidenname = maidenname;
		this.gender = gender;
		this.age = age;
		this.hobby = hobby;
	}

	public Mother() {
		hobby = new Hobby();
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setMaidenname(String maidenname) {
		this.maidenname = maidenname;
	}

	@Override
	public void addHobby(Hobby hobby) {
		this.hobby = hobby;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setAge(int age) {
		this.age = age;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Mother mother = (Mother) o;
		return age == mother.age &&
				Objects.equals(name, mother.name) &&
				Objects.equals(surname, mother.surname) &&
				Objects.equals(maidenname, mother.maidenname) &&
				Objects.equals(gender, mother.gender) &&
				Objects.equals(hobby, mother.hobby);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, surname, maidenname, gender, age, hobby);
	}

	@Override
	public String toString() {
		return "Mother{" +
				"name='" + name + '\'' +
				", surname='" + surname + '\'' +
				", maidenname='" + maidenname + '\'' +
				", gender='" + gender + '\'' +
				", age=" + age +
				", hobby=" + hobby +
				'}';
	}
}
