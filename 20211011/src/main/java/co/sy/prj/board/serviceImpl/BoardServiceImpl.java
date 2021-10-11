package co.sy.prj.board.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.sy.prj.board.service.BoardService;
import co.sy.prj.board.service.BoardVO;
import co.sy.prj.comm.DataSource;

public class BoardServiceImpl implements BoardService {

	private DataSource dataSource = DataSource.getInstance();
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	@Override
	public List<BoardVO> boardSelectList() {
		List<BoardVO> list = new ArrayList<BoardVO>();
		BoardVO board;
		String sql = "select * from board";
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				board = new BoardVO();
				board.setBId(rs.getInt("bid"));
				board.setBWriter(rs.getString("bwriter"));
				board.setBWriteDate(rs.getDate("bwritedate"));
				board.setBTitle(rs.getString("btitle"));
				board.setBHit(rs.getInt("bhit"));
				list.add(board);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	@Override
	public BoardVO boardSelect(BoardVO board) {
		String sql = "select * from board where bid = ?";
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, board.getBId());
			rs = psmt.executeQuery();
			if(rs.next()) {
				board.setBWriter(rs.getString("bwriter"));
				board.setBWriteDate(rs.getDate("bwritedate"));
				board.setBTitle(rs.getString("btitle"));
				board.setBContents(rs.getString("bcontents"));
				board.setBHit(rs.getInt("bhit"));
				hitUpdate(board.getBId());
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return board;
	}

	@Override
	public int boardInsert(BoardVO board) {	// 글 추가
		int n = 0;
		String sql = "insert into board values (b_squ.nextval, ?,sysdate,?,?,0)";
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,  board.getBWriter());
			psmt.setString(2,  board.getBTitle());
			psmt.setString(3, board.getBContents());
			//hitUpdate(board.getbId());
			n = psmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return n;
	}

	@Override
	public int boardUpdate(BoardVO board) {	// 글 수정
		int n = 0;
		String sql = "update board set bcontents = ? where bid = ?";
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, board.getBContents());
			psmt.setInt(2,  board.getBId());
			n = psmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return n;
	}

	@Override
	public int boardDelete(BoardVO board) {	// 글 삭제
		int n = 0;
		String sql = "delete from board where bid = ?";
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, board.getBId());
			n = psmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}
	
	private void close() {
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void hitUpdate(int bId) {	// 조회수 증가 Method.
		String sql = "update board set bhit = bhit + 1 where bid = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, bId);
			psmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
