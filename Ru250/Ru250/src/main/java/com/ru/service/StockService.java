package com.ru.service;

import java.util.List;

import com.ru.entity.Stock;

public interface StockService {

	public List<Stock> searchStockByName(String stock);
//    public List<Stock> listStock();
	
	//predict 
	public List<Double> predictValueByStockANN(String stock, int dayToPredict);
	
	//predict 
	public List<Double> predictValueByHStockANN(String stock, int dayToPredict);
	
	//predict 
	public double predictValueByStockBayesian(String stock);
	
	//predict 
	public double predictValueByHStockBayesian(String stock);
	
	//predict 
	public int predictValueByStockKDJ(String stock);
	
	//predict 
	public int predictValueByHStockKDJ(String stock);
	
	//predict 
	public int predictValueByStockMACD(String stock);
	
	//predict 
	public int predictValueByHStockMACD(String stock);
	
	//predict 
	public int predictValueByStockRSI(String stock);
	
	//predict 
	public int predictValueByHStockRSI(String stock);
	
	//predict 
	public double predictValueByStockSVM(String stock);
	
	//predict 
	public double predictValueByHStockSVM(String stock);
}
