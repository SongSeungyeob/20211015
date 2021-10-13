package co.sy.prj.board.service;

import java.util.List;

public interface BoardMapper {
	List<BoardVO> boardList();
	BoardVO boardSelect(BoardVO vo);
	int boardUpdate(BoardVO vo);
	int boardInsert(BoardVO vo);
	int boardDelete(BoardVO vo);
	void boardHitUpdate(int id);
}
