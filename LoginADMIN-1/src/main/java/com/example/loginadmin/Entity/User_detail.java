package com.example.loginadmin.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User_detail {
	@Id
	@Column(name = "iduser")
	private String iduser;
	@Column(name = "name")
	private String name;
	@Column(name = "Mail")
	private String mail;
	@Column(name = "typeUser")
	private String typeUser;
	@Column(name = "id_entity")
	private String identity;

	public String getIduser() {
		return iduser;
	}

	public void setIduser(String iduser) {
		this.iduser = iduser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}
}
