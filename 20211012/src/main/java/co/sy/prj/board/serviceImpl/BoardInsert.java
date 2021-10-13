package co.sy.prj.board.serviceImpl;

import java.util.Scanner;

import co.sy.prj.board.service.BoardService;
import co.sy.prj.board.service.BoardVO;
import co.sy.prj.comm.Command;

public class BoardInsert implements Command {
	private BoardService boardService = new BoardServiceImpl();
	private Scanner sc = new Scanner(System.in);
	@Override
	public void execute() {
		BoardVO board = new BoardVO();
		System.out.println("[ BOARD INSERT ] 를 진행하겠습니다. ");
		System.out.print("- 등록 하고자 하는 게시글의 작성자를 입력하세요 : ");
		board.setBWriter(sc.nextLine());
		System.out.print("- 등록 하고자 하는 게시글의 제목을 입력하세요 : ");
		board.setBTitle(sc.nextLine());
		System.out.print("- 등록 하고자 하는 게시글의 내용을 입력하세요 : ");
		board.setBContents(sc.nextLine());
		
		int n = boardService.boardInsert(board);
		if(n != 0) {
			System.out.println("- 성공적으로 게시글을 INSERT 하였습니다.");
		} else {
			System.out.println("- 게시글을 INSERT 하지 못하였습니다.");
		}
	}
}
