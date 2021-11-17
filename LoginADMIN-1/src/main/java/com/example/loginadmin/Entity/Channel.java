package com.example.loginadmin.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Channel {

	@Id
	private String id_channel;
	@Column(name = "channel_name")
	private String channel_name;

	public String getId_channel() {
		return id_channel;
	}

	public void setId_channel(String id_channel) {
		this.id_channel = id_channel;
	}

	public String getChannel_name() {
		return channel_name;
	}

	public void setChannel_name(String channel_name) {
		this.channel_name = channel_name;
	}
}
