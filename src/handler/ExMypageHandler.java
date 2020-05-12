package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.ExAction;
import dao.CustomersDAO;
import vo.CustomersVO;

public class ExMypageHandler implements ExAction{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		HttpSession session = req.getSession();
		CustomersVO vo = (CustomersVO)session.getAttribute("emp");
		
		String id = vo.getId();
		String pass2 = req.getParameter("pass2");
		String phone = req.getParameter("phone");
		
	
		vo.setPass(pass2);
		vo.setPhone(phone);
		
		CustomersDAO dao = new CustomersDAO();
		
		dao.updateInfo(vo);
		
		
		return "./ExMypage.jsp";
		
		
		
		
		
		
		
	}

}
