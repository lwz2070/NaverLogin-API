package com.my.bean;


public class MemberBean {
	private int mem_num;
	private String mem_id, mem_nick, mem_password;
	private String mem_context;
	
	public MemberBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberBean(int mem_num, String mem_id, String mem_nick, String mem_password) {
		super();
		this.mem_num = mem_num;
		this.mem_id = mem_id;
		this.mem_nick = mem_nick;
		this.mem_password = mem_password;
	}
	public int getMem_num() {
		return mem_num;
	}
	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_nick() {
		return mem_nick;
	}
	public void setMem_nick(String mem_nick) {
		this.mem_nick = mem_nick;
	}
	public String getmem_password() {
		return mem_password;
	}
	public void setmem_password(String mem_password) {
		this.mem_password = mem_password;
	}
	@Override
	public String toString() {
		return "MemberBean [mem_num=" + mem_num + ", mem_id=" + mem_id + ", mem_nick=" + mem_nick + ", mem_password="
				+ mem_password + "]";
	}
	
	

}
