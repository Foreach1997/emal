package com.xiaoluo.mapper;

import java.util.List;

import com.xiaoluo.entity.order;

public interface orderMapperSQL {
public void setOrder(order order);
public List<order> getOrder(String code);
public List<order> getAllOrder();
}
