package mvc04;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListAction implements CommandAction {

	@Override
	public String actionDo(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		return "/mvc04/list.jsp";
	}

}
