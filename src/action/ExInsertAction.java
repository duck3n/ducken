package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomersDAO;

public class ExInsertAction implements ExAction{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		CustomersDAO dao = new CustomersDAO();
		
		
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		String name = req.getParameter("name");
		String confirmpass = req.getParameter("confirmPass");
		
		if(id==null || id.equals("")) {
			
		}
		return confirmpass;
		
		
		
		
	}

}
