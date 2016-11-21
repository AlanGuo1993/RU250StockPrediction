package com.ru.yahoo;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ru.commons.StringHelper;
import com.ru.entity.Stock;
import com.ru.service.UserService;
import com.ru.service.YahooService;
import com.ru.service.YahooServiceImpl;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

/**
 * TimerTask to load data to database
 * @author RGJ
 *
 */
public class DataLoader extends java.util.TimerTask{

	static String AccessToken = "3440930777-FUeEnX9x9TZnvw4v19Cm50IccPlw13fgEgaoSxJ";
	static String AccessSecret = "G2dnQVCr668pzRjQuUiYnWqm2NvJTFcYMHWCt2SXqOmrW";
	static String ConsumerKey = "X6UlPyIaJxUYPLVZ8nIuSbfOT";
	static String ConsumerSecret = "EqrNKTJO5qgVnOKbBhW2q3FbSAnW9B1rTqYm6Lck2YXtdECi1T";
	
	public void run(){
		List<String> stocks = new ArrayList();
		stocks.add("GOOG");
		stocks.add("AAPL");
		stocks.add("FB");
		stocks.add("MSFT");
		stocks.add("ORCL");
		stocks.add("LNKD");
		stocks.add("CSCO");
		stocks.add("AMZN");
		stocks.add("INTC");
		stocks.add("YHOO");
		for(String stock : stocks){
			loadData(stock);
		}
	}
	
	private void loadData(String stock) {
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("WEB-INF/applicationContext.xml");
//		YahooService yahooService = (YahooService) ctx.getBean("yahooService");
		String content = null;
		try {
			content = this.getStock(stock);
		} catch (OAuthMessageSignerException | OAuthExpectationFailedException | OAuthCommunicationException
				| IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] contents = content.split(",");
		Stock s = new Stock();
		s.setStock((contents[0] + "").replace("\"", ""));
		s.setValue(contents[1] + "");
		long d = 0;
		try {
			d = new java.text.SimpleDateFormat("MM/dd/yyyy").parse((contents[2] + "").replace("\"", "")).getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		s.setDate(String.valueOf(d).substring(0, 10));
		String t = StringHelper.converTimeFormat((contents[3] + "").replace("\"", ""));
		s.setTime(t);
		s.setOpen(contents[5] + "");
		s.setHigh(contents[6] + "");
		s.setLow(contents[7] + "");
		s.setVolume(contents[8] + "");
		YahooService yahooService = new YahooServiceImpl();
		yahooService.insertStock(s);
	}

	private String getStock(String stock) throws OAuthMessageSignerException, OAuthExpectationFailedException,
			OAuthCommunicationException, ClientProtocolException, IOException, ParseException {
		OAuthConsumer consumer = new CommonsHttpOAuthConsumer(ConsumerKey, ConsumerSecret);

		consumer.setTokenWithSecret(AccessToken, AccessSecret);

		String reqStr = "http://finance.yahoo.com/d/quotes.csv?s=" + stock + "&f=sl1d1t1c1ohgv&e=.csv";
		// String reqStr =
		// "http://ichart.finance.yahoo.com/table.csv?s=GOOGL&c="+1+";";//historical
		HttpGet request1 = new HttpGet(reqStr);
		consumer.sign(request1);

		HttpClient client = new DefaultHttpClient();
		HttpResponse response = client.execute(request1);
		String content = IOUtils.toString(response.getEntity().getContent());
		return content;
	}
}
