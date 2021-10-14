package co.sy.prj.board.serviceImpl;

import co.sy.prj.board.service.BoardService;
import co.sy.prj.board.service.BoardVO;
import co.sy.prj.comm.Command;
import co.sy.prj.menu.Menu;

public class BoardSelect implements Command {
	private BoardService boardService = new BoardServiceImpl();
	@Override
	public void Execute() {
		BoardVO board = new BoardVO();
		System.out.println("[ BOARD 게시글 조회 창 ]= = = = = = = = = = = = =");
		System.out.print("- 조회하고자 하는 게시글의 번호를 입력하세요 : ");
		int Id = Menu.sc.nextInt(); Menu.sc.nextLine();
		board.setBId(Id); 
		board = boardService.boardSelect(board);
		
		if(board == null) {
			System.out.println("- 존재하지 않는 게시글 입니다.");
		} else {
			System.out.println("- No        : " + board.getBId());
			System.out.println("- WRITER    : " + board.getBWriter());
			System.out.println("- WriteDate : " + board.getBWriteDate());
			System.out.println("- Title     : " + board.getBTitle());
			System.out.println("- Contents  : " + board.getBContents());
			System.out.println("- HitUp     : " + board.getBHit());
			System.out.println("= = = = = = = = = = = = = = = = = = = = =");
			boardService.boardHitUpdate(Id);
		}
	}

}
