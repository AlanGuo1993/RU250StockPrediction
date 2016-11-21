package com.ru.dao;

import java.util.List;

import com.ru.entity.Person;

public interface PersonDAO 
{

	public void addPerson(Person p);
	
    public void updatePerson(Person p);
    
    public List<Person> listPersons();
    
    public Person getPersonById(int id);
    
    public void removePerson(int id);

	public Person getPersonByName(String name);

	//public void removePerson(String name);
	
    public List<Person> searPersonName(String name);
}
