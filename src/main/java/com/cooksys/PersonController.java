package com.cooksys;

import java.util.Collection;

import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("person")
public class PersonController {
	private PersonService personService;
	
	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	
	@RequestMapping(method = RequestMethod.HEAD, value = "{id}")
	public void has(@PathVariable Long id, HttpServletResponse response) {
		if(!personService.has(id)) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
	}
	
	@RequestMapping("{id}")
	public PersonDto get(@PathVariable Long id, HttpServletResponse response) {
		PersonDto personDto = personService.get(id);
		if (personDto == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
		return personDto;
	}
	
	@PostMapping
	public Long add(@RequestBody @Validated PersonDto person, HttpServletResponse response) {
		Long result = personService.add(person);
		if (result > 0)
			response.setStatus(HttpServletResponse.SC_CREATED);
		return result;
	}
	
	@PutMapping("{id}")
	public void put(@PathVariable Long id, @RequestBody @Validated PersonDto personDto, HttpServletResponse response) {
		personService.put(id, personDto);
	}
	
	@PatchMapping("{id}")
	public void patch(@PathVariable Long id, @RequestBody @Validated PersonDto personDto, HttpServletResponse response) {
		personService.patch(id, personDto);
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		personService.delete(id);
	}
	
	@GetMapping()
	public Collection<Person> get() {
		return personService.getElements();
	}

}

