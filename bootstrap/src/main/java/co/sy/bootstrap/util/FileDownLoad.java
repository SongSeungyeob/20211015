package co.sy.bootstrap.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * File Download Class. */
@WebServlet("/FileDownLoad")
public class FileDownLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FileDownLoad() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String ofileName = request.getParameter("ofileName");	// 파일명
		String pfileName = request.getParameter("pfileName");	// 물리 파일명
		
		// Make FileDownload Logic.
		File file = null;
		InputStream in = null;
		OutputStream out = null;
	
		try {
			file = new File(pfileName);			// 물리위치에서 파일을 선택하기
			in = new FileInputStream(file);		// 선택한 파일을 읽기
			ofileName = new String(ofileName.getBytes("UTF-8"),"ISO-8859-1");	// 파일 한글명 처리. 브라우저 별로 다르다.
			
			response.setContentType("text/html; charset=UTF-8");
			response.setHeader("Content-Disposition", "attachment;filename=\\" + ofileName);	
			
			out = response.getOutputStream();	// response 객체로 초기화.
			byte buffer[] = new byte[(int)file.length()];	// 메모리에 파일을 담음.
			int len = 0;
			while((len = in.read(buffer)) > 0) {			// 실제 다운로드.
				out.write(buffer, 0, len);
			}
			in.close();
			out.flush();
			out.close();
			request.setAttribute("message", "파일이 성공적으로 다운로드 되었습니다.");
		} catch(Exception e) {
			e.printStackTrace();
		} 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
