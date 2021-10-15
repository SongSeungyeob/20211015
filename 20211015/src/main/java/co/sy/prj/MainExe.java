package co.sy.prj;

import java.util.Scanner;

import co.sy.prj.user.User;

public class MainExe {
	public static Scanner sc = new Scanner(System.in);
	static User user = new User();
	
	private void mainTitle() {
		while(true) {
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 종료");
			
			String n = sc.nextLine();
			if(n.equals("1")) {
				makeUser();
			} else if(n.equals("2")) {
				login();
			} else if(n.equals("3")) {
				break;
			} else if(n.equals("st-lab")) {
				System.out.println("관리자 접근");
				user.get_DB();
			} else {
				System.out.println("[ ERROR INPUT ] ");
			}
		}
	}
	
	static void makeUser() {
		System.out.print("- ID를 입력하세요 : ");
		String ID = sc.nextLine();
		System.out.print("- PW를 입력하세요 : ");
		String PW = sc.nextLine();
		user.setUser(ID, PW.getBytes());
	}
	
	static void login() {
		System.out.print("- ID를 입력하세요 : ");
		String ID = sc.nextLine();
		System.out.print("- PW를 입력하세요 : ");
		String PW = sc.nextLine();
		user.getUser(ID,  PW.getBytes());
	}
	
	public void run() {
		mainTitle();
	}
}
