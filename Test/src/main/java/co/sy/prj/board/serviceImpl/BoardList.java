package co.sy.prj.board.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import co.sy.prj.board.service.BoardService;
import co.sy.prj.board.service.BoardVO;
import co.sy.prj.comm.Command;
import co.sy.prj.member.service.MemberVO;

public class BoardList implements Command {
	//private BoardService boardService = new BoardServiceImpl();
	
	@Override
	public void execute() {
		BoardService boardService = new BoardServiceImpl();
		List<BoardVO> boards = new ArrayList<BoardVO>();
		boards = boardService.boardList();
		//System.out.println(boards);
		System.out.println("[ BOARD 목록 조회 결과 ]= = = = = = = = = = = = = = = = = = = = = = = = = = = =");
		int n = 1;
		for(BoardVO vo : boards) {
			System.out.println(vo);
			//System.out.printf("[ %-2d ] %-2d | %-5s | %-10s | %-13s\t | %-2d |\n", 
			//	n++, vo.getBId(), vo.getBWriter(), vo.getBWriteDate(), vo.getBTitle(), vo.getBHit());
		}
		System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
		
	}

}
