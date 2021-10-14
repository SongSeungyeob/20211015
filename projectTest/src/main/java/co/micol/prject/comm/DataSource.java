package co.micol.prject.comm;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DataSource {
	private static SqlSessionFactory sqlSessionFactory;
	
	private DataSource() { }

	public static SqlSessionFactory getInstance() {
		String Resource = "mybatis-config.xml";
		try {
			InputStream inputstream;
			inputstream = Resources.getResourceAsStream(Resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sqlSessionFactory;
	}
}
