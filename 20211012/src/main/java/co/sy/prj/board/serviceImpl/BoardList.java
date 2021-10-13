package co.sy.prj.board.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import co.sy.prj.board.service.BoardService;
import co.sy.prj.board.service.BoardVO;
import co.sy.prj.comm.Command;

public class BoardList implements Command {
	//private BoardService boardService = new BoardServiceImpl();
	
	@Override
	public void execute() {
		BoardService boardService = new BoardServiceImpl();
		List<BoardVO> boards = new ArrayList<BoardVO>();
		boards = boardService.boardSelectList();
		
		System.out.println("[ BOARD 목록 조회 결과 ]= = = = = = = = = = = = = = = = = =");
		for(BoardVO vo : boards) {
			System.out.print("| " + vo.getBId() + " | ");
			System.out.print("| " + vo.getBWriter() + " | ");
			System.out.print("| " + vo.getBWriteDate()+ " | ");
			System.out.print("| " + vo.getBTitle() + " | ");
			System.out.println("| " + vo.getBHit() + " | ");
		}
		System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = =");
		
	}

}
