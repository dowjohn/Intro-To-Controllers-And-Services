package com.cooksys;

import java.util.ArrayList;
import java.util.List;

public class Person {
	private Long id;
	private String firstName;
	private String lastName;
	private List<Person> friends = new ArrayList<>();
	
	public Person() {}
	
	public Person(String firstName) {
		this.firstName = firstName;
	}
	
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public List<Person> getFriends() {
		return friends;
	}
	public void setFriends(List<Person> friends) {
		this.friends = friends;
	}

}
