package co.sy.prj.database;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class DB {
	private static ArrayList<String[]> UserData = new ArrayList<>();
	
	public void setUser(String ID, String Hashing_PW, String Salt) {
		String[] Data = { ID, Hashing_PW, Salt};
		UserData.add(Data);
	}
	
	public boolean check(String ID, String Hashing_PW) {
		for(int i = 0 ; i < UserData.size(); i++) {
			if(ID.equals(UserData.get(i)[0])) {
				if(Hashing_PW.equals(UserData.get(i)[1])) {
					return true;
				}
			}
		}
		return false;
	}
	
	public String getSalt(String ID) {
		for(int i = 0 ; i < UserData.size(); i++) {
			if(ID.equals(UserData.get(i)[0])) {
				return UserData.get(i)[2];
			}
		}
		return null;
	}
	
	public String sha512(String pw, String encKey) {
		String encStr = null;
		String hash = pw + encKey;
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
			messageDigest.update(hash.getBytes());
			encStr = String.format("%128x", new BigInteger(1, messageDigest.digest()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return encStr;
	} 
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(String[] temp : UserData) {
			sb.append("ID : " + temp[0] + "\tPW : " + temp[1] + "\tSALT : " + temp[2]).append("\n");
		}
		return sb.toString();
	}
}
