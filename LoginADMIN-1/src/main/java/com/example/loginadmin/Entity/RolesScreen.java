package com.example.loginadmin.Entity;

import javax.persistence.Column;
import javax.persistence.Id;

public class RolesScreen {

	@Id
	@Column(name = "idrolescreen")
	private String idrs;
	@Column(name = "idrole")
	private String idrole;
	@Column(name = "idtxn")
	private String idtxn;

	public String getIdrs() {
		return idrs;
	}

	public void setIdrs(String idrs) {
		this.idrs = idrs;
	}

	public String getIdrole() {
		return idrole;
	}

	public void setIdrole(String idrole) {
		this.idrole = idrole;
	}

	public String getIdtxn() {
		return idtxn;
	}

	public void setIdtxn(String idtxn) {
		this.idtxn = idtxn;
	}

}
