package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.exam.connection.OracleXEConnection;

import vo.CustomersVO;

public class CustomersDAO {

	StringBuffer sb = new StringBuffer();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Connection conn = null;

	public CustomersDAO() {

		conn = OracleXEConnection.getInstance().getConnection();
	}

	// 사원 정보 등록 메소드
	public void insertCustomers(CustomersVO vo) {

		// sql문 선언
		sb.setLength(0);
		sb.append("insert into customers ");
		sb.append("values (?, ?, ?, ?, sysdate, ?, ?) ");

		// sql문 처리
		try {
			// sql문을 그릇에 담기
			pstmt = conn.prepareStatement(sb.toString());

			// ? 처리
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPass());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getLev());
			pstmt.setString(5, vo.getGender());
			pstmt.setString(6, vo.getPhone());

			// sql문 실행
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// insertCustomers 종료

	// 사원 여부 및 권한 체크 : id, pass, (A, B)
	public int customerCheck(String id, String pass, String lev) {

		int result = 0;

		sb.setLength(0);
		sb.append("select * from customers ");
		sb.append("where id = ? ");

		try {

			// 그릇에 sql문 담기
			pstmt = conn.prepareStatement(sb.toString());

			// ? 처리
			pstmt.setString(1, id);

			// ResultSet
			rs = pstmt.executeQuery();

			if(rs.next()) {
	            if(pass.equals(rs.getString("pass")) && lev.equals("A") && lev.equals(rs.getString("lev"))) {
	               result = 2;		// 운영자
	               
	               }else if(pass.equals(rs.getString("pass")) && lev.equals("B") && lev.equals(rs.getString("lev"))) {
	                  result = 3;	// 사원
	               }
	               else {
	                  result = 0;
	            }
	         }else {
	            result = -1;
	         }

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;

	}// customerCheck 종료
	
	
	
	// login -> 사원 정보를 id(pk)를 통해 DBMS에서 가져오기!
	public CustomersVO getCustomer(String id) {
		
		sb.setLength(0);
		sb.append("select * from customers ");
		sb.append("where id = ? ");
		
		CustomersVO vo = null;
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			
			String pass = rs.getString("pass");
			String name = rs.getString("name");
			String lev = rs.getString("lev");
			String gender = rs.getString("gender");
			String enter = rs.getString("enter");
			String phone = rs.getString("phone");
			
			vo = new CustomersVO(id, pass, name, lev, enter, gender, phone);
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}// getCustomer 종료

	
	// 사원 개인정보 수정 - 비밀번호, 전화번호 
	public void updateInfo(CustomersVO vo) {
		sb.setLength(0);
		sb.append("update customers ");
		sb.append("set pass = ?, enter = sysdate, phone = ? ");
		sb.append("where id = ? ");
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			
			pstmt.setString(1, vo.getPass());
			pstmt.setString(2, vo.getPhone());
			pstmt.setString(3, vo.getId());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//updateInfo 종료
	
	
	// 전체 사원 정보 보기
	public ArrayList<CustomersVO> getAllCustomers(){
		ArrayList<CustomersVO> list = new ArrayList<CustomersVO>();
		
		sb.setLength(0);
		sb.append("select * from customers ");
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("id");
				String pass = rs.getString("pass");
				String name = rs.getString("name");
				String lev = rs.getString("lev");
				String enter = rs.getString("enter");
				String gender = rs.getString("gender");
				String phone = rs.getString("phone");
				
				CustomersVO vo = new CustomersVO(id, pass, name, lev, enter, gender, phone);
				
				list.add(vo);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
		
	}// getAllCustomers 종료
	
	
	
	
	
	
}
