package com.xiaoluo.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

import com.xiaoluo.entity.wxcode;
import com.xiaoluo.mapper.wxcodeMapperSQL;
@Component
public class wxcodeDao {
	public SqlSessionFactory sqlSessionFactory() throws IOException{
	    String resource = "mybatis.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	 
    }
	public void setcode(String code) throws IOException{
		SqlSessionFactory sessionFactory=sqlSessionFactory();
		SqlSession session=sessionFactory.openSession();
		wxcodeMapperSQL mapper=session.getMapper(wxcodeMapperSQL.class);
		wxcode  wxcode=new wxcode(code);
		mapper.setCodeValue(wxcode);
		session.commit();
		session.close();
	}
	public Integer getCountCode(String code) throws IOException{
		SqlSessionFactory sessionFactory=sqlSessionFactory();
		SqlSession session=sessionFactory.openSession();
		wxcodeMapperSQL mapper=session.getMapper(wxcodeMapperSQL.class);
		 Integer count=mapper.getCountCode(code);
		 System.out.println(count);
		session.commit();
		session.close();
		return count;
	}
}
