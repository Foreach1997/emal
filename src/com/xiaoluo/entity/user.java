package com.xiaoluo.entity;

public class user {
private Integer id;
private String username;
private String password;
public user() {
	super();
}
public user(Integer id, String username, String possword) {
	super();
	this.id = id;
	this.username = username;
	this.password = possword;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPossword() {
	return password;
}
public void setPossword(String possword) {
	this.password = possword;
}
@Override
public String toString() {
	return "user [id=" + id + ", username=" + username + ", possword=" + password + "]";
}

}
