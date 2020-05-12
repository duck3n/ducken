package vo;

public class CustomersVO {
	
	private String id;
	private String pass;
	private String name;
	private String lev;
	private String enter;
	private String gender;
	private String phone;
	private int result;

	
	public CustomersVO() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	// all data
	public CustomersVO(String id, String pass, String name, String lev, String enter, String gender, String phone) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.lev = lev;
		this.enter = enter;
		this.gender = gender;
		this.phone = phone;
	}
	

	
	// without enter
	public CustomersVO(String id, String pass, String name, String lev, String gender, String phone) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.lev = lev;
		this.gender = gender;
		this.phone = phone;
	}
	
	

	
	


	public CustomersVO(String id, String pass, String lev, int result) {
		super();
		this.id = id;
		this.pass = pass;
		this.lev = lev;
		this.result = result;
	}



	// get/set
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLev() {
		return lev;
	}

	public void setLev(String lev) {
		this.lev = lev;
	}

	public String getEnter() {
		return enter;
	}

	public void setEnter(String enter) {
		this.enter = enter;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}



	public int getResult() {
		return result;
	}



	public void setResult(int result) {
		this.result = result;
	}
	
	
	
	
	
	
}
