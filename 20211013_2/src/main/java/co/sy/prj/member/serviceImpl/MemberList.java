package co.sy.prj.member.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import co.sy.prj.comm.Command;
import co.sy.prj.member.service.MemberService;
import co.sy.prj.member.service.MemberVO;
import co.sy.prj.menu.Menu;

public class MemberList implements Command {

	//private MemberService memberService = new MemberServiceImpl();
	@Override
	public void Execute() {
		
		if(Menu.AUTHOR.equals("USER")) {
			System.out.println("[ ERROR ] : USER의 권한으로는 MEMBER LIST를 조회하실 수 없습니다.");
			return;
		} 

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
