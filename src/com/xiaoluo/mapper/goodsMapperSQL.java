package com.xiaoluo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xiaoluo.entity.goods;

public interface goodsMapperSQL {
 public List<goods> getAllGoods();
 public void setGoodsAndPrice(@Param("goodsName") String goodsName,@Param("price") Integer price,@Param("id") Integer id);
 public goods getGoods(Integer id);
public void setGoods(@Param("goodsName") String goodsName,@Param("price") Integer price,@Param("photo") String photo,@Param("id") Integer id);
public void delGoods(Integer id);
public void addGoods(goods good);
}
