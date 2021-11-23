package co.sy.bootstrap.comm;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.sy.bootstrap.comm.main.Buttons;
import co.sy.bootstrap.main.Login;
import co.sy.bootstrap.main.MainCommand;
import co.sy.bootstrap.main.LoginCheck;
import co.sy.bootstrap.main.Logout;
import co.sy.bootstrap.notice.command.NoticeList;

/**
 * Main Controller
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<>();
	
    public FrontController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainCommand());			// 시작 하는 곳.
		map.put("/noticeList.do", new NoticeList());	// 공지사항 목록
		map.put("/buttons.do", new Buttons());
		map.put("/login.do", new Login());
		map.put("/loginCheck.do", new LoginCheck());
		map.put("/logout.do", new Logout());
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String page = uri.substring(contextPath.length());
		
		Command command = map.get(page);
		String viewPage = command.run(request, response);
		
		if(!viewPage.endsWith(".do")) {
			if(viewPage.startsWith("ajax")) {
				// ajax에 대한 처리구문.
				response.setCharacterEncoding("UTF-8");
				response.setContentType("html/text; charset=UTF-8");
				response.getWriter().append(viewPage.substring(5));
				return;
			}
			
			if(viewPage.endsWith(".jsp")) {	// Tiles를 사용하지 않을 경우 뒤에 .jsp를 붙인다.
				viewPage = "WEB-INF/views/" + viewPage;
			} else {
				viewPage += ".tiles";				
			}
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
