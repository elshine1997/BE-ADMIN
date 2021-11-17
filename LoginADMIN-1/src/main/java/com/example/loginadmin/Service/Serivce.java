package com.example.loginadmin.Service;

import java.security.SecureRandom;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.example.loginadmin.JF.HMacUtil;
import com.example.loginadmin.JF.JFBase64;
import com.example.loginadmin.JF.JFCompressor;

@Service
public class Serivce {
	public boolean CheckAuthen(String identity, String idchannel, String id, String passinput, String passdata)
			throws Exception {
		String passwordData = passdata;
		byte[] l_p = JFBase64.base64ToByteArray(passwordData);

		JFCompressor compressor = new JFCompressor();
		String p_xml = compressor.uncompress(l_p);
		String passData_HMAC = p_xml.substring("<PasswordEncryptionData><password>".length(),
				p_xml.length() - "</password><passwordLength>0</passwordLength></PasswordEncryptionData>".length());

		byte[] l_c = JFBase64.base64ToByteArray(passData_HMAC);
		PassEncryptionData ldata = new PassEncryptionData();
		ldata.idEntity = identity;
		ldata.idUser = id;
		ldata.idchannel = idchannel;
		ldata.password = passinput;
		ldata.randomKey = l_c;

		byte[] l_b = encryptData(ldata);

		return Arrays.equals(l_b, l_c);
	}

	public boolean Insert(String identity, String idchannel, String id, String passinput, String iduser) {

		return true;
	}

	private byte[] encryptPassword(PassEncryptionData pdata) throws Exception {
		PassEncryptionData ldata = new PassEncryptionData();
		ldata.idEntity = pdata.idEntity;
		ldata.idUser = pdata.idUser;
		ldata.idchannel = pdata.idchannel;
		ldata.password = JFBase64.byteArrayToBase64(encryptData(pdata));
		JFCompressor compressor = new JFCompressor();
		String a = "<PasswordEncryptionData><password>" + ldata.password
				+ "</password><passwordLength>0</passwordlength></PasswordEncryptionData>";
		return compressor.compress(a);
	}

	public String getPasswordDigest(String idEntity, String idUser, String idChannel, String password)
			throws Exception {
		PassEncryptionData l_data = new PassEncryptionData();
		l_data.idEntity = idEntity;
		l_data.idUser = idUser;
		l_data.idchannel = idChannel;
		l_data.password = password;
		String a = JFBase64.byteArrayToBase64(encryptPassword(l_data));
		return a;
	}

	private byte[] encryptData(PassEncryptionData data) throws Exception {
		byte[] random = new byte[8];
		boolean isRandom = false;
		SecureRandom l_r = null;

		if ((data.randomKey == null) || (data.randomKey.length < 8)) {
			isRandom = true;
			l_r = new SecureRandom();
		}

		for (int l_i = 0; l_i < random.length; l_i++) {
			random[l_i] = (byte) (isRandom ? l_r.nextInt() : data.randomKey[l_i]);
		}

		String l_key = data.idEntity + data.idUser;
		byte[] l_bytes = HMacUtil.mergeArray(random, l_key.getBytes("UTF-8"));
		return HMacUtil.mergeArray(random, HMacUtil.encrypt(l_bytes, data.password.getBytes("UTF-8")));
	}

	private final class PassEncryptionData {
		public String password;
		public transient byte[] randomKey;
		public transient String idEntity;
		public transient String idchannel;
		public transient String idUser;

	}
}
