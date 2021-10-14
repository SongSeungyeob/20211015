package co.sy.prj.member.serviceImpl;

import java.util.Scanner;

import co.sy.prj.comm.Command;
import co.sy.prj.member.service.MemberService;
import co.sy.prj.member.service.MemberVO;

public class MemberDelete implements Command {

	private MemberService memberService = new MemberServiceImpl();
	private Scanner sc = new Scanner(System.in);
	
	@Override
	public void Execute() {
		System.out.println("[ 현재 MEMBER DELETE는 진행할 수 없습니다. ]");
		return;
		
//		MemberVO member = new MemberVO();
//		System.out.println("[ MEMBER DELETE ] 를 진행하겠습니다. ");
//		System.out.print("- 삭제하고자 하는 MEMBER의 ID를 입력하세요 : ");
//		member.setId(sc.nextLine()); 
//		int n = memberService.memberDelete(member);
//		if(n != 0) {
//			System.out.println("- 성공적으로 MEMBER를 삭제하였습니다. ");
//		} else {
//			System.out.println("- MEMBER를 삭제하지 못하였습니다.");
//		}
	}

}
