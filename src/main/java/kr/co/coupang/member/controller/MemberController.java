package kr.co.coupang.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// Annotation 해줘야 에러안남.
@Controller
public class MemberController {
//	Front관련은 servlet-context.xml로 이동
//	*.do 이동 url관련은 web.xml 
	//doGet
	@RequestMapping(value="/member/register.do", method=RequestMethod.GET)
	public String showRegisterForm(Model model) {
		
		return "member/register";
	}
	
	// doPost
	@RequestMapping(value="/member/register.do", method=RequestMethod.POST)
	public String registerMember(HttpServletRequest request, HttpServletResponse response, Model model) {
//		request.setAttribute("", "");
//		request.getRequestDispatcher("/WEB-INF/views/member/register.jsp");
//		response.sendRedirect("/index.jsp");
		
		return "";
	}
}
