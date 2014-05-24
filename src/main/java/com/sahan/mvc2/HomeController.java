package com.sahan.mvc2;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
        return "home";
	}
	
	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public String form(Map<String,Object> model){
		
		model1 m=new model1();
		model.put("Student", m);
		
		return "form1";
	}

	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public void process(@ModelAttribute("Student") model1 model){ 
		
		logger.info("Starting......");
		System.out.println("the fisrt name of the student"+model.getFirstname());
		System.out.println("the last name of the student "+model.getLastname());
		
	}


}
