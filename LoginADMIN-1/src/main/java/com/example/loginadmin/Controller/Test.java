package com.example.loginadmin.Controller;

import java.security.SecureRandom;
import java.util.Arrays;

import com.example.loginadmin.JF.HMacUtil;
import com.example.loginadmin.JF.JFBase64;
import com.example.loginadmin.JF.JFCompressor;

public class Test {
	public boolean checkpass(String pass) throws Exception {
		boolean isMatchPwd = checkAuthenPass("F001", "11", "462", "123456", pass);
		return isMatchPwd;
	}

	public String getPasswordDigest(String idEntity, String idUser, String idChannel, String password)
			throws Exception {
		PasswordEncryptionData l_data = new PasswordEncryptionData();
		l_data.idEntity = idEntity;
		l_data.idUser = idUser;
		l_data.idChannel = idChannel;
		l_data.password = password;
		String a = JFBase64.byteArrayToBase64(encryptPassword(l_data));
		return a;
	}

	private byte[] encryptPassword(PasswordEncryptionData p_data) throws Exception {
		PasswordEncryptionData l_data = new PasswordEncryptionData();

		l_data.idEntity = p_data.idEntity;
		l_data.idChannel = p_data.idChannel;
		l_data.idUser = p_data.idUser;
		l_data.password = JFBase64.byteArrayToBase64(encryptData(p_data));
		JFCompressor compressor = new JFCompressor();

		String a = "<PasswordEncryptionData><password>" + l_data.password
				+ "</password><passwordLength>0</passwordLength></PasswordEncryptionData>";

		return compressor.compress(a);
	}

	private final class PasswordEncryptionData {

		public transient String idPolicy;
		public transient String idEntity;
		public transient String idUser;
		public transient String idChannelUser;
		public transient String idChannel;
		public String password;
		public String[] pin;
		public int passwordLength;
		public int[] randomPasswordPosition;
		public transient String encryptionKey;
		public transient byte[] randomKey;
		public transient String idCustomer;
		public transient String idSession;
	}

	private byte[] encryptData(PasswordEncryptionData p_data) throws Exception {
		byte[] l_random = new byte[8];
		boolean l_isRandom = false;
		SecureRandom l_r = null;

		if ((p_data.randomKey == null) || (p_data.randomKey.length < 8)) {
			l_isRandom = true;
			l_r = new SecureRandom();
		}

		for (int l_i = 0; l_i < l_random.length; l_i++) {
			l_random[l_i] = (byte) (l_isRandom ? l_r.nextInt() : p_data.randomKey[l_i]);
		}

		String l_key = p_data.idEntity + p_data.idUser;
		byte[] l_bytes = HMacUtil.mergeArray(l_random, l_key.getBytes("UTF-8"));
		return HMacUtil.mergeArray(l_random, HMacUtil.encrypt(l_bytes, p_data.password.getBytes("UTF-8")));
	}

	public boolean checkAuthenPass(String idEntity, String idChannel, String idUser, String passInput, String passData)
			throws Exception {
		String passwordData = passData;
		byte[] l_p = JFBase64.base64ToByteArray(passwordData);

		JFCompressor compressor = new JFCompressor();
		String p_xml = compressor.uncompress(l_p);
		String passData_HMAC = p_xml.substring("<PasswordEncryptionData><password>".length(),
				p_xml.length() - "</password><passwordLength>0</passwordLength></PasswordEncryptionData>".length());

		byte[] l_c = JFBase64.base64ToByteArray(passData_HMAC);
		PasswordEncryptionData l_data = new PasswordEncryptionData();
		l_data.idEntity = idEntity;
		l_data.idChannel = idChannel;
		l_data.idUser = idUser;
		l_data.password = passInput;
		l_data.randomKey = l_c;

		byte[] l_b = encryptData(l_data);

		return Arrays.equals(l_b, l_c);
	}
}
