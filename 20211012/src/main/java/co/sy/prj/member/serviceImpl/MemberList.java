package co.sy.prj.member.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.sy.prj.board.service.BoardVO;
import co.sy.prj.comm.Command;
import co.sy.prj.member.service.MemberService;
import co.sy.prj.member.service.MemberVO;

public class MemberList implements Command {

	//private MemberService memberService = new MemberServiceImpl();
	@Override
	public void execute() {
		MemberService memberService = new MemberServiceImpl();
		List<MemberVO> members = new ArrayList<MemberVO>();
		members = memberService.memberSelectList();
		
		System.out.println("[ MEMBER 목록 조회 결과 ]= = = = = = = = = = = = = = = = = =");
		for(MemberVO vo : members) {
			System.out.print("| " + vo.getId() + " | ");
			System.out.print("| " + vo.getName() + " | ");
			System.out.print("| " + vo.getPassword()+ " | ");
			System.out.print("| " + vo.getTel() + " | ");
			System.out.print("| " + vo.getAddress() + " | ");
			System.out.println("| " + vo.getAuthor() + " | ");
		}
		System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = =");
	}

}
