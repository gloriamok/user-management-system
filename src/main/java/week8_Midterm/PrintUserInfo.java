package week8_Midterm;

public class PrintUserInfo { // 회원정보 조회 클래스
	User user;

	public void setUser(User user) {
		this.user = user;
	}

	public void startPrintUserInfo() { // 주요 회원 정보 출력
		System.out.println("이름 : " + user.getName());
		System.out.println("휴대폰번호 : " + user.getPhoneNum());
		System.out.println("E-mail : " + user.getEmail());
		System.out.println("학교명 : " + user.getSchool());
	}

	public void startPrintShortUserInfo() { // 이름, 이메일만 출력
		System.out.println("이름 : " + user.getName());
		System.out.println("E-mail : " + user.getEmail());
	}

	PrintUserInfo() {
		System.out.println("\n회원정보를 조회합니다.");
	}
}