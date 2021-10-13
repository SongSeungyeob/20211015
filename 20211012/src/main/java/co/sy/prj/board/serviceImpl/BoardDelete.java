package co.sy.prj.board.serviceImpl;

import java.util.Scanner;

import co.sy.prj.board.service.BoardService;
import co.sy.prj.board.service.BoardVO;
import co.sy.prj.comm.Command;

public class BoardDelete implements Command {
	private BoardService boardService = new BoardServiceImpl();
	private Scanner sc = new Scanner(System.in);
	@Override
	public void execute() {
		BoardVO board = new BoardVO();
		System.out.println("[ BOARD DELETE ] 를 진행하겠습니다. ");
		System.out.print("- 삭제하고자 하는 게시글의 번호를 입력하세요 : ");
		board.setBId(sc.nextInt()); sc.nextLine();
		int n = boardService.boardDelete(board);
		if(n != 0) {
			System.out.println("- 성공적으로 게시글을 DELETE 하였습니다.");
		} else {
			System.out.println("- 게시글을 DELETE 하지 못하였습니다.");
		}
	}

}
