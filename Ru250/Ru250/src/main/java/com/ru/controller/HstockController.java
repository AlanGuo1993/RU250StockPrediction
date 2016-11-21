package com.ru.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ru.entity.Hstock;
import com.ru.entity.Stock;
import com.ru.service.HstockService;
import com.ru.service.StockService;

@Controller
public class HstockController {

private HstockService hstockService;
	
	@Autowired(required=true)
	@Qualifier(value="hstockService")
	public void setHstockService(HstockService hstockService) {
		this.hstockService = hstockService;
	}

	@RequestMapping(value = "/searchhstock", method = RequestMethod.GET)
    @ResponseBody
    public String searchHstockByName(HttpServletRequest request) throws ParseException{
    	String name = request.getParameter("name");
    	List<Hstock> hstock = hstockService.searchStockByName(name);
    	String result = "";
//    	for(Hstock s : hstock){
//    		s.setDate(s.getDate().);
//			System.out.print(s.getDate());
//    		
//			
//		}
    	for(int i=0;i<hstock.size();i++){
    		result=result+"["+new java.text.SimpleDateFormat("yyyy-MM-dd").parse(hstock.get(i).getDate()).getTime()+","+hstock.get(i).getClose()+"],";
    	}
    	result = "["+result.substring(0, result.length()-1)+"]";
    	System.out.println(result);
        return result;
    }
	
	@RequestMapping(value = "/historystock", method = RequestMethod.GET)
    @ResponseBody
    public List<Hstock> searchStockByName(HttpServletRequest request){
    	String name = request.getParameter("name");
    	List<Hstock> hstock = hstockService.searchStockByName(name);
    	
        return hstock;
    }
	
	@RequestMapping(value = "/avgstock", method = RequestMethod.GET)
    @ResponseBody
    public String avg(HttpServletRequest request){
    	String name = request.getParameter("name");
    	double avg = hstockService.getAverage(name);
        return String.format("%.2f", avg);
    }
	
	@RequestMapping(value = "/lowest", method = RequestMethod.GET)
    @ResponseBody
    public String low(HttpServletRequest request){
    	String name = request.getParameter("name");
    	String lowest = hstockService.getLowest(name);
        return lowest;
    }

	@RequestMapping(value = "/highest", method = RequestMethod.GET)
    @ResponseBody
    public String high(HttpServletRequest request){
    	String name = request.getParameter("name");
    	String highest = hstockService.getHighest(name);
        return highest;
    }
	
	@RequestMapping(value = "/lowerthanGOOG", method = RequestMethod.GET)
    @ResponseBody
    public List<String> lower(){
		String lower ="";
		List<String> list = hstockService.getLower();
//		for (int i = 0;i<list.size();i++){
//			lower = lower+","+list.get(i);
//		}
//		String result = "[["+lower.substring(1)+"]]";
        return list;
    }
}
