//package com.ru.algorithm;
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import com.ru.dao.StockDAO;
//import com.ru.service.StockService;
//import com.ru.service.YahooService;
//
///**
// * Created by GA on 4/24/16.
// */
//public class Test
//{
//    public static void main(String[] args)
//    {
////        ArrayList<Double> test = new ArrayList<Double>();
////        try
////        {
////            BufferedReader bufferedReader = new BufferedReader(new FileReader("apple.txt"));
////            String line;
////            while((line = bufferedReader.readLine()) != null)
////            {
////                test.add(Double.parseDouble(line));
////            }
////        }
////        catch (Exception e)
////        {
////            e.printStackTrace();
////        }
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("WEB-INF/applicationContext.xml");
//		StockService sv = (StockService) ctx.getBean("stockService");
//    	List<Double> test = sv.predictValueByStock("GOOG", 5);
//        List<Double> result;
//        Launcher launcher = new Launcher();
//
//        // test is the input List of historical value
//        // result is the return List of prediction value
//        result = launcher.launch(test, 5);
//        for(Double i : test)
//        {
//            System.out.println(i);
//        }

//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("WEB-INF/applicationContext.xml");
//		StockService sv = (StockService) ctx.getBean("stockService");
//    	List<Double> test = sv.predictValueByStock("GOOG", 5);
//        List<Double> result;
//        Launcher launcher = new Launcher();
//
//        // test is the input List of historical value
//        // result is the return List of prediction value
//        result = launcher.launch(test, 5);
//        for(Double i : test)
//        {
//            System.out.println(i);
//        }

