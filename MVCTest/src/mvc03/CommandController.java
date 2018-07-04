package mvc03;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String context = request.getContextPath();
		
		String cmd = uri.substring(context.length());
		String view = null;
		if(cmd.equals("/read.do")) {
			Read read = new Read();
			view = read.action(request, response);
		}else if(cmd.equals("/delete.do")) {
			Delete delete = new Delete();
			view = delete.action(request, response);
		}else if(cmd.equals("/update.do")) {
			Update update = new Update();
			view = update.action(request, response);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
