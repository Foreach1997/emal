package com.xiaoluo.entity;

public class goods {
private  Integer id;
private  String  goodsName;
private  Integer  price;
private  String   photo;
public goods() {
	super();
}
public goods(Integer id, String goodsName,Integer price, String photo) {
	super();
	this.id = id;
	this.goodsName = goodsName;
	this.price = price;
	this.photo = photo;
}
public goods(Integer id, String goodsName, Integer price) {
	super();
	this.id = id;
	this.goodsName = goodsName;
	this.price = price;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getGoodsName() {
	return goodsName;
}
public void setGoodsName(String goodsName) {
	this.goodsName = goodsName;
}
public Integer getPrice() {
	return price;
}
public void setPrice(Integer price) {
	this.price = price;
}
public String getPhoto() {
	return photo;
}
public void setPhoto(String photo) {
	this.photo = photo;
}
@Override
public String toString() {
	return "goods [id=" + id + ", goodsName=" + goodsName + ", price=" + price + "]";
}

}
