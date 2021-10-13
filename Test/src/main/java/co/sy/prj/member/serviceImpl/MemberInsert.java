package co.sy.prj.member.serviceImpl;

import java.util.Scanner;

import co.sy.prj.comm.Command;
import co.sy.prj.member.service.MemberService;
import co.sy.prj.member.service.MemberVO;

public class MemberInsert implements Command {

	private MemberService memberService = new MemberServiceImpl();
	private Scanner sc = new Scanner(System.in);
	@Override
	public void execute() {
		MemberVO member = new MemberVO();
		System.out.println("[ MEMBER INSERT ] 를 진행하겠습니다.");
		System.out.print("- 등록하고자 하는 MEMBER의 ID를 입력하세요 : ");
		member.setId(sc.nextLine());
		System.out.print("- 등록하고자 하는 MEMBER의 Name을 입력하세요 : ");
		member.setName(sc.nextLine());
		System.out.print("- 등록하고자 하는 MEMBER의 Password를 입력하세요 : ");
		member.setPassword(sc.nextLine());
		System.out.print("- 등록하고자 하는 MEMBER의 Tel을 입력하세요 : ");
		member.setTel(sc.nextLine());
		System.out.print("- 등록하고자 하는 MEMBER의 Address를 입력하세요 : ");
		member.setAddress(sc.nextLine());
		
		int n = memberService.memberInsert(member);
		if(n != 0) {
			System.out.println("- 성공적으로 MEMBER를 등록하였습니다.");
		} else {
			System.out.println("- MEMBER를 등록하지 못하였습니다.");
		}
	}

}
