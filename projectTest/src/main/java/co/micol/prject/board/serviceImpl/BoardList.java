package co.micol.prject.board.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import co.micol.prject.board.service.BoardService;
import co.micol.prject.board.service.BoardVO;
import co.micol.prject.comm.Command;

public class BoardList implements Command {

	@Override
	public void execute() {
		BoardService boardService = new BoardServiceImpl();
		List<BoardVO> list = new ArrayList<BoardVO>();
		list = boardService.boardSelectList();
		System.out.println("[ BOARD LIST ] * * * * * * * * * * * * * * * * * * * * * * ");
		for(BoardVO vo : list) {
			vo.toListString();
		}
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
	}

}
