package week8_Midterm;

public class User { // 회원 클래스

	String name;
	String phoneNum;
	String email;
	String school;
	String id;
	String password;
	boolean logIn = false;

	public void setName(String name) {
		this.name = name;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public void setID(String id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setLogIn(boolean logIn) {
		this.logIn = logIn;
	}

	public String getName() {
		return name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public String getSchool() {
		return school;
	}

	public String getID() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public boolean getLogIn() {
		return logIn;
	}

	public void resetUserInfo() { // 회원탈퇴 시 회원정보를 리셋하는 메서드
		name = null;
		phoneNum = null;
		email = null;
		school = null;
		id = null;
		password = null;
		logIn = false; // 회원탈퇴 시 logIn 정보는 false가 됨
	}
}
