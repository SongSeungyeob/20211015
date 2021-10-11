package co.sy.prj.board.command;

import java.util.Scanner;

import co.sy.prj.board.service.BoardVO;

public class BoardInsert implements Command {
	private BoardVO vo = new BoardVO();
	private Scanner scb = new Scanner(System.in);
	
	// dao 객체는 Interface에서 상속받아서 사용한다.
	@Override
	public void execute() {
		System.out.println("* * * * * * * * * * * * * * *");
		System.out.print("게시글 작성자를 입력하세요 : ");
		vo.setBWriter(scb.nextLine());
		
		System.out.print("게시글 제목을 입력하세요 : ");
		vo.setBTitle(scb.nextLine());
		
		System.out.println("게시글 내용을 입력하세요. ");
		vo.setBContents(scb.nextLine());
		int n = dao.boardInsert(vo);
		if(n != 0) {
			System.out.println("정상적으로 등록 되었습니다.");
		} else {
			System.out.println("등록에 실패하였습니다.");
		}
	}

}
