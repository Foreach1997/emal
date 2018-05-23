package com.xiaoluo.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.xiaoluo.entity.goods;
import com.xiaoluo.entity.order;
import com.xiaoluo.entity.user;
import com.xiaoluo.entity.wxcode;
import com.xiaoluo.mapper.goodsMapperSQL;
import com.xiaoluo.mapper.orderMapperSQL;
import com.xiaoluo.mapper.userMapperSQL;
import com.xiaoluo.mapper.wxcodeMapperSQL;

public class test {
	public SqlSessionFactory sqlSessionFactory() throws IOException{
	    String resource = "mybatis.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	 
    }
	@Test
	public  void count() throws IOException{
		SqlSessionFactory sessionFactory=sqlSessionFactory();
		SqlSession session=sessionFactory.openSession();
		userMapperSQL mapper=session.getMapper(userMapperSQL.class);
//		int count=mapper.getCount("123", "123");
		user user=new user();
		user=mapper.getUser(1);
		System.out.println(user);
		session.commit();
		session.close();
	}
	@Test()
	public void  getcount() throws IOException{
		SqlSessionFactory sessionFactory=sqlSessionFactory();
		SqlSession session=sessionFactory.openSession();
		userMapperSQL mapper=session.getMapper(userMapperSQL.class);
		Integer count =mapper.getCount("123", "123");
		System.out.println(count);
		session.commit();
		session.close();
	}
	@Test()
	public void getAllGoods() throws IOException{
		SqlSessionFactory sessionFactory=sqlSessionFactory();
		SqlSession session=sessionFactory.openSession();
		goodsMapperSQL mapper=session.getMapper(goodsMapperSQL.class);
		List<goods> list=mapper.getAllGoods();
		System.out.println(list);
		session.commit();
		session.close();
	}
	@Test()
	public void setGoodsAndPrice() throws IOException{
		SqlSessionFactory sessionFactory=sqlSessionFactory();
		SqlSession session=sessionFactory.openSession();
		goodsMapperSQL mapper=session.getMapper(goodsMapperSQL.class);
		mapper.setGoodsAndPrice("da", 12,1);
		session.commit();
		session.close();
	}
	@Test()
	public void setGoods() throws IOException{
		SqlSessionFactory sessionFactory=sqlSessionFactory();
		SqlSession session=sessionFactory.openSession();
		goodsMapperSQL mapper=session.getMapper(goodsMapperSQL.class);
		//goods goods=new goods(5,1,"mian","qweqweqweq");
		mapper.setGoods("da",12,"q1",1);
		session.commit();
		session.close();
	}
	@Test()
	public void setcodevalue() throws IOException{
		SqlSessionFactory sessionFactory=sqlSessionFactory();
		SqlSession session=sessionFactory.openSession();
		wxcodeMapperSQL mapper=session.getMapper(wxcodeMapperSQL.class);
		wxcode wxcode=new wxcode("1");
		mapper.setCodeValue(wxcode);
		session.commit();
		session.close();
	}
	@Test()
	public void getCountCode() throws IOException{
		SqlSessionFactory sessionFactory=sqlSessionFactory();
		SqlSession session=sessionFactory.openSession();
		wxcodeMapperSQL mapper=session.getMapper(wxcodeMapperSQL.class);
		 Integer count=mapper.getCountCode("ox4UI0UTD9AWpkenekTibJCLAQ9k");
		 System.out.println(count);
		session.commit();
		session.close();
	}
	@Test()
	public void setOrder() throws IOException{
		SqlSessionFactory sessionFactory=sqlSessionFactory();
		SqlSession session=sessionFactory.openSession();
		orderMapperSQL mapper=session.getMapper(orderMapperSQL.class);
		order order= new order("ox4UI0UTD9AWpkenekTibJCLAQ9k", "123", "¥Û≈Ãº¶", "66");
		mapper.setOrder(order);
		session.commit();
		session.close();
	}
	@Test()
	public void getOrder() throws IOException{
		SqlSessionFactory sessionFactory=sqlSessionFactory();
		SqlSession session=sessionFactory.openSession();
		orderMapperSQL mapper=session.getMapper(orderMapperSQL.class);
		List<order> order=mapper.getOrder("ox4UI0UTD9AWpkenekTibJCLAQ9k");
		System.out.println(order);
		session.commit();
		session.close();
	}
	@Test()
	public void getGoods() throws IOException{
		SqlSessionFactory sessionFactory=sqlSessionFactory();
		SqlSession session=sessionFactory.openSession();
		goodsMapperSQL mapper=session.getMapper(goodsMapperSQL.class);
		goods good=mapper.getGoods(1);
		System.out.println(good);
		session.commit();
		session.close();
	}
}
