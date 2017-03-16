package com.cooksys;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PersonMapper {
	
//	 PersonMapper INSTANCE = Mappers.getMapper( PersonMapper.class );
	@Mappings({
		@Mapping(target = "friends")
	})
	PersonDto personToPersonDto(Person person);
	
//	default PersonDto personToPersonDto(Person person) {
//		PersonDto personDto = new PersonDto(person.getFirstName(), person.getLastName());
//		personDto.setId(person.getId());
//		for (Person pers : person.getFriends()) {
//			personDto.getFriends().add(pers.getId());
//		}
//		
//        return personDto;
//    }
	
	default List<Long> friendsToFriendsDto(List<Person> persons) {
		List<Long> returnList = new ArrayList<>();
		for (Person pers : persons) {
			returnList.add(pers.getId());
		}
		return returnList;
	}

	 
	@Mappings({
		@Mapping(target = "friends")
	})
	Person personDtoToPerson(PersonDto personDto);
	
	default List<Person> friendsDtoToFriends(List<Long> ids) {
		List<Person> returnList = new ArrayList<>();
		for (Long id : ids) {
			Person newPerson = new Person();
			newPerson.setId(id);
			returnList.add(newPerson);
		}
		return returnList;
	}
}