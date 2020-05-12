package service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import com.exam.connection.ConnectionProvider;

import dao.CustomersDAO;
import vo.CustomersVO;

public class ExLoginService {


	CustomersDAO dao = new CustomersDAO();
	
	int result = 0;

	public int login(String id, String pass, String lev) {

		try {
			Connection conn = ConnectionProvider.getConnection();
			
			result = dao.customerCheck(id, pass, lev);
			
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		

	}

}
