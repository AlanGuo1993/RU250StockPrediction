package com.ru.dao;

import java.util.List;

import com.ru.entity.Hstock;

public interface HstockDAO {

	public List<Hstock> searchStockByName(String stock);

	public double getHighestTen(String stock);

	public List<Hstock> getByStock(String stock);

	public List<Hstock> getLowest(String stock);

	public List<Hstock> getAvg(String stock);

	//public List<String> getLowerThanGoog(String stock);

	public List<String> getLowerThanGoog();

}
