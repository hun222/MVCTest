package mvc02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SampleCnt extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SampleCnt----");
		
		// FrontController pattern : 모든 요청을 단 하나의 서블릿이 처리하는 형태
		String uri = request.getRequestURI();
		StringBuffer url = request.getRequestURL();
		String context = request.getContextPath();
		
		System.out.println("uri: "+uri);			//	/MVCTest/list.action
		System.out.println("url: "+url);			//	http://localhost:8081/MVCTest/list.action
		System.out.println("context: "+context);	//	/MVCTest
		
		String split[] = uri.split("/");
		String parse = split[2];
		System.out.println("split: "+parse);
		
		// ideal
		String cmd = uri.substring(context.length());
		System.out.println("substring: "+cmd);
		
		if(cmd.equals("/list.action")) {
			ListAction list = new ListAction();
			list.action(request,response);
		}else if(cmd.equals("/write.action")) {
			WriteAction write = new WriteAction();
			write.action(request,response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
