package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.ExAction;
import dao.CustomersDAO;
import service.ExLoginService;
import vo.CustomersVO;

public class ExLoginHandler implements ExAction{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		ExLoginService els = new ExLoginService(); // DB 호출 -> result로 접근권한을 int 형태로 반환한 상태
		
		CustomersDAO dao = new CustomersDAO();
		
		String viewPage = null;
		
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		String lev = req.getParameter("lev");
		
		int result = els.login(id, pass, lev);
		
		if(result == 2 || result == 3) {
			
			CustomersVO vo = dao.getCustomer(id);
			
			HttpSession session = req.getSession();
			
			session.setAttribute("emp", vo);
			session.setAttribute("result", 	result);
			
			viewPage = "ExMain.jsp";
		}
		else {
			viewPage = "ExLogin.jsp";
			req.setAttribute("message", "로그인 거부 : 입력 내용을 확인하세요");
			
		}
		
		return viewPage;
		
		
		
		
		
	}

}
