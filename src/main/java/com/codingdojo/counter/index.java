package com.codingdojo.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class index {
	@RequestMapping("/")
	public String home(HttpSession session) {
//		Integer count = (Integer) session.getAttribute("count");
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		Integer temp = (Integer) session.getAttribute("count")+1;
		session.setAttribute("count", temp);
		return "home.jsp";
	}
	@RequestMapping("/counter")
	public String counter(){
		return "counter.jsp";
	}
	@RequestMapping("/delete")
	public String delete(HttpSession session) {
		session.setAttribute("count", 0);
		return "counter.jsp";
	}

}
