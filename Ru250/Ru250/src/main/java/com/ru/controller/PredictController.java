package com.ru.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ru.service.StockService;

@Controller
public class PredictController {
	private StockService stockService;

	@Autowired(required=true)
	@Qualifier(value="stockService")
	public void setStockService(StockService stockService) {
		this.stockService =  stockService;
	}

	
	@RequestMapping(value = "/predictAnn", method = RequestMethod.GET)
	@ResponseBody
    public String predictHStockANN(HttpServletRequest request) {
		String name = request.getParameter("name");
		List<Double> list = stockService.predictValueByHStockANN(name, 10);
		//System.out.print(list.get(0));
//		List<String> retString = new ArrayList<String>();
//        for(Double i : list)
//        {
//        	retString.add(String.format("%.2f", i));
//        }
        String result = "";
        for (int a = 0;a<list.size();a++){
        	result = result+"["+String.format("%.2f", list.get(a))+"],";
        }
        result = "["+result.substring(0,result.length()-1)+"]";
        return result;
    }
	
	@RequestMapping(value = "/avgAnn", method = RequestMethod.GET)
	@ResponseBody
    public int avgANN(HttpServletRequest request) {
		String name = request.getParameter("name");
		double sum = 0;
		List<Double> list = stockService.predictValueByHStockANN(name, 10);
		
		for (int i= 0;i<list.size();i++){
			sum = sum+list.get(i);
		}
		double avg = sum/(list.size());
		double first = list.get(0);
		if (avg > first){
			return 1;
		}else if(avg <first){
			return -1;
		}else{
			return 0;
		}
         
    }
	
//	@RequestMapping(value = "/2", method = RequestMethod.POST)
//    public List<Double> predictStockANN(@PathVariable("stock") String stock, @PathVariable("dayToPredict") int dayToPredict) {
//		List<Double> list = stockService.predictValueByStockANN(stock, dayToPredict);
////		System.out.print(list.get(0));
//        return list;
//    }
	
//	@RequestMapping(value = "/3", method = RequestMethod.POST)
//    public double predictStockBayesian(@PathVariable("stock") String stock) {
//		double result = stockService.predictValueByStockBayesian(stock);
//        return result;
//    }
	
	@RequestMapping(value = "/predictBayesian", method = RequestMethod.GET)
	@ResponseBody
    public String predictHStockBayesian(HttpServletRequest request) {
		String name = request.getParameter("name");
		double result = stockService.predictValueByHStockBayesian(name);
		return String.format("%.2f", result);
    }
	
//	@RequestMapping(value = "/5", method = RequestMethod.POST)
//    public int predictValueByStockKDJ(@PathVariable("stock") String stock) {
//		int result = stockService.predictValueByStockKDJ(stock);
//        return result;
//    }
	
	@RequestMapping(value = "/kdj", method = RequestMethod.GET)
	@ResponseBody
    public int predictValueByHStockKDJ(HttpServletRequest request) {
		String name = request.getParameter("name");
		int result = stockService.predictValueByHStockKDJ(name);
        return result;
    }
	
//	@RequestMapping(value = "/7", method = RequestMethod.POST)
//    public int predictValueByStockMACD(@PathVariable("stock") String stock) {
//		int result = stockService.predictValueByStockMACD(stock);
//        return result;
//    }
	
	@RequestMapping(value = "/macd", method = RequestMethod.GET)
	@ResponseBody
    public int predictValueByHStockMACD(HttpServletRequest request) {
		String name = request.getParameter("name");
		int result = stockService.predictValueByHStockMACD(name);
        return result;
    }
	
//	@RequestMapping(value = "/9", method = RequestMethod.POST)
//    public int predictValueByStockRSI(@PathVariable("stock") String stock) {
//		int result = stockService.predictValueByStockRSI(stock);
//        return result;
//    }
	
	@RequestMapping(value = "/rsi", method = RequestMethod.GET)
	@ResponseBody
    public int predictValueByHStockRSI(HttpServletRequest request) {
		String name = request.getParameter("name");
		int result = stockService.predictValueByHStockRSI(name);
        return result;
    }

//	@RequestMapping(value = "/10", method = RequestMethod.POST)
//    public double predictValueByStockSVM(@PathVariable("stock") String stock) {
//		double result = stockService.predictValueByStockSVM(stock);
//        return result;
//    }
	
	@RequestMapping(value = "/predictSvn", method = RequestMethod.GET)
	@ResponseBody
    public String predictValueByHStockSVM(HttpServletRequest request) {
		String name = request.getParameter("name");
		double result = stockService.predictValueByHStockSVM(name);
        return String.format("%.2f", result);

    }
}
