package co.sy.prj.member.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import co.sy.prj.comm.Command;
import co.sy.prj.member.service.MemberService;
import co.sy.prj.member.service.MemberVO;

public class MemberList implements Command {

	//private MemberService memberService = new MemberServiceImpl();
	@Override
	public void execute() {
		MemberService memberService = new MemberServiceImpl();
		List<MemberVO> members = new ArrayList<MemberVO>();
		members = memberService.memberList();
		
		System.out.println("[ MEMBER 목록 조회 결과 ]= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
		int n = 1;
		for(MemberVO vo : members) {
			System.out.printf("[ %-2d ] %-10s | %-5s\t | %-5s | %-11s\t | %-11s\t | %-6s |\n", 
					n++, vo.getId(), vo.getName(), vo.getPassword(), vo.getTel(), vo.getAddress(), vo.getAuthor());
		}
		System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
	}

}
