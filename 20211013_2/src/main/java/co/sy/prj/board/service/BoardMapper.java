package co.sy.prj.board.service;

import java.util.List;

import co.sy.prj.member.service.MemberVO;

public interface BoardMapper {			
	// MyBatis에서 사용할 Mapper Interface.
	// BoardService와 똑같은 친구이지만, Mybatis 용으로 따로 만든 것.
	// 나중에 transaction 발생하고 하다보면 차이가 발생할 수 있다.
	
	List<BoardVO> boardSelectList();	
	BoardVO boardSelect(BoardVO vo);
	int boardUpdate(BoardVO vo);
	int boardInsert(BoardVO vo);
	int boardDelete(BoardVO vo);
	int boardUpdateName(MemberVO vo);
	void boardHitUpdate(int id);
}
