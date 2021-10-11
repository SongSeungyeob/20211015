package co.sy.prj.board.service;

import java.util.List;

public interface BoardService {
	List<BoardVO> boardSelectList();	// 전체 목록 가져오기
	BoardVO boardSelect(BoardVO board);	// 하나의 글 조회
	int boardInsert(BoardVO board);		// 게시글 등록(삽입)
	int boardUpdate(BoardVO board);		// 게시글 수정
	int boardDelete(BoardVO board);		// 게시글 삭제
}
