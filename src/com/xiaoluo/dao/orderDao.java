package com.xiaoluo.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.springframework.stereotype.Component;

import com.xiaoluo.entity.order;
import com.xiaoluo.mapper.orderMapperSQL;

@Component
public class orderDao {
	public SqlSessionFactory sqlSessionFactory() throws IOException{
	    String resource = "mybatis.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	 
    }
	public void setOrder(order order) throws IOException{
		SqlSessionFactory sessionFactory=sqlSessionFactory();
		SqlSession session=sessionFactory.openSession();
		orderMapperSQL mapper=session.getMapper(orderMapperSQL.class);
		mapper.setOrder(order);
		session.commit();
		session.close();
	}
	public List<order> getOrder(String code) throws IOException{
		SqlSessionFactory sessionFactory=sqlSessionFactory();
		SqlSession session=sessionFactory.openSession();
		orderMapperSQL mapper=session.getMapper(orderMapperSQL.class);
		List<order> order=mapper.getOrder(code);
		System.out.println(order);
		session.commit();
		session.close();
		return order;
	}
	public List<order> getAllOrder() throws IOException {
		// TODO Auto-generated method stub
		SqlSessionFactory sessionFactory=sqlSessionFactory();
		SqlSession session=sessionFactory.openSession();
		orderMapperSQL mapper=session.getMapper(orderMapperSQL.class);
		List<order> order=mapper.getAllOrder();
		System.out.println(order);
		session.commit();
		session.close();
		return order;
	}
}
