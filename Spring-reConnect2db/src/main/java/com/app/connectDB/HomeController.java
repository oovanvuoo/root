package com.app.connectDB;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.connectDB.Service.UserService;
import com.app.connectDB.model.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private UserService US;
	
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
	
	@RequestMapping(value = "/vbxx", method = RequestMethod.GET)
	public String vbxx(Model model){
		List<User> listUser = US.getAll();
		if(listUser == null){
			System.out.println("<Empty>");
		}else{
			for(User tmp : listUser){
				//THêm vài chú thích nữa
				 System.out.println(tmp.getID() + "\t" + tmp.getUsername() + "\t" + tmp.getPassword() + "\t" + tmp.getName() + "\t" + tmp.getStatus() );
			}
		}
		//Chổ này là hết chương hàm và trả về chuổi "hôme"
		return "home";
	}	
}
