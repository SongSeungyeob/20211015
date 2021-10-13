package co.sy.prj.board.serviceImpl;

import java.util.Scanner;

import co.sy.prj.board.service.BoardService;
import co.sy.prj.board.service.BoardVO;
import co.sy.prj.comm.Command;
import co.sy.prj.menu.Menu;

public class BoardUpdate implements Command {
	private BoardService boardService = new BoardServiceImpl();
	@Override
	public void execute() {
		String Name = Menu.NAME;
		String Author = Menu.AUTHOR;
		
		BoardVO board = new BoardVO();
		BoardVO res = new BoardVO();
		System.out.println("[ BOARD UPDATE ] 를 진행하겠습니다. 게시글은 '내용'만 수정이 가능합니다. ");
		while (true) {
			System.out.print("- 수정 하고자 하는 게시글의 번호를 입력하세요(수정을 종료하시려면 '0'번을 입력하세요) : ");
			int Input = Menu.sc.nextInt(); Menu.sc.nextLine();
			if(Input == 0) {
				System.out.println("[ BOARD UPDATE를 종료하겠습니다. ]");
				return;
			} 
			board.setId(Input); 
			res = boardService.boardSelect(board);
			if (res == null) {
				System.out.println("[ ERROR ] : 존재하지 않는 글입니다. 다시 입력해주세요.");
			} else if(!res.getWriter().equals(Name)) {
				System.out.println("[ ERROR ] : " + Name + "님께서 작성하신 글이 아니기에 수정하실 수 없습니다. 다시 입력해 주세요.");
			} 
			else {
				break;
			}
		}
		
		System.out.print("- 수정 하고자 하는 게시글의 내용을 입력하세요 : ");		
		//board.setBContents(Menu.sc.nextLine());
		board.setContents(Menu.sc.nextLine());
		
		int n = boardService.boardUpdate(board);
		if(n != 0) {
			System.out.println("- 성공적으로 게시글을 UPDATE 하였습니다.");
		} else {
			System.out.println("- 게시글을 UPDATE 하지 못하였습니다.");
		}
	}
}
