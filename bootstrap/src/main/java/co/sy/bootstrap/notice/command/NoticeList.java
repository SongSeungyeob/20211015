package co.sy.bootstrap.notice.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.sy.bootstrap.comm.Command;
import co.sy.bootstrap.notice.service.NoticeService;
import co.sy.bootstrap.notice.serviceImpl.NoticeServiceImpl;

public class NoticeList implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// 공지사항 처리.
		NoticeService noticeDao = new NoticeServiceImpl();
		request.setAttribute("notices", noticeDao.noticeSelectList());
		return "notice/noticeList";
	}

}
