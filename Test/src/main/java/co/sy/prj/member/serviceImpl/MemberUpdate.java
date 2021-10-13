package co.sy.prj.member.serviceImpl;

import java.util.Scanner;

import co.sy.prj.comm.Command;
import co.sy.prj.member.service.MemberService;
import co.sy.prj.member.service.MemberVO;

public class MemberUpdate implements Command {
	private MemberService memberService = new MemberServiceImpl();
	private Scanner sc = new Scanner(System.in);
	
	@Override
	public void execute() {
		MemberVO member = new MemberVO();
		System.out.println("[ MEMBER UPDATE ] 를 진행하겠습니다. ");
		System.out.print("- 수정 하고자 하는 MEMBER의 ID를 입력하세요 : ");
		member.setId(sc.nextLine());
		MemberVO Target = memberService.memberSelect(member);
		
		if(Target == null) {
			System.out.println("- 존재하지 않는 MEMBER ID이므로, 수정할 수 없습니다.");
		} else {
			System.out.print("- 수정 하고자 하는 MEMBER의 Name을 입력하세요(수정을 원치 않으면 Enter를 입력하세요) : ");
			String name = sc.nextLine();
			if(name.equals("")) {
				member.setName(Target.getName());
			} else {
				member.setName(name);
			}
			System.out.print("- 수정 하고자 하는 MEMBER의 Password를 입력하세요(수정을 원치 않으면 Enter를 입력하세요) : ");	
			String password = sc.nextLine();
			if(password.equals("")) {
				member.setName(Target.getPassword());
			} else {
				member.setPassword(password);
			}
			System.out.print("- 수정 하고자 하는 MEMBER의 Tel을 입력하세요(수정을 원치 않으면 Enter를 입력하세요) : ");	
			String Tel = sc.nextLine();
			if(Tel.equals("")) {
				member.setName(Target.getTel());
			} else {
				member.setTel(Tel);
			}
			System.out.print("- 수정 하고자 하는 MEMBER의 Address을 입력하세요(수정을 원치 않으면 Enter를 입력하세요) : ");	
			String Addr = sc.nextLine();
			if(Addr .equals("")) {
				member.setAddress(Target.getAddress());
			} else {
				member.setAddress(Addr);
			}
			System.out.print("- 수정 하고자 하는 MEMBER의 Author(admin / user)을 입력하세요(수정을 원치 않으면 Enter를 입력하세요) : ");	
			String Author = sc.nextLine();
			if(Author.equals("")) {
				member.setName(Target.getAuthor());
			} else {
				member.setAuthor(Author);
			}
		}
		
		int n = memberService.memberUpdate(member);
		if(n != 0) {
			System.out.println("- 성공적으로 MEMBER를 UPDATE 하였습니다.");
		} else {
			System.out.println("- MEMBER를 UPDATE 하지 못하였습니다.");
		}

	}

}
