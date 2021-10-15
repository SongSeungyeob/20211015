package co.sy.prj.user;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import co.sy.prj.database.DB;

public class User {
	private static final int SALT_SIZE = 16;
	private static DB db = new DB();
	
	public void setUser(String ID, byte[] PW) {
		String Salt = getSalt();
		db.setUser(ID,  Hashing(PW, Salt), Salt);
	}
	
	public void getUser(String ID, byte[]password) {
		String tempSalt = db.getSalt(ID);
		String tempPass = Hashing(password, tempSalt);
		
		if(db.check(ID,  tempPass)) {
			System.out.println("[ SUCCESS LOGIN ]");
		} else {
			System.out.println("[ FAILURE LOGIN ] ");
		}
	}
	
	public String Hashing(byte[] PW, String Salt) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		for(int i = 0;  i < 10000; i++) {
			String temp = Byte_to_String(PW) + Salt;
			md.update(temp.getBytes());
			PW = md.digest();
		}
		
		return Byte_to_String(PW);
	}
	
	private String getSalt() {
		SecureRandom sr = new SecureRandom();
		byte[] temp = new byte[SALT_SIZE];
		sr.nextBytes(temp);
		
		return Byte_to_String(temp);
	}
	
	private String Byte_to_String(byte[] bt) {
		StringBuilder sb = new StringBuilder();
		for(byte a : bt) {
			sb.append(String.format("%02x", a));
		}
		return sb.toString();
	}
	
	public void get_DB() {
		System.out.println("======================== DB 출력 ======================");
		System.out.println(db);
	}
}
