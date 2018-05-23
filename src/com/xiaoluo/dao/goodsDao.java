package com.xiaoluo.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

import com.xiaoluo.entity.goods;
import com.xiaoluo.mapper.goodsMapperSQL;

@Component
public class goodsDao {
	public SqlSessionFactory sqlSessionFactory() throws IOException{
	    String resource = "mybatis.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream); 
    }
	public List<goods> getAllGoods() throws IOException{
		SqlSessionFactory sessionFactory=sqlSessionFactory();
		SqlSession session=sessionFactory.openSession();
		goodsMapperSQL mapper=session.getMapper(goodsMapperSQL.class);
		List<goods> list=mapper.getAllGoods();
		session.commit();
		session.close();
		return list;
	}
	public void setGoodsAndPrice(String goodsName,Integer price,Integer id) throws IOException{
		SqlSessionFactory sessionFactory=sqlSessionFactory();
		SqlSession session=sessionFactory.openSession();
		goodsMapperSQL mapper=session.getMapper(goodsMapperSQL.class);
		mapper.setGoodsAndPrice(goodsName, price,id);
		session.commit();
		session.close();
	}
	public void setGoods(String goodsName, Integer price,String photo,Integer id) throws IOException{
		SqlSessionFactory sessionFactory=sqlSessionFactory();
		SqlSession session=sessionFactory.openSession();
		goodsMapperSQL mapper=session.getMapper(goodsMapperSQL.class);
		mapper.setGoods(goodsName,price,photo,id);
		session.commit();
		session.close();
	}
	public goods getGoods(Integer id) throws IOException{
		SqlSessionFactory sessionFactory=sqlSessionFactory();
		SqlSession session=sessionFactory.openSession();
		goodsMapperSQL mapper=session.getMapper(goodsMapperSQL.class);
		goods good=mapper.getGoods(id);
		session.commit();
		session.close();
		return good;
	}
	public void delGoods(Integer id) throws IOException {
		// TODO Auto-generated method stub
		SqlSessionFactory sessionFactory=sqlSessionFactory();
		SqlSession session=sessionFactory.openSession();
		goodsMapperSQL mapper=session.getMapper(goodsMapperSQL.class);
		mapper.delGoods(id);
		session.commit();
		session.close();
	}
	public void addGoods(goods good) throws IOException {
		// TODO Auto-generated method stub
		SqlSessionFactory sessionFactory=sqlSessionFactory();
		SqlSession session=sessionFactory.openSession();
		goodsMapperSQL mapper=session.getMapper(goodsMapperSQL.class);
		mapper.addGoods(good);
		session.commit();
		session.close();
	}
}
