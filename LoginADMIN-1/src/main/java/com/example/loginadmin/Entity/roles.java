package com.example.loginadmin.Entity;

import javax.persistence.Column;
import javax.persistence.Id;

public class roles {
	@Id
	private String id_role;
	@Column(name = "description")
	private String name;
	@Column(name = "id_entity")
	private String id_entity;
	@Column(name = "id_channel")
	private String id_channel;
	@Column(name = "usertype")
	private String usertype;
	@Column(name = "datecreated")
	private String datecreated;
	@Column(name = "dateupdated")
	private String dateupdated;
	@Column(name = "created_by")
	private String created_by;

	public String getId_role() {
		return id_role;
	}

	public void setId_role(String id_role) {
		this.id_role = id_role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId_entity() {
		return id_entity;
	}

	public void setId_entity(String id_entity) {
		this.id_entity = id_entity;
	}

	public String getId_channel() {
		return id_channel;
	}

	public void setId_channel(String id_channel) {
		this.id_channel = id_channel;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getDatecreated() {
		return datecreated;
	}

	public void setDatecreated(String datecreated) {
		this.datecreated = datecreated;
	}

	public String getDateupdated() {
		return dateupdated;
	}

	public void setDateupdated(String dateupdated) {
		this.dateupdated = dateupdated;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "role_screen", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "idtxn"))
//	private Set<Screen> scr;

}
