package co.sy.prj.board.command;

import co.sy.prj.board.service.BoardService;
import co.sy.prj.board.serviceImpl.BoardServiceImpl;
import co.sy.prj.mybatis.BoardMybatisService;

public interface Command {
	//public BoardService dao = new BoardServiceImpl();	// private은 상속이안됨.
	public BoardService dao = new BoardMybatisService();
	public void execute();
}
