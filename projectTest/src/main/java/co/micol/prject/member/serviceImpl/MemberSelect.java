package co.micol.prject.member.serviceImpl;

import java.util.Scanner;

import co.micol.prject.comm.Command;
import co.micol.prject.member.service.MemberSerVice;
import co.micol.prject.member.service.MemberVO;

public class MemberSelect implements Command {

	private Scanner Sc = new Scanner(System.in);
	@Override
	public void execute() {
		MemberSerVice memberService = new MemberServiceImpl();
		MemberVO vo;
		String ID;
		while(true) {
			vo = new MemberVO();
			System.out.print("- 조회하실 MEMBER의 ID를 입력하세요(중단을 원하시면 'Enter'를 입력하세요) : ");
			ID = Sc.nextLine();
			if(ID.equals("")) {
				System.out.println("[ EXIT ] : MEMBER 검색을 종료하겠습니다.");
				return;
			} 
			vo.setId(ID);
			vo = memberService.memberSelect(vo);
			if(vo == null) {
				System.out.println("[ ERROR ] : 존재하지 않는 MEMBER입니다. 다시 입력해주세요.");
			} else {
				break;
			}
		}
		
		System.out.println("[ ID가 '" + ID + "' 인 MEMBER 정보입니다. ]");
		vo.toString();		
	}

}
