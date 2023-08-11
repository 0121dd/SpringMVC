package kr.co.coupang.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.co.coupang.member.domain.Member;
import kr.co.coupang.member.service.MemberService;

// @Controller를 Annotation 해줘야 에러안남.
@Controller
@SessionAttributes({"memberId","memberName"})
public class MemberController {
	
//	의존성 주입하기 위해서 Annotation 쓰고, 캡슐화를 위해서 private 쓰기
	@Autowired
	private MemberService service;
	
//	Front관련은 servlet-context.xml로 이동
//	*.do 이동 url관련은 web.xml 
	//doGet - 페이지 이동용
	@RequestMapping(value="/member/register.do", method=RequestMethod.GET)
	public String showRegisterForm(Model model) {
		
		return "member/register";
	}
	
	// doPost - 데이터 저장용
	@RequestMapping(value="/member/register.do", method=RequestMethod.POST)
	public String registerMember(HttpServletRequest request, HttpServletResponse response
//						, @RequestParam String memberId (파라미터 이름이 변수 이름과 같으면 name속성 생략가능)
//						, String memberId (String, int, Integer 등의 단순 타입이면 @RequestParam 생략가능)
								, @RequestParam("memberId") String memberId
								, @RequestParam("memberPw") String memberPw
								, @RequestParam("memberName") String memberName
								, @RequestParam("memberAge") int memberAge
								, @RequestParam("memberGender") String memberGender
								, @RequestParam("memberEmail") String memberEmail
								, @RequestParam("memberPhone") String memberPhone
								, @RequestParam("memberAddress") String memberAddress
								, @RequestParam("memberHobby") String memberHobby
								, Model model) {
		Member member = new Member(memberId, memberPw, memberName, memberAge, memberGender, memberEmail, memberPhone, memberAddress, memberHobby);
		try {
			int result = service.registerMember(member);
			if(result > 0) {
				// 성공!
				return "redirect:/index.jsp";
			}else {
				// 실패!
				model.addAttribute("msg", " 회원가입이 완료되지 않았습니다.");
//				request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
				return "common/errorPage";
			}
		}catch (Exception e) {
			e.printStackTrace();	// 콘솔장에 빨간색으로 뜨게 함.
			model.addAttribute("msg", e.getMessage());	// 콘솔창에 뜨는 메시지를 웹 페이지로 뜨게 함.
			return "common/errorPage";
		}
		
	}
	
	@RequestMapping(value="/member/login.do", method=RequestMethod.POST)
	public String memberLogin(HttpServletRequest request
							, @RequestParam("memberId") String memberId
							, @RequestParam("memberPw") String memberPw
							, Model model) {
		try {			
			Member member = new Member();
			member.setMemberId(memberId);
			member.setMemberPw(memberPw);
			Member mOne = service.memberLoginCheck(member);
			if(mOne != null) {
				// 성공하면 로그인 페이지 이동
//				HttpSession session = request.getSession();
//				session.setAttribute("memberId", mOne.getMemberId());
//				session.setAttribute("memberName", mOne.getMemberName());
				// redirect는 model 사용 불가(session을 Annotation 하면 model 사용 가능)
				model.addAttribute("memberId", mOne.getMemberId());
				model.addAttribute("memberName", mOne.getMemberName());
				return "redirect:/index.jsp";
			}else {
				// 실패하면 실패메시지 출력
				model.addAttribute("msg", "아이디와 비밀번호를 다시 확인해주세요.");
				return "common/errorPage";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
		
	}
	
	@RequestMapping(value="/member/logout.do", method=RequestMethod.GET)
	public String memberLogout(HttpSession sessionPrev, SessionStatus session, Model model) {
		// SessionStatus는 스프링의 어노테이션(@SessionAttributes)로 지원되는 세션을 만료시킨다.
		if(session != null) {
//			@SessionAttributes를 사용했으면 session.invalidate()으로 세션 만료 불가
//			setComplete()으로 세션 만료
			session.setComplete();
			if(session.isComplete()) {
				// 세션 만료 유효성 체크
			}
			return "redirect:/index.jsp";
		}else {
			model.addAttribute("msg","로그아웃을 완료하지 못했습니다.");
			return "common/errorPage";
		}
	}
	
	
	@RequestMapping(value="/member/mypage.do", method=RequestMethod.GET)
	public String showDetailMember(HttpServletRequest request, HttpServletResponse response
								, @RequestParam("memberId") String memberId
								, HttpSession session
								, Model model) {
		try {			
//			String memberId = (String) session.getAttribute("memberId");
			Member mOne = service.showOneById(memberId);
			if(mOne != null) {
				// 로그아웃 성공
				model.addAttribute("mOne", mOne);
				return "member/mypage";
			}else {
				// 실패
				model.addAttribute("msg","로그아웃이 완료되지 못했습니다.");
				return "common/errorPage";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
	}
	
	@RequestMapping(value="/member/delete.do", method=RequestMethod.GET)
	public String removeMember(@RequestParam("memberId") String memberId, Model model) {
		try {
			int result = service.removeMember(memberId);
			if(result > 0) {
				// 성공하면 메인페이지로 이동, 세션 파괴되어야 함.
				return "redirect:/member/logout.do";
			}else {
				// 실패
				model.addAttribute("msg","회원탈퇴가 완료되지 않았습니다.");
				return "common/errorPage";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
	}
	
	@RequestMapping(value="/member/update.do", method=RequestMethod.GET)
	public String modifyViewMember(@RequestParam("memberId") String memberId, Model model) {
		Member mOne = service.showOneById(memberId);
		if(mOne != null) {
			model.addAttribute("mOne", mOne);
			return "member/modify";
		}else {
			model.addAttribute("msg", "데이터가 존재하지 않습니다.");
			return "common/errorPage";
		}
	}
	
	@RequestMapping(value="/member/update.do", method=RequestMethod.POST)
	public String modifyMember(@RequestParam("memberId") String memberId
							, @RequestParam("memberPw") String memberPw
							, @RequestParam("memberEmail") String memberEmail
							, @RequestParam("memberPhone") String memberPhone
							, @RequestParam("memberAddress") String memberAddress
							, @RequestParam("memberHobby") String memberHobby
							, Model model) {
		Member member = new Member(memberId, memberPw, memberEmail, memberPhone, memberAddress, memberHobby);
		try {			
			int result = service.modifyMember(member);
			if(result > 0) {
				return "redirect:/member/mypage.do";
			}else {
				model.addAttribute("msg", "데이터가 존재하지 않습니다.");
				return "common/errorPage";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "common/errorPage";
		}
	}
}
