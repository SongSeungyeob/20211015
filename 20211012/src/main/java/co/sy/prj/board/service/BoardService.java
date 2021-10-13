package co.sy.prj.board.service;

import java.util.List;

public interface BoardService {			// Service Interface.
	List<BoardVO> boardSelectList();
	BoardVO boardSelect(BoardVO vo);
	int boardUpdate(BoardVO vo);
	int boardInsert(BoardVO vo);
	int boardDelete(BoardVO vo);
	void boardHitUpdate(int id);
}
