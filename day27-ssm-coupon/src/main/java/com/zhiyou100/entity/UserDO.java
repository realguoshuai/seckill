package com.zhiyou100.entity;

import java.io.Serializable;

public class UserDO implements Serializable {

	private static final long serialVersionUID = 7611463895791244110L;

	private Integer id;
	
	private String email;
	
	private String password;

	@Override
	public String toString() {
		return "UserDO [id=" + id + ", email=" + email + ", password=" + password + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
