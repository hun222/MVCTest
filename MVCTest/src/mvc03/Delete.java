package mvc03;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Delete {

	public String action(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("delete action");
		
		request.setAttribute("chk", 1);
		return "/mvc03/delete.jsp";
	}

}
