package com.ru.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ru.dao.HstockDAO;
import com.ru.entity.Hstock;

public class HstockServiceImpl implements HstockService{

private HstockDAO hstockDAO;
	
	public void setHstockDAO(HstockDAO hstockDAO) 
	{
		this.hstockDAO = hstockDAO;
	}
	
	@Override
	@Transactional
	public List<Hstock> searchStockByName(String stock) {
		// TODO Auto-generated method stub
		return hstockDAO.searchStockByName(stock);
	}
	
	@Override
	@Transactional
	public double getAverage(String stock){
		
		List<Hstock> list = hstockDAO.searchStockByName(stock);
		double sum = 0;
		for (int i = 0;i<list.size();i++){
			sum = sum + list.get(i).getClose();
		}
		double avg = (sum)/list.size();
		return avg;
	}
	
	@Override
	@Transactional
	public String getLowest(String stock){
		
		List<Hstock> list = hstockDAO.getLowest(stock);
		double lowest = list.get(0).getClose();
		return String.format("%.2f", lowest);
	}
	
	@Override
	@Transactional
	public String getHighest(String stock){
		
		//List<Hstock> list = hstockDAO.getLowest(stock);
		double lowest =  hstockDAO.getHighestTen(stock);
		return String.format("%.2f", lowest);
	}
	
	@Override
	@Transactional
	public List<String> getLower(){
		
		List<String> list = hstockDAO.getLowerThanGoog();

		return list;
	}

	
}
