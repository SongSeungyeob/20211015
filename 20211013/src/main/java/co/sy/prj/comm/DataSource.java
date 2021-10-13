package co.sy.prj.comm;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DataSource {
	private static SqlSessionFactory sqlSessionFactory;
	// SqlSessionFactory 는 실제 SQL문을 처리하기 위한 객체인 SqlSession을 만들어 주는 역할이다.
	// 연결되어 있지 않은, SqlSession 객체를 SqlSessionFactory를 통해서, SqlSessionFactory는 SqlSessionFactoryBuilder를 통해서 만들 수 있다.
	// getInstance()를 통해서, db.properties와 연결되어 있는 mybatis에 대한 정보를 가지고 있는 SqlSessionFactory를 구현.
	// 이 SqlSessionFactory를 통해서, SqlSession을 만들고, 이 SqlSession으로 실제 SQL문을 진행할 것이다.
	
	private DataSource() {}

	public static SqlSessionFactory getInstance()  {
		String resource = "mybatis-config.xml";	// mybatis 를 통해서 연결할 xml File이 필요하다.
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sqlSessionFactory;
	}

}
