package com.example.loginadmin.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "A_USER")
public class channel_user {
	@Id
	@Column(name = "iduser")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String iduser;
	@Column(name = "PASSUSER")
	private String pass;
	@Column(name = "IDCHANNELUSER")
	private String idchanneluser;
	@Column(name = "idchannel")
	private String idchannel;
	@Column(name = "identity")
	private String identity;

	@Column(name = "NAME_USER")
	private String fullname;

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getIduser() {
		return iduser;
	}

	public void setIduser(String iduser) {
		this.iduser = iduser;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getIdchanneluser() {
		return idchanneluser;
	}

	public void setIdchanneluser(String idchanneluser) {
		this.idchanneluser = idchanneluser;
	}

	public String getIdchannel() {
		return idchannel;
	}

	public void setIdchannel(String idchannel) {
		this.idchannel = idchannel;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

}
