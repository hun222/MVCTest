package mvc04;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CommandCtrl")
public class CommandCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(CommandCtrl.class.getName());
    private final String logMsg = "logMsg------";
    private HashMap<String, Object> commandMap = new HashMap<>();
    
    @Override
    public void init() throws ServletException {
    	ListAction list = new ListAction();
    	WriteAction write = new WriteAction();
    	
    	commandMap.put("/list.sam", list);
    	commandMap.put("/write.sam", write);
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String context = request.getContextPath();
		String cmd = uri.substring(context.length());
		logger.info(logMsg + cmd);
		
		String view = null;
		try {
			CommandAction action = (CommandAction)commandMap.get(cmd);
			view = action.actionDo(request, response);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
