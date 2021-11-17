package com.example.loginadmin.Entity;

import javax.persistence.Column;
import javax.persistence.Id;

public class Screen {

	@Id
	@Column(name = "idtxn")
	private String idtxn;
	@Column(name = "description")
	private String description;
	@Column(name = "isEnable")
	private int isEnable;
//	@ManyToMany(mappedBy = "src")
//	private Set<roles> usedbyrole;

	public String getIdtxn() {
		return idtxn;
	}

	public void setIdtxn(String idtxn) {
		this.idtxn = idtxn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(int isEnable) {
		this.isEnable = isEnable;
	}
}
