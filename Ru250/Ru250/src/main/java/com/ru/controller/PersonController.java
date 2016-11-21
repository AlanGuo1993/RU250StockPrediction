package com.ru.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ru.commons.StringHelper;
import com.ru.entity.Person;
import com.ru.entity.Stock;
import com.ru.service.PersonService;
import com.ru.service.YahooService;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

@Controller
public class PersonController 
{

	private PersonService personService;
	
	private YahooService yahooService;

	@Autowired(required=true)
	@Qualifier(value="yahooService")
	public void setYahooService(YahooService yahooService) {
		this.yahooService = yahooService;
	}

	@Autowired(required=true)
	@Qualifier(value="personService")
	public void setPersonService(PersonService personService) 
	{
		this.personService = personService;
	}
	
	@RequestMapping("/person")
	public String indexMapping()
	{
		return "index";
	}
	
	@RequestMapping(value = "/persons", method = RequestMethod.GET)
    public String listPersons(Model model) {
        model.addAttribute("person", new Person());
        model.addAttribute("listPersons", this.personService.listPersons());
        return "person";
    }
	
	/*
	 * Add a new Page for test
	 */
	@RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newPage(Model model) {
        model.addAttribute("msg", "Hello World!!");
        return "NewFile";
    }
     
	

    //For add and update person both
    @RequestMapping(value= "/person/add", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("person") Person p){
         
        if(p.getId() == 0){
            //new person, add it
            this.personService.addPerson(p);
        }else{
            //existing person, call update
            this.personService.updatePerson(p);
        }
         
        return "redirect:/persons";
         
    }
     
    @RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") int id){
         
		this.personService.removePerson(id);
        return "redirect:/persons";
    }
  
    @RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("person", this.personService.getPersonById(id));
        model.addAttribute("listPersons", this.personService.listPersons());
        return "person";
    }
    
//    @RequestMapping(value = "/searchperson", method = RequestMethod.GET)
//    @ResponseBody
//    public List searchPerson(HttpServletRequest request){
//    	String name = request.getParameter("name");
//    	List<Person> list = personService.searPersonName(name);
//        return list;        
//    }
    
    @RequestMapping(value = "/searchperson", method = RequestMethod.GET)
    @ResponseBody
    public Person searchPerson(HttpServletRequest request){
    	String name = request.getParameter("name");
    	List<Person> list = personService.searPersonName(name);
        return list.get(0);
    }
    
    
	static String AccessToken = "3440930777-FUeEnX9x9TZnvw4v19Cm50IccPlw13fgEgaoSxJ";
	static String AccessSecret = "G2dnQVCr668pzRjQuUiYnWqm2NvJTFcYMHWCt2SXqOmrW";
	static String ConsumerKey = "X6UlPyIaJxUYPLVZ8nIuSbfOT";
	static String ConsumerSecret = "EqrNKTJO5qgVnOKbBhW2q3FbSAnW9B1rTqYm6Lck2YXtdECi1T";
	
    @RequestMapping(value = "/yahoo", method = RequestMethod.GET)
    @ResponseBody
    public String testYshoo(HttpServletRequest request) throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException, ClientProtocolException, IOException, ParseException{
		String content =  getStock("GOOGL");
		String[] contents = content.split(",");
		Stock s = new Stock();
		s.setStock((contents[0]+"").replace("\"", ""));
		s.setValue(contents[1]+"");
		long d = new java.text.SimpleDateFormat("MM/dd/yyyy").parse((contents[2]+"").replace("\"", "")).getTime();
		s.setDate(String.valueOf(d).substring(0,10));
		String t = StringHelper.converTimeFormat((contents[3]+"").replace("\"", ""));
		s.setTime(t);
		s.setOpen(contents[5]+"");
		s.setHigh(contents[6]+"");
		s.setLow(contents[7]+"");
		s.setVolume(contents[8]+"");
		yahooService.insertStock(s);
        return "1";
    }
    
    private String getStock(String stock)throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException, ClientProtocolException, IOException, ParseException{
    	OAuthConsumer consumer = new CommonsHttpOAuthConsumer(ConsumerKey, ConsumerSecret);

		consumer.setTokenWithSecret(AccessToken, AccessSecret);

		String reqStr = "http://finance.yahoo.com/d/quotes.csv?s="+stock+"&f=sl1d1t1c1ohgv&e=.csv";
//		String reqStr = "http://ichart.finance.yahoo.com/table.csv?s=GOOGL&c="+1+";";//historical
		HttpGet request1 = new HttpGet(reqStr);
		consumer.sign(request1);

		HttpClient client = new DefaultHttpClient();
		HttpResponse response = client.execute(request1);
		String content =  IOUtils.toString(response.getEntity().getContent());
		return content;
    }
	
}
