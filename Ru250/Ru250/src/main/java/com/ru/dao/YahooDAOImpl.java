package com.ru.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ru.entity.Stock;

public class YahooDAOImpl implements YahooDAO {

	
	private static final Logger log = LoggerFactory.getLogger(YahooDAOImpl.class.getName());
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void insertStock(Stock stock) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(stock);
        log.info("Stock saved successfully, stock Details="+stock);
	}

}
