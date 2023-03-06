package week8_Midterm;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component // 컴포넌트 스캔으로 userManagementProgram() Bean 설정을 자동 생성
public class UserManagementProgram { // 기능들을 어셈블한 회원 관리 프로그램 클래스
	Scanner in = new Scanner(System.in);

	@Autowired // 의존 자동 주입
	User user;

	@Autowired
	SignUp signUp;

	@Autowired
	SignIn signIn;

	@Autowired
	ResetPassword resetPassword;

	@Autowired
	ChangePassword changePassword;

	// 자동 주입할 빈 객체를 printUserInfo로 지정하기 위해 한정자 Qualifier 사용
	@Autowired
	@Qualifier("printUserInfo")
	PrintUserInfo printUserInfo;

	@Autowired
	EditUserInfo editUserInfo;

	@Autowired
	DeleteUser deleteUser;

	public void setUser(User user) {
		this.user = user;
	}

	public void setSignUp(SignUp signUp) {
		this.signUp = signUp;
	}

	public void setSignIn(SignIn signIn) {
		this.signIn = signIn;
	}

	public void setResetPassword(ResetPassword resetPassword) {
		this.resetPassword = resetPassword;
	}

	public void setChangePassword(ChangePassword changePassword) {
		this.changePassword = changePassword;
	}

	public void setPrintUserInfo(PrintUserInfo printUserInfo) {
		this.printUserInfo = printUserInfo;
	}

	public void setEditUserInfo(EditUserInfo editUserInfo) {
		this.editUserInfo = editUserInfo;
	}

	public void setDeleteUser(DeleteUser deleteUser) {
		this.deleteUser = deleteUser;
	}

	private static int string2Int(String s) throws NumberFormatException { // string을 int로 바꿔줌, 정수가 아니라면 exception 실행
		int n = Integer.parseInt(s);
		return n;
	}

	public void chooseProgram() {
		System.out.println("-------------------------------------------");
		System.out.println("회원 관리 프로그램입니다.");

		int num = 0;
		while (num != 8) {
			System.out.println("\n1.회원가입 | 2.로그인 | 3.암호 재설정 | 4.암호 변경 | 5.회원 정보 조회 | 6.회원정보 수정 | 7.회원 탈퇴 | 8.종료");

			try {
				System.out.print("원하는 작업을 선택하세요 (숫자 1-8): ");
				// num = in.nextInt();
				num = string2Int(in.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("정수가 아닙니다."); // 입력값이 정수가 아니라면 exception 실행, 프린트문 출력, num을 0으로 설정
				num = 0;
			}

			switch (num) { // 숫자에 맞는 기능 실행 (조건 확인 후)
			case 1:
				if (!(user.getID() == null)) // ID가 null이 아니라면 이미 회원가입한 상태
					System.out.println("이미 회원가입을 하셨습니다. 다시 회원가입을 하고 싶으시다면 먼저 회원 탈퇴를 진행하세요.");
				else {
					System.out.println("다시 회원가입을 진행합니다.");
					signUp.startSignUp();
				}
				break;
			case 2:
				if (user.getLogIn()) // logIn 정보가 true라면 이미 로그인한 상태
					System.out.println("이미 로그인하셨습니다.");
				else if (user.getID() == null) // ID가 null이라면 회원가입을 먼저 해야함
					System.out.println("먼저 회원가입을 해주세요.");
				else {
					System.out.println("로그인을 진행합니다.");
					signIn.startSignIn();
				}
				break;
			case 3:
				if (!user.getLogIn()) // logIn 정보가 false라면 로그인 후 암호 재설정 등의 기능 사용 가능
					System.out.println("먼저 로그인을 해주세요.");
				else {
					System.out.println("암호를 재설정합니다.");
					resetPassword.startResetPassword();
				}
				break;
			case 4:
				if (!user.getLogIn())
					System.out.println("먼저 로그인을 해주세요.");
				else {
					System.out.println("암호를 변경합니다.");
					changePassword.startChangePassword();
				}
				break;
			case 5:
				if (!user.getLogIn())
					System.out.println("먼저 로그인을 해주세요.");
				else {
					System.out.println("회원 정보를 조회합니다.");
					printUserInfo.startPrintUserInfo();
				}
				break;
			case 6:
				if (!user.getLogIn())
					System.out.println("먼저 로그인을 해주세요.");
				else {
					System.out.println("회원 정보를 수정합니다. 아무것도 입력하지 않고 <Enter> 키를 누르시면 정보를 변경하지 않습니다.");
					editUserInfo.startEditUserInfo();
				}
				break;
			case 7:
				if (!user.getLogIn())
					System.out.println("먼저 로그인을 해주세요.");
				else {
					System.out.println("회원 탈퇴를 진행합니다.");
					deleteUser.startDeleteUser();
				}
				break;
			case 8:
				System.out.println("회원 관리 프로그램을 종료합니다.");
				break;
			default: // 1-8 사이의 숫자가 입력되지 않았을 경우
				System.out.println("1-8 사이의 숫자를 다시 입력하세요.");
			}
		}
	}

	UserManagementProgram() {
		System.out.println("회원 관리 프로그램입니다. 먼저 기능들을 하나씩 시뮬레이션 해보겠습니다.");
		System.out.println("기능: 회원가입, 로그인, 암호 재설정, 암호 변경, 회원 정보 조회, 회원정보 수정, 회원 탈퇴");
	}
}
