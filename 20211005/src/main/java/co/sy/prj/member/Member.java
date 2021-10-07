package co.sy.prj.member;

public class Member {
	private String name;
	private String address;
	private int age;
	
	public Member(String name, String address, int age) {
		this.name = name;
		this.address = address;
		this.age = age;
	}
	
	public String toString() {
		System.out.print("이름 : " + name + " | " );
		System.out.print("주소 : " + address + " | ");
		System.out.println("나이 : " + age );
		return null;
	}
}
