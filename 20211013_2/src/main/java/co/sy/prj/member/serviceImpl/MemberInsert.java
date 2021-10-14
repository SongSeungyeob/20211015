package co.sy.prj.member.serviceImpl;

import java.util.Scanner;

import co.sy.prj.comm.Command;
import co.sy.prj.member.service.MemberService;
import co.sy.prj.member.service.MemberVO;
import co.sy.prj.menu.Menu;

public class MemberInsert implements Command {

	private MemberService memberService = new MemberServiceImpl();
	@Override
	public void Execute() {
		if(!Menu.AUTHOR.equals("ADMIN")) {
			System.out.println("[ ERROR ] : ADMIN 권한이 아니면 MEMBER INSERT 를 진행하실 수 없습니다 ! ");
			return;
		}
		
		MemberVO member = new MemberVO();
		System.out.println("[ MEMBER INSERT ] 를 진행하겠습니다.");
		System.out.print("- 등록하고자 하는 MEMBER의 ID를 입력하세요 : ");
		member.setId(Menu.sc.nextLine());
		System.out.print("- 등록하고자 하는 MEMBER의 Name을 입력하세요 : ");
		member.setName(Menu.sc.nextLine());
		System.out.print("- 등록하고자 하는 MEMBER의 Password를 입력하세요 : ");
		member.setPassword(Menu.sc.nextLine());
		System.out.print("- 등록하고자 하는 MEMBER의 Tel을 입력하세요 : ");
		member.setTel(Menu.sc.nextLine());
		System.out.print("- 등록하고자 하는 MEMBER의 Address를 입력하세요 : ");
		member.setAddress(Menu.sc.nextLine());
		System.out.print("- 등록하고자 하는 MEMBER의 Author(USER / ADMIN / PROFESSOR)를 입력하세요 : ");
		member.setAuthor(Menu.sc.nextLine());
		
		int n = memberService.memberInsert(member);
		if(n != 0) {
			System.out.println("- 성공적으로 MEMBER를 등록하였습니다.");
		} else {
			System.out.println("- MEMBER를 등록하지 못하였습니다.");
		}
	}

}
