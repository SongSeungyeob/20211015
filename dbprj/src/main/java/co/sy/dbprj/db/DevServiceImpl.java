package co.sy.dbprj.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.sy.dbprj.DataSource;

public class DevServiceImpl extends DataSource {
	private PreparedStatement psmt;
	private ResultSet rs;
	
//	public List<DevVO> selectList() {
//		DevVO vo = new DevVO();
//		List<DevVO> list = new ArrayList<>();
//		
//		return list;
//	}
	
	public void selectList() {
		String sql = "select * from dev";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt("id"));
				System.out.println(rs.getString("name"));
				System.out.println(rs.getString("address"));
				System.out.println(rs.getInt("age"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} 
	}
}
