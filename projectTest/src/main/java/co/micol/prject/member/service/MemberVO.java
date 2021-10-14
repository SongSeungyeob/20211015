package co.micol.prject.member.service;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemberVO {
	private String id;
	private String name;
	private String password;
	private String tel;
	private String address;
	private String author;
	
	public void toListString() {  //전체 목록 보기
		System.out.print(id + " : ");
		System.out.print(name + " : ");
		System.out.print(password + " : ");
		System.out.print(tel + " : ");
		System.out.print(address + " : ");
		System.out.print(author + "\n ");
	}
	
	public String toString() {  //개별보기
		System.out.println("* ======================= *");
		System.out.println("* 아이디 \t: " + id );
		System.out.println("* 이름 \t: " + name);
		System.out.println("* 패스워드\t: " + password );
		System.out.println("* 전화번호\t: " + tel );
		System.out.println("* 주소 \t: " + address);
		System.out.println("* 권한 \t: " + author);
		System.out.println("* ======================= *");
		return null;
	}
}
