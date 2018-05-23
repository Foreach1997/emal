package com.xiaoluo.entity;

public class wxcode {
	private Integer id;
	private String  code;
	public wxcode() {
		super();
	}
	public wxcode(String code) {
		super();
		this.code = code;
	}
	public wxcode(Integer id, String code) {
		super();
		this.id = id;
		this.code = code;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "wxcode [id=" + id + ", code=" + code + "]";
}
	}
