package com.xiaoluo.mapper;



import org.apache.ibatis.annotations.Param;

import com.xiaoluo.entity.user;

public interface userMapperSQL {
	public Integer getCount(@Param("username") String username,@Param("password") String possword);
	public user getUser(Integer id);
	
}
