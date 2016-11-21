package com.ru.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ru.entity.Hstock;

public class HstockDAOImpl implements HstockDAO{

	private static final Logger log = LoggerFactory.getLogger(StockDAOImpl.class.getName());
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<Hstock> searchStockByName(String stock) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Hstock where stock like ? order by date");
		q.setParameter(0, stock);
		List<Hstock> list = q.list();
		
		if(!list.isEmpty()){
			return list;
			}
		else
			return null;
	}
	
	@Override
	public double getHighestTen(String stock){
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		
		String sql        = "SELECT `close` FROM hstock WHERE DATE_FORMAT(DATE, '%Y-%m-%d') > DATE_SUB(CURDATE(),INTERVAL 10 DAY) AND stock = ? ORDER BY CLOSE DESC";
		SQLQuery q = session.createSQLQuery(sql);
		q.setParameter(0, stock);
		List<Double> list = q.list() ;
		double result=0;
		if(list.size()>0){
			result = list.get(0);
		}
		return result;
	}
	
	@Override
	public List<Hstock> getLowest(String stock){
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Hstock where stock like ? order by close ");
		q.setParameter(0, stock);
		List<Hstock> list = q.list();
		return list;
	}
	
	@Override
	public List<Hstock> getByStock(String stock){
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("");
		q.setParameter(0, stock);
		List<Hstock> list = q.list();
		return list;
	}
	/*SELECT A.stock FROM (SELECT stock, AVG(CLOSE) price FROM hstock WHERE DATE_FORMAT(DATE, '%Y-%m-%d') > DATE_SUB(CURDATE(),INTERVAL 1 YEAR) GROUP BY stock) A
WHERE A.price < (SELECT MIN(CLOSE) FROM hstock WHERE stock = 'GOOG' AND DATE_FORMAT(DATE, '%Y-%m-%d') > DATE_SUB(CURDATE(),INTERVAL 1 YEAR));*/
	@Override
	public List<Hstock> getAvg(String stock){
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "SELECT AVG(close),stock FROM hstock where stock=?";
		SQLQuery q = session.createSQLQuery(sql);
		q.setParameter(0, stock);
		List<Hstock> list = q.list();
		return list;
	}
	
	@Override
	public List<String> getLowerThanGoog(){
		Session session = this.sessionFactory.getCurrentSession();
		
		String sql        = "SELECT A.stock FROM (SELECT stock, AVG(CLOSE) price FROM hstock WHERE DATE_FORMAT(DATE, '%Y-%m-%d') > DATE_SUB(CURDATE(),INTERVAL 1 YEAR) GROUP BY stock)A"+
							" WHERE A.price < (SELECT MIN(CLOSE) FROM hstock WHERE stock = 'GOOG' AND DATE_FORMAT(DATE, '%Y-%m-%d') > DATE_SUB(CURDATE(),INTERVAL 1 YEAR))";
		SQLQuery q = session.createSQLQuery(sql);
		//q.setParameter(0, stock);
		List<String> list = q.list() ;
		return list;
	}
	
}
