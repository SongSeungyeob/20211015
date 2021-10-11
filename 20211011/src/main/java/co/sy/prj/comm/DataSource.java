package co.sy.prj.comm;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource {	//DAO : Data Access Object
	private static DataSource dataSource = new DataSource();
	private Connection conn;
	private String driver;
	private String url;
	private String user;
	private String password;
	
	private DataSource() { config(); }
	
	public static DataSource getInstance() {
		return dataSource;
	}
	
	private void config() {
		Properties properties = new Properties();
		// Properties = property 파일을 읽어오는 거거든요. property  : Key  =Value 의 형태를 가지고 있어요.
		String resource = getClass().getResource("/db.properties").getPath();
		// getClass()가 아마 Object클래스에 method일거에요. getSrouce("가져올 propertiese 파일")
		// properties 에 대한 값을 getPath()가 그대로 가져오는거에요.
		// resource는 이 property에 적혀있는 driver, url, user, passwd 를 통해서 이 db의 주소를 가지고 오는 건데..
		try {
			properties.load(new FileReader(resource));
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
