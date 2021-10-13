package co.sy.prj.board.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.sy.prj.board.service.BoardMapper;
import co.sy.prj.board.service.BoardService;
import co.sy.prj.board.service.BoardVO;
import co.sy.prj.comm.DataSource;

public class BoardServiceImpl implements BoardService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	// openSession(true) : Auto COMMIT 
	// openSession(false) : Auto COMMIT이 아니다. 내가 Transaction 상태를 보고, COMMIT할지 말지 결정하겠다.
	private BoardMapper map = sqlSession.getMapper(BoardMapper.class);
	
	@Override
	public List<BoardVO> boardSelectList() {
		//return sqlSession.selectList("boardSelectList");
		return map.boardSelectList();
	}

	@Override
	public BoardVO boardSelect(BoardVO vo) {
		vo = map.boardSelect(vo);
		if(vo != null) {
			
		}
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
