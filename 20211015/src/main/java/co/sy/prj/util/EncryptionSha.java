package co.sy.prj.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class EncryptionSha {
	
	public String createSalt() {		// 암호화 KEY.
		String salt = null;
		try {
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
			byte[] bytes = new byte[16];
			random.nextBytes(bytes);
			salt = new String(Base64.getEncoder().encode(bytes));
		} catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return salt;
	}
	
	public String sha512(String pw, String encKey) {
		String encStr = null;
		String hash = pw + encKey;
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
			messageDigest.update(hash.getBytes());
			encStr = String.format("%128x", new BigInteger(1, messageDigest.digest()));
			// byte를 String으로 변환하기 위함.
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return encStr;
	} 
}
