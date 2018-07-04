package mvc03;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Read {

	public String action(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("read action");
		// Business Logic
		
		request.setAttribute("su", 10);
		// move to view
		return "/mvc03/read.jsp";
	}

}
