package com.cooksys;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
	private AtomicLong idGenerator = new AtomicLong(0);
	private final PersonMapper personMapper;
	private Map<Long, Person> idToPersonMap = new HashMap<>();
	
	public PersonService(PersonMapper personMapper) {
		this.personMapper = personMapper;
	}

	public boolean has(Long id) {
		return id != null && id > 0 && idToPersonMap.containsKey(id);
	}

	public Long add(PersonDto person) {
		Person pojoPerson = personMapper.personDtoToPerson(person);
		pojoPerson.setId(idGenerator.incrementAndGet());
		idToPersonMap.put(pojoPerson.getId(), pojoPerson);
		return pojoPerson.getId();
	}

	public PersonDto get(Long id) {
		return personMapper.personToPersonDto(idToPersonMap.get(id));
	}

	public void put(Long id, PersonDto personDto) {
		BeanUtils.copyProperties(personMapper.personDtoToPerson(personDto), get(personDto.getId()));
		
	}

	public void patch(Long id, PersonDto personDto) {
		idToPersonMap.put(id, personMapper.personDtoToPerson(personDto));
	}

	public void delete(Long id) {
		idToPersonMap.remove(id);
		
	}
	
	public Collection<Person> getElements() {
		return idToPersonMap.values();
	}

}
