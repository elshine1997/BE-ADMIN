package com.example.loginadmin.Dto;

import java.io.Serializable;

public class SignupDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8910974641208549791L;
	private String idUser;
	private String pass;

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getIdChannel() {
		return idChannel;
	}

	public void setIdChannel(String idChannel) {
		this.idChannel = idChannel;
	}

	public String getIdEntity() {
		return idEntity;
	}

	public void setIdEntity(String idEntity) {
		this.idEntity = idEntity;
	}

	public String getIdChannlelUser() {
		return idChannlelUser;
	}

	public void setIdChannlelUser(String idChannlelUser) {
		this.idChannlelUser = idChannlelUser;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private String idChannel;
	private String idEntity;
	private String idChannlelUser;
	private String name_user;

	public String getName_user() {
		return name_user;
	}

	public void setName_user(String name_user) {
		this.name_user = name_user;
	}
}
