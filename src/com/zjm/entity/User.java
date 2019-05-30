package com.zjm.entity;

public class User {
	private String info_nickname;//昵称
	private String info_phone;//用户电话
	private String info_email;//用户电子邮箱
	private Integer info_gender;//用户性别
	private String info_address;//用户地址
	private Integer user_type;//用户状态
	
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String info_nickname, String info_phone, String info_email, Integer info_gender, String info_address,
			Integer user_type) {
		super();
		this.info_nickname = info_nickname;
		this.info_phone = info_phone;
		this.info_email = info_email;
		this.info_gender = info_gender;
		this.info_address = info_address;
		this.user_type = user_type;
	}
	public String getInfo_nickname() {
		return info_nickname;
	}
	public void setInfo_nickname(String info_nickname) {
		this.info_nickname = info_nickname;
	}
	public String getInfo_phone() {
		return info_phone;
	}
	public void setInfo_phone(String info_phone) {
		this.info_phone = info_phone;
	}
	public String getInfo_email() {
		return info_email;
	}
	public void setInfo_email(String info_email) {
		this.info_email = info_email;
	}
	public Integer getInfo_gender() {
		return info_gender;
	}
	public void setInfo_gender(Integer info_gender) {
		this.info_gender = info_gender;
	}
	public String getInfo_address() {
		return info_address;
	}
	public void setInfo_address(String info_address) {
		this.info_address = info_address;
	}
	public Integer getUser_type() {
		return user_type;
	}
	public void setUser_type(Integer user_type) {
		this.user_type = user_type;
	}
	@Override
	public String toString() {
		return "User [info_nickname=" + info_nickname + ", info_phone=" + info_phone + ", info_email=" + info_email
				+ ", info_gender=" + info_gender + ", info_address=" + info_address + ", user_type=" + user_type + "]";
	}
	
}
