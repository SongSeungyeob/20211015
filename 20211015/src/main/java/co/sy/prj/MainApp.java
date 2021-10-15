package co.sy.prj;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import co.sy.prj.bothencrypt.AES256Util;
import co.sy.prj.member.service.MemberService;
import co.sy.prj.member.service.MemberVO;
import co.sy.prj.member.serviceImpl.MemberServiceImpl;
import co.sy.prj.util.EncryptionSha;

public class MainApp {

	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException, GeneralSecurityException {
		Scanner sc = new Scanner(System.in);
		EncryptionSha enc = new EncryptionSha();
		MemberService memberDao = new MemberServiceImpl();
		MemberVO member = new MemberVO();
		String encKey = memberDao.encKey();
		AES256Util aes = new AES256Util();
		
		System.out.print("- ID를 입력하세요 : ");
		String ID = sc.nextLine();
		System.out.print("- PW를 입력하세요 : ");
		String password = sc.nextLine();
		System.out.print("- AUTHOR(ADMIN / USER)를 입력하세요 : ");
		String author = sc.nextLine();
		
		System.out.println("[ 암호화 전 ]=================================");
		System.out.println("ID : " + ID);
		System.out.println("PW : " + password);
		System.out.println("Author : " + author);
		System.out.println("===========================================");
		System.out.println("[ 암호화 후 ]=================================");
		password = aes.encrypt(password);
		System.out.println("PW : " + password);
		author = aes.encrypt(author);
		System.out.println("Author : " + author);
		System.out.println("===========================================");
		System.out.println("[ 암호화된 정보로 LOGIN 중입니다... ]");		
		member.setId(ID);
		member.setPassword(password);
		member.setAuthor(author);
		member = memberDao.memberLogin(member);
		
		if(member.getName() != null) {
			author = aes.decrypt(author);
			System.out.println("[ SUCCESS LOGIN ] : '" + author + "' 권한을 가지신 " + member.getName() + "님 환영합니다.");
		} else {
			System.out.println("[ ERROR ] : ID 또는 PW가 틀립니다.");
		}
		
		//member.setPassword(enc.sha512(password, encKey));

//		member = memberDao.memberLogin(member);
//		if (member.getName() != null) {
//			System.out.println("[ SUCCESS LOGIN ] : " + member.getName() + "님 환영합니다.");
//		} else {
//			System.out.println("[ ERROR ] : ID 또는 PW가 틀립니다.");
//		}
//		sc.close();
	}
}
