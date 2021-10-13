package co.sy.prj;

import co.sy.prj.menu.Menu;

public class MainApp {

	public static void main(String[] args) {
//		System.out.println("Hello ~~~~~~");
//		BoardService dao = new BoardServiceImpl();		// Service 호출.
//		List<BoardVO> list = new ArrayList<BoardVO>();	
//		list = dao.boardSelectList();
//		
//		for(BoardVO vo : list) {
//			System.out.println(vo.getBId() + " | " + vo.getBTitle());
//		}
//		
//		BoardVO vo = new BoardVO();
//		vo.setBId(2);
//		vo = dao.boardSelect(vo);
//		System.out.println(vo.getBContents());
//		
//		vo = new BoardVO();
//		vo.setBWriter("에비씨");
//		vo.setBTitle("Mybatis - Test글.");
//		vo.setBContents("Mybatis는 SqlMapper로 DBMS와 통신한다.");
//		int n = dao.boardInsert(vo);
//		if(n != 0 ) {
//			System.out.println("[ INSERT 성공 ]");
//			list = dao.boardSelectList();
//			for(BoardVO bo : list) {
//				System.out.println(bo.getBId() + " | " + bo.getBContents());
//			}
//		} else {
//			System.out.println("[ INSERT 실패 ]");
//		}
		// -============================ 여기서부터 Member ==================
		
//		List<MemberVO> list = new ArrayList<MemberVO>();
//		MemberService dao = new MemberServiceImpl();
//		list = dao.memberSelectList();
//		for(MemberVO member : list) {
//			System.out.println(member.getId() + " | " + member.getName());
//		}
//		System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = =");
//		BoardService bs = new BoardServiceImpl();
//		List<BoardVO> boards = new ArrayList<>();
//		boards = bs.boardSelectList();
//		for(BoardVO board : boards) {
//			System.out.println(board.getBId() + " | " + board.getBContents());
//		
//		
//		}
		// -============================= 여기서부터 Command ============================
		
		Menu menu = new Menu();
		menu.run();
	}
}
