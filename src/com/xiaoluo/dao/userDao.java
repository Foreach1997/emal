package com.xiaoluo.dao;

import java.io.IOException;
import java.io.InputStream;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;



import com.xiaoluo.entity.user;

import com.xiaoluo.mapper.userMapperSQL;


@Component
public class userDao {
	public SqlSessionFactory sqlSessionFactory() throws IOException{
	    String resource = "mybatis.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	 
    }
	public Integer count(String username,String possword) throws IOException{
		SqlSessionFactory sessionFactory=sqlSessionFactory();
		SqlSession session=sessionFactory.openSession();
		userMapperSQL mapper=session.getMapper(userMapperSQL.class);
		int count=mapper.getCount(username, possword);
		return count;
	}
	public  user getuesrandposs() throws IOException{
		SqlSessionFactory sessionFactory=sqlSessionFactory();
		SqlSession session=sessionFactory.openSession();
		userMapperSQL mapper=session.getMapper(userMapperSQL.class);
		user user=new user();
		user=mapper.getUser(1);
		System.out.println(user);
		session.commit();
		session.close();
		return user;
	}
	
}