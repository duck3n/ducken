package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ExAction {
	
	
	public String execute(HttpServletRequest req, HttpServletResponse resp);
	
}
