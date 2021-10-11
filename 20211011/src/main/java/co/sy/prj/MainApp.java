package co.sy.prj;

import co.sy.prj.comm.BoardMenu;

public class MainApp {

	public static void main(String[] args) {
		// 게시판 Project.
//		BoardListCommand blist = new BoardListCommand();
//		blist.execute();
//		
//		Command command = new BoardSelect();
//		command.execute();
		
		BoardMenu boardMenu = new BoardMenu();
		boardMenu.run();
	}
}
