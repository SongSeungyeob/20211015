package co.sy.bootstrap.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.sy.bootstrap.comm.Command;
import co.sy.bootstrap.member.service.MemberService;
import co.sy.bootstrap.member.service.MemberVO;
import co.sy.bootstrap.member.serviceImpl.MemberServiceImpl;

public class LoginCheck implements Command {
	private String message;
	
	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		MemberService memberDAO = new MemberServiceImpl();
		MemberVO member = new MemberVO();
		member.setId(request.getParameter("id"));
		member.setPassword(request.getParameter("password"));
		member = memberDAO.memberSelect(member);
		
		HttpSession session = request.getSession();
		String viewPage = null;
		if(member != null) {
			session.setAttribute("id", member.getId());
			session.setAttribute("author", member.getAuthor());
			session.setAttribute("name", member.getName());
			message = member.getId() + " 님 환영합니다.";
			viewPage = "main.do";
		} else {
			message = "아이디 또는 비밀번호를 확인하세요.";
			viewPage = "main/login";
		}
		System.out.println("message = " + message);
		
		return viewPage;
	}

}
