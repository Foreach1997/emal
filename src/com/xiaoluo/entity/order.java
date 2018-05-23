package com.xiaoluo.entity;

public class order {
private  String code;
private  String goodstime;
private  String goodsName;
private  String price;
public order() {
	super();
}

public order(String code, String goodstime, String goodsName, String price) {
	super();
	this.code = code;
	this.goodstime = goodstime;
	this.goodsName = goodsName;
	this.price = price;
}

public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
public String getTime() {
	return goodstime;
}
public void setTime(String time) {
	this.goodstime = time;
}
public String getGoodsName() {
	return goodsName;
}
public void setGoodsName(String goodsName) {
	this.goodsName = goodsName;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
@Override
public String toString() {
	return "order [code=" + code + ", time=" + goodstime + ", goodsName=" + goodsName + ", price=" + price + "]";
}

}
