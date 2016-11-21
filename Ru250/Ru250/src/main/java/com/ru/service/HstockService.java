package com.ru.service;

import java.util.List;

import com.ru.entity.Hstock;

public interface HstockService {

	public List<Hstock> searchStockByName(String stock);

	public double getAverage(String stock);

	public String getLowest(String stock);

	public String getHighest(String stock);

	public List<String> getLower();


}
