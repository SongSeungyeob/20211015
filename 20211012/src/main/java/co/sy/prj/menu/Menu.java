package co.sy.prj.menu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import co.sy.prj.board.serviceImpl.BoardDelete;
import co.sy.prj.board.serviceImpl.BoardInsert;
import co.sy.prj.board.serviceImpl.BoardList;
import co.sy.prj.board.serviceImpl.BoardSelect;
import co.sy.prj.board.serviceImpl.BoardUpdate;
import co.sy.prj.comm.Command;
import co.sy.prj.member.serviceImpl.MemberDelete;
import co.sy.prj.member.serviceImpl.MemberInsert;
import co.sy.prj.member.serviceImpl.MemberList;
import co.sy.prj.member.serviceImpl.MemberLogin;
import co.sy.prj.member.serviceImpl.MemberSelect;
import co.sy.prj.member.serviceImpl.MemberUpdate;

public class Menu {
	private Scanner sc = new Scanner(System.in);
	private Map<String, Command> map = new HashMap<String, Command>();
	
	public Menu() {
		// 생성자를 호출함과 동시에, 명령 실행 그룹 Map 구조 만들기.
		map.put("boardList", new BoardList());
		map.put("boardSelect", new BoardSelect());
		map.put("boardInsert", new BoardInsert());
		map.put("boardUpdate", new BoardUpdate());
		map.put("boardDelete", new BoardDelete());
		map.put("memberList", new MemberList());
		map.put("memberSelect", new MemberSelect());
		map.put("memberInsert", new MemberInsert());
		map.put("memberUpdate", new MemberUpdate());
		map.put("memberDelete", new MemberDelete());
		map.put("memberLogin", new MemberLogin());
	}
	
	private void mainTitle() {
		System.out.println("*.=.=.=.=.=.=.=.*");
		System.out.println("| 1. MEMBER 관리 |");
		System.out.println("| 2. BOARD 관리  |");
		System.out.println("| 3. LOGIN      |");
		System.out.println("| 4. 종료        |");
		System.out.println("*.=.=.=.=.=.=.=.*");
		System.out.print("- 원하는 관리 SYSTEM을 선택하세요 : ");
	}
	
	private void memberTitle() {
		System.out.println("*.=.=.=.=.=.=.=.=.=.*");
		System.out.println("| 1. MEMBER 목록 조회 |");
		System.out.println("| 2. MEMBER 정보 조회 |");
		System.out.println("| 3. MEMBER 정보 등록 |");
		System.out.println("| 4. MEMBER 정보 수정 |");
		System.out.println("| 5. MEMBER 정보 삭제 |");
		System.out.println("| 6. MAIN으로        |");
		System.out.println("*.=.=.=.=.=.=.=.=.=.*");
		System.out.print("- 원하는 작업을 선택하세요 : ");
	}
	
	private void boardTitle() {
		System.out.println("*.=.=.=.=.=.=.=.*");
		System.out.println("| 1. BOARD 목록 |");
		System.out.println("| 2. BOARD 조회 |");
		System.out.println("| 3. BOARD 등록 |");
		System.out.println("| 4. BOARD 수정 |");
		System.out.println("| 5. BOARD 삭제 |");
		System.out.println("| 6. MAIN 으로  |");
		System.out.println("*.=.=.=.=.=.=.=.*");
		System.out.print("- 원하는 작업을 선택하세요 : ");
	}
	
	private void menu() {
		while(true) {
			mainTitle();
			int jobNo = sc.nextInt(); sc.nextLine();
			if(jobNo == 1) {
				memberManagement();
			} else if(jobNo == 2) {
				boardManagement();
			} else if(jobNo == 3) {
				executeRun("memberLogin");
			} else {
				System.out.println("[ 종료하겠습니다. GOOD BYE ! ]");
				sc.close();
				return;
			}
		}
	}

	private void boardManagement() {
		boolean b = false;
		do {
			boardTitle();
			int key = sc.nextInt();
			switch(key) {
				case 1:
					executeRun("boardList");
					break;
				case 2:
					executeRun("boardSelect");
					break;
				case 3:
					executeRun("boardInsert");
					break;
				case 4:
					executeRun("boardUpdate");
					break;
				case 5:
					executeRun("boardDelete");
					break;
				case 6:
					b = true;
					break;
			}
		} while(!b);
	}

	private void memberManagement() {
		boolean b = false;
		do {
			memberTitle();
			int key = sc.nextInt();
			switch(key) {
				case 1:
					executeRun("memberList");
					break;
				case 2:
					executeRun("memberSelect");
					break;
				case 3:
					executeRun("memberInsert");
					break;
				case 4:
					executeRun("memberUpdate");
					break;
				case 5:
					executeRun("memberDelete");
					break;
				case 6:
					b = true;
					break;
			}
		} while(!b);
	}

	private void executeRun(String string) {
		// 실행할 명령을 구현.
		Command command = map.get(string);
		command.execute();
	}
	
	public void run() {
		menu();
		sc.close();
	}
}
