package co.sy.prj.board.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.sy.prj.board.service.BoardMapper;
import co.sy.prj.board.service.BoardService;
import co.sy.prj.board.service.BoardVO;
import co.sy.prj.comm.DataSource;

public class BoardServiceImpl implements BoardService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private BoardMapper map = sqlSession.getMapper(BoardMapper.class);
	
	@Override
	public List<BoardVO> boardList() {
		return map.boardList();
	}
	@Override
	public BoardVO boardSelect(BoardVO vo) {
		return map.boardSelect(vo);
	}
	@Override
	public int boardUpdate(BoardVO vo) {
		return map.boardUpdate(vo);
	}
	@Override
	public int boardInsert(BoardVO vo) {
		return map.boardInsert(vo);
	}
	@Override
	public int boardDelete(BoardVO vo) {
		return map.boardDelete(vo);
	}
	@Override
	public void boardHitUpdate(int id) {
		map.boardHitUpdate(id);
	}
}
