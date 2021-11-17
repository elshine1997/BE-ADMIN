package com.example.loginadmin.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User_role {

	@Id
	@Column(name = "id_user_role")
	private String idur;
	@Column(name = "id_entity")
	private String id_entity;
	@Column(name = "iduser")
	private String iduser;
	@Column(name = "idchannel")
	private String idchannel;
	@Column(name = "idrole")
	private String idrole;

	public String getIdur() {
		return idur;
	}

	public void setIdur(String idur) {
		this.idur = idur;
	}

	public String getId_entity() {
		return id_entity;
	}

	public void setId_entity(String id_entity) {
		this.id_entity = id_entity;
	}

	public String getIduser() {
		return iduser;
	}

	public void setIduser(String iduser) {
		this.iduser = iduser;
	}

	public String getIdchannel() {
		return idchannel;
	}

	public void setIdchannel(String idchannel) {
		this.idchannel = idchannel;
	}

	public String getIdrole() {
		return idrole;
	}

	public void setIdrole(String idrole) {
		this.idrole = idrole;
	}
}
