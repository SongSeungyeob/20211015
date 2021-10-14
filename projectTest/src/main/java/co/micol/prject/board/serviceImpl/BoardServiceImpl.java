package co.micol.prject.board.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.micol.prject.board.service.BoardMapper;
import co.micol.prject.board.service.BoardService;
import co.micol.prject.board.service.BoardVO;
import co.micol.prject.comm.DataSource;

public class BoardServiceImpl implements BoardService{
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private BoardMapper map = sqlSession.getMapper(BoardMapper.class);
	
	@Override
	public List<BoardVO> boardSelectList() {
		return map.boardSelectList();
	}
}
