package co.sy.prj.board.command;

import java.util.Scanner;

import co.sy.prj.board.service.BoardVO;

public class BoardUpdate implements Command {

	private Scanner scb = new Scanner(System.in);
	@Override
	public void execute() {
		// 게시글 수정.
		BoardVO vo = new BoardVO();
		System.out.println("* * * * * * * * * * * * * * * *");
		System.out.print("변경할 글의 번호를 입력하세요 : ");
		vo.setBId(scb.nextInt()); scb.nextLine();
		System.out.println("변경할 글의 내용을 입력하세요. ");
		vo.setBContents(scb.nextLine());
		
		int n = dao.boardUpdate(vo);
		if(n != 0) {
			System.out.println("[ 정상적으로 UPDATE 되었습니다. ]");
		} else {
			System.out.println("[ UPDATE에 실패하였습니다. ]");
		}
	}
}
