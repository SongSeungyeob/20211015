package co.sy.prj.comm;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DataSource {
	private static SqlSessionFactory sqlSessionFactory;	
	// SqlSessionFactory = mybatis를 사용하기 위한 객체.
	
	private DataSource() {}
	
	public static SqlSessionFactory getInstance() {	
		// 이 과정을 통해 내가 원하는 DB에 연결된다.
		// Connection Pool 기반으로 연결이 된다.
		String resource = "mybatis-config.xml";	// mybatis-config.xml 을 읽어온다.
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sqlSessionFactory;
	}
}
