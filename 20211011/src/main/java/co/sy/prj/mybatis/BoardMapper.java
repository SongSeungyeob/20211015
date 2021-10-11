package co.sy.prj.mybatis;

import java.util.List;

import co.sy.prj.board.service.BoardVO;

public interface BoardMapper {
	// 우리가 만든, BoardService Interface와 동일.
	List<BoardVO> boardSelectList();	// 전체 목록 가져오기
	BoardVO boardSelect(BoardVO board);	// 하나의 글 조회
	int boardInsert(BoardVO board);		// 게시글 등록(삽입)
	int boardUpdate(BoardVO board);		// 게시글 수정
	int boardDelete(BoardVO board);		// 게시글 삭제
}
