package com.cooksys;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PersonDto {
	
	@Min(1)
	private Long id;
	
	@NotNull
	@Size(min = 1, max = 100)
	private String firstName;
	
	@Size(min = 1, max = 100)
	private String lastName;
	
	private List<Long> friends = new ArrayList<>();
	
	public PersonDto() {}
	
	public PersonDto(String firstName) {
		this.firstName = firstName;
	}
	
	public PersonDto(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public long getId() {
		return this.id;
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

	public List<Long> getFriends() {
		return friends;
	}

	public void setFriends(List<Long> friends) {
		this.friends = friends;
	}
	
}
