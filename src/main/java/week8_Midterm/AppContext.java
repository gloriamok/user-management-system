package week8_Midterm;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "week8_Midterm" })
public class AppContext { // 빈 설정 클래스
	// @Bean // 컴포넌트 스캔으로 인해 주석 처리
	// public UserManagementProgram userManagementProgram() {
	// UserManagementProgram m = new UserManagementProgram();
	// m.setUser(user()); // 의존 자동 주입으로 인해 주석 처리
	// m.setSignUp(signUp());
	// m.setSignIn(signIn());
	// m.setResetPassword(resetPassword());
	// m.setChangePassword(changePassword());
	// m.setPrintUserInfo(printUserInfo());
	// m.setEditUserInfo(editUserInfo());
	// m.setDeleteUser(deleteUser());
	// return m;
	// }

	@Bean
	public SignUp signUp() {
		SignUp s = new SignUp();
		s.setUser(user());
		s.startSignUp();
		return s;
	}

	@Bean
	public SignIn signIn() {
		SignIn s = new SignIn();
		s.setUser(user());
		s.startSignIn();
		return s;
	}

	@Bean
	public ResetPassword resetPassword() {
		ResetPassword r = new ResetPassword();
		r.setUser(user());
		r.startResetPassword();
		return r;
	}

	@Bean
	public ChangePassword changePassword() {
		ChangePassword c = new ChangePassword();
		c.setUser(user());
		c.startChangePassword();
		return c;
	}

	// 자동 주입할 빈 객체를 printUserInfo로 지정하기 위해 한정자 Qualifier 사용
	@Bean
	@Qualifier("printUserInfo")
	public PrintUserInfo printUserInfo1() {
		PrintUserInfo p = new PrintUserInfo();
		p.setUser(user());
		p.startPrintUserInfo();
		return p;
	}

	@Bean
	public PrintUserInfo printUserInfo2() {
		PrintUserInfo p = new PrintUserInfo();
		p.setUser(user());
		p.startPrintShortUserInfo();
		return p;
	}

	@Bean
	public EditUserInfo editUserInfo() {
		EditUserInfo e = new EditUserInfo();
		e.setUser(user());
		e.startEditUserInfo();
		return e;
	}

	@Bean
	public DeleteUser deleteUser() {
		DeleteUser d = new DeleteUser();
		d.setUser(user());
		d.startDeleteUser();
		return d;
	}

	@Bean
	public User user() {
		User u = new User();
		return u;
	}

}
