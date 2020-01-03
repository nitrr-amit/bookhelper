package bookhelper.pojo;

public class User {
  public User(String name, String mobile_no, String email_id, String password) {
		super();
		Name = name;
		this.mobile_no = mobile_no;
		this.email_id = email_id;
		this.password = password;
	}
  public User(String email_id, String password) {
		super();
	
		this.email_id = email_id;
		this.password = password;
	}

  private String Name=null;
  private String mobile_no=null;
  private String email_id=null;
  private String password=null;
	public User() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
