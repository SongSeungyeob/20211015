package co.micol.project;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import co.micol.prject.board.serviceImpl.BoardList;
import co.micol.prject.comm.Command;
import co.micol.prject.member.serviceImpl.MemberSelect;

public class MainMenu {
	
	public static Scanner sc = new Scanner(System.in);
	Map<String, Command> map = new HashMap<String,Command>();
	
	private void Menu() {
		map.put("memberSelect", new MemberSelect());
		map.put("boardList", new BoardList());
	}
	
	private void Title() {
		while(true) {
			mainTitle();
			int select = sc.nextInt(); sc.nextLine();
			if(select == 1) {
				executeRun("memberSelect");
			} else if(select == 2) {
				executeRun("boardList");
			} else if(select == 3) {
				System.out.println("[ EXIT ] : System을 종료하겠습니다.");
				break;
			} else {
				System.out.println("[ ERROR ] : 잘못된 입력입니다 ! 다시 입력해 주세요 ! ");
			}
		}
	}
	
	private void mainTitle() {
			System.out.println("*=*=*=*=*=*=*=*=*=*=*=* ");
			System.out.println("| 1. MEMBER INFO 보기  | ");
			System.out.println("| 2. BOARD LIST  보기  | ");
			System.out.println("| 3. EXIT             | ");
			System.out.println("*=*=*=*=*=*=*=*=*=*=*=* ");
			System.out.print("- 원하는 작업 번호를 입력해 주세요 : ");
	}
	
	private void executeRun(String str) {
		Command cmd = map.get(str);
		cmd.execute();
	}
	
	public void run() { 
		Menu();
		Title();
	}
}
