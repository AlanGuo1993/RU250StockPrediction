package com.ru.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ru.commons.MD5;
import com.ru.entity.Person;
import com.ru.entity.Stock;
import com.ru.entity.User;
import com.ru.service.StockService;
import com.ru.service.UserService;

@Controller

public class StockController {

	private StockService stockService;
	
	@Autowired(required=true)
	@Qualifier(value="stockService")
	public void setUserService(StockService stockService) {
		this.stockService = stockService;
	}
	
	@RequestMapping(value = "/searchstock", method = RequestMethod.GET)
    @ResponseBody
    public String searchStockByName(HttpServletRequest request) throws ParseException{
    	String name = request.getParameter("name");
    	List<Stock> stock = stockService.searchStockByName(name);
    	String result = "";
    	for(Stock s : stock){
			long ldate = s.getDate();
			String sdate = new java.text.SimpleDateFormat("yyyy/MM/dd").format(new java.util.Date(ldate * 1000));
			String tsdate = sdate+" "+s.getTime();
			long epoch = new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm").parse(tsdate).getTime();
			//String sdate = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(s.getDate()+"").toString();
			System.out.println(epoch);
//			ldate = ldate*1000;
//			String sdate = Long.toString(ldate);
//			s.setDate(sdate);
		}
    	for(int i=0;i<stock.size();i++){
    		result=result+"["+stock.get(i).getDate()+","+stock.get(i).getValue()+"],";
    	}
    	result = "["+result.substring(0, result.length()-1)+"]";
    	System.out.println(result);
        return result;
    }
	

	
//	@RequestMapping(value = "/liststock", method = RequestMethod.GET)
//    @ResponseBody
//    public List<Stock> listStock(HttpServletRequest request){
//    	List<Stock> stock = stockService.listStock();    	
//        return stock;
//    }
}
