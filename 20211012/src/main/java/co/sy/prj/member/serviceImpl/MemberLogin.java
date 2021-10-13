package co.sy.prj.member.serviceImpl;

import co.sy.prj.comm.Command;
import co.sy.prj.member.service.MemberService;
import co.sy.prj.member.service.MemberVO;

public class MemberLogin implements Command {

	@Override
	public void execute() {
		MemberService memberService = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setId("sy");
		vo.setPassword("1234");
		
		vo = memberService.loginCheck(vo);
		System.out.println(vo.getName() + " | " + vo.getAuthor());
	}

}
