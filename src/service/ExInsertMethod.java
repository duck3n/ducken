package service;

import java.util.Map;

public class ExInsertMethod {
	
	private String id;
	private String name;
	private String password;
	private String confirmPassword;
	
	
	// get/set
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	
	
	
	
	// HaspMap : https://vaert.tistory.com/107
	
	// 유효성 검사
	// - 여러개의 필드에, 여러가지의 오류 검사를 수행해야 함
	// - 배열이 필요 -> HashMap
	
		// 비밀번호와 비밀번호확인의 일치 여부 체크
		public boolean checkPassEqual() {
			boolean X = false;		
			if(password.equals(confirmPassword)) {
				X = true;
			}
			return X;
		}
		
		// viewPage의 필드가 비어있는지 체크
		private void checkEmpty(Map<String, Boolean> errors, String fieldName, String fieldValue) {
			
			if( fieldValue == null || fieldValue.isEmpty() ) {
				errors.put(fieldName, Boolean.TRUE);
			}
			
		}
		
		
	// 유효성 검사 실행
	
	public void isValidate(Map<String, Boolean> errors, String fieldName, String fieldValue) {
		
		checkEmpty(errors, id, "id");
		checkEmpty(errors, name, "name");
		checkEmpty(errors, password, "password");
		checkEmpty(errors, confirmPassword, "confirmPassword");
		
	
		
		
	}
		
		
}
