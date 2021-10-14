package co.sy.prj.member.serviceImpl;

import co.sy.prj.board.service.BoardService;
import co.sy.prj.board.serviceImpl.BoardServiceImpl;
import co.sy.prj.comm.Command;
import co.sy.prj.member.service.MemberService;
import co.sy.prj.member.service.MemberVO;
import co.sy.prj.menu.Menu;

public class MemberUpdate implements Command {
	private MemberService memberService = new MemberServiceImpl();
	
	@Override
	public void Execute() {
		MemberVO member = new MemberVO();
		MemberVO forboardupdate = new MemberVO();
		System.out.println("[ MEMBER UPDATE ] 를 진행하겠습니다. ");
		System.out.print("- 수정 하고자 하는 MEMBER의 ID를 입력하세요 : ");
		String ID = Menu.sc.nextLine();
		
		String Name = memberService.memberName(ID);
		if(Name == null) {
			System.out.println("[ ERROR ] : 존재하지 않는 MEMBER ID 입니다 ! ");
			return;
		} else if(Menu.AUTHOR.equals("USER") && !Name.equals(Menu.NAME)) {
			System.out.println("[ ERROR ] : MEMBER UPDATE는 본인의 정보에 대해서만 UPDATE 가능합니다 ! ");
			return;
		} 
		
		member.setId(ID);
		MemberVO Target = memberService.memberSelect(member);
		forboardupdate.setId(Target.getName());
		boolean Flag = false;
		
		System.out.print("- 수정 하고자 하는 MEMBER의 Name을 입력하세요(수정을 원치 않으면 Enter를 입력하세요) : ");
		String name = Menu.sc.nextLine();
		if(name.equals("")) {
			member.setName(Target.getName());
		} else {
			Flag = true;
			forboardupdate.setName(name);
			member.setName(name);
			if(Name.equals(Menu.NAME)) {
				Menu.NAME = name;
			}
		}
		
		System.out.print("- 수정 하고자 하는 MEMBER의 Password를 입력하세요(수정을 원치 않으면 Enter를 입력하세요) : ");	
		String password = Menu.sc.nextLine();
		if(password.equals("")) {
			//member.setPassword(Target.getPassword() == null ? null : Target.getPassword());
			member.setPassword(Target.getPassword());
		} else {
			member.setPassword(password);
		}
		
		System.out.print("- 수정 하고자 하는 MEMBER의 Tel을 입력하세요(수정을 원치 않으면 Enter를 입력하세요) : ");	
		String Tel = Menu.sc.nextLine();
		if(Tel.equals("")) {
			//member.setTel(Target.getTel() == null ? null : Target.getTel());
			member.setTel(Target.getTel());
		} else {
			member.setTel(Tel);
		}

		System.out.print("- 수정 하고자 하는 MEMBER의 Address을 입력하세요(수정을 원치 않으면 Enter를 입력하세요) : ");	
		String Addr = Menu.sc.nextLine();
		if(Addr.equals("")) {
			//member.setAddress(Target.getAddress() == null ? null : Target.getAddress());
			member.setAddress(Target.getAddress());
		} else {
			member.setAddress(Addr);
		}

		System.out.print("- 수정 하고자 하는 MEMBER의 Author(ADMIN / USER)을 입력하세요(수정을 원치 않으면 Enter를 입력하세요) : ");	
		String Author = Menu.sc.nextLine();
		if(Author.equals("")) {
			//member.setAuthor(Target.getAuthor() == null ? null : Target.getAuthor());
			member.setAuthor(Target.getAuthor());
		} else {
			member.setAuthor(Author);
			Menu.AUTHOR = Author;
		}	
		
		int n = memberService.memberUpdate(member);
		if(n != 0) {
			System.out.println("- 성공적으로 MEMBER를 UPDATE 하였습니다.");
		} else {
			System.out.println("- MEMBER를 UPDATE 하지 못하였습니다.");
		}
		
		if(Flag == true) {
			BoardService boardService = new BoardServiceImpl();
			//System.out.println(forboardupdate.getId() + " , " + forboardupdate.getName());
			int m = boardService.boardUpdateName(forboardupdate);
			
			if(m != 0) {
				System.out.println("- 성공적으로 BOARD WRITER 를 UPDATE 하였습니다.");
			} else {
				System.out.println("- BOARD WRITER를 UPDATE 하지 못하였습니다.");
			}
		}
	}
}
