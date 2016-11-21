package com.ru.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ru.commons.StringHelper;
import com.ru.entity.Stock;
import com.ru.service.YahooService;
import com.ru.yahoo.DataLoader;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

/**
 * A controller to load data from Yahoo to database
 * @author RGJ
 *
 */
@Controller
public class YahooController extends HttpServlet {

	public YahooController() {
		super();
	}

	public void init() throws ServletException {
		System.out.println("Start loading data from Yahoo...");
		Timer timer = new Timer();
		//thread starts 1 second after the controller revoked, and run every 60 seconds
		timer.schedule(new DataLoader(), 1000, 60000);
	}
}
