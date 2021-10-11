package co.sy.prj.board.command;

import java.util.Scanner;

import co.sy.prj.board.service.BoardVO;

public class BoardDelete implements Command {

	private Scanner scb = new Scanner(System.in);
	@Override
	public void execute() {
		// 게시글 삭제.
		BoardVO vo = new BoardVO();
		System.out.println("* * * * * * * * * * * * * *");
		System.out.println("삭제할 글의 번호를 입력하세요 : ");
		vo.setBId(scb.nextInt()); scb.nextLine();
		int n = dao.boardDelete(vo);
		
		if(n != 0) {
			System.out.println("[ 정상적으로 DELETE 되었습니다. ]");
		} else {
			System.out.println("[ DELETE 에 실패하였습니다. ] ");
		}
	}

}
