package br.com.heusser.custovidaservice.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Criptografia {

	public static String sha256(String s) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		MessageDigest algoritmo = MessageDigest.getInstance("SHA-256");
		byte messageDigest[] = algoritmo.digest(s.getBytes("UTF-8"));
		StringBuilder hex = new StringBuilder();
		for (byte b : messageDigest){
			hex.append(String.format("%02X", 0xFF & b));
		}
		return hex.toString();
	}
	
}
