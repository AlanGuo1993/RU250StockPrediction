package com.ru.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ru.entity.Person;

@Repository
public class PersonDAOImpl implements PersonDAO 
{

	private static final Logger log = LoggerFactory.getLogger(PersonDAOImpl.class.getName());
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addPerson(Person p) 
	{
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
        log.info("Person saved successfully, Person Details="+p);

	}

	@Override
	public void updatePerson(Person p) 
	{
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.merge(p);
        log.info("Person updated successfully, Person Details="+p);

	}

	@Override
	public List<Person> listPersons() 
	{
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<Person> listP = session.createQuery("FROM Person").list();
		for(Person p: listP)
			log.info("Person List::" + p);
			return listP;
	}
	
	@Override
	public List<Person> searPersonName(String name) 
	{
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Person where name like ?");
		q.setParameter(0, name);
		return q.list();
	}

	@Override
	public Person getPersonById(int id) 
	{
		Session session = this.sessionFactory.getCurrentSession();
		Person person = (Person) session.load(Person.class, new Integer(id));
        log.info("Person loaded successfully, Person details="+person);

		return person;
	}

	@Override
	public Person getPersonByName(String name){
		Session session = this.sessionFactory.getCurrentSession();
		Person person = (Person) session.load(Person.class, new String(name));
		return person;
	}
	
	@Override
	public void removePerson(int id) 
	{
		Session session = this.sessionFactory.getCurrentSession();
		Person person = (Person) session.load(Person.class, new Integer(id));
		if(person != null)
			session.delete(person);
        log.info("Person deleted successfully, person details= "+ person);

	}

}
