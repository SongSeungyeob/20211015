package co.sy.prj.member.serviceImpl;

import java.util.Scanner;

import co.sy.prj.comm.Command;
import co.sy.prj.member.service.MemberService;
import co.sy.prj.member.service.MemberVO;
import co.sy.prj.menu.Menu;

public class MemberLogin implements Command {
	@Override
	public void execute() {
		MemberService memberService = new MemberServiceImpl();
		
		String ID, PW;
		MemberVO vo;
		
		while(true) {
			vo = new MemberVO();
			System.out.println("[ LOGIN ] : 로그인하지 않고, 종료를 원하시면 ID에 'Enter'를 입력하세요. 단, 아무런 작업도 수행하실 수 없습니다.");
			System.out.print("- ID : "); 
			ID = Menu.sc.nextLine();
			if(ID.equals("")) {
				System.out.println("[ 종료하겠습니다. ]");
				return;
			}
			
			vo.setId(ID);
			System.out.print("- PW : ");
			PW = Menu.sc.nextLine();
			vo.setPassword(PW);
			vo = memberService.loginCheck(vo);
			
			if(vo == null) {
				System.out.println("[ LOGIN ERROR ] : 잘못된 입력입니다. 다시 입력해주세요 !");
			} else {
				System.out.print("[ LOGIN SUCCESS ] : ");
				System.out.println("'" + vo.getAuthor() +"' 권한을 가지신 '" + vo.getName() + "' 님 환영합니다.");
				Menu.NAME = vo.getName();
				Menu.AUTHOR = vo.getAuthor();
				break;
			}
		}	
	}
}
