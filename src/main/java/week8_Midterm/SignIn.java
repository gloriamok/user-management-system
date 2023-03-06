package week8_Midterm;

import java.util.Scanner;

public class SignIn { // 로그인 클래스
	Scanner in = new Scanner(System.in);

	User user;

	public void setUser(User user) {
		this.user = user;
	}

	public void startSignIn() {
		System.out.print("아이디를 입력하세요 : ");
		String id = in.nextLine();
		while (!id.equals(user.getID())) { // 입력한 아이디가 저장된 아이디와 같은지 확인
			System.out.print("아이디가 맞지 않습니다. 다시 입력하세요 : ");
			id = in.nextLine();
		}

		System.out.print("암호를 입력하세요 : ");
		String password = in.nextLine();
		while (!password.equals(user.getPassword())) { // 입력한 암호가 저장된 암호와 같은지 확인
			System.out.print("암호가 맞지 않습니다. 다시 입력하세요 : ");
			password = in.nextLine();
		}
		user.logIn = true; // 로그인에 성공했을 때 logIn을 true로 만들어줌
		System.out.println("로그인에 성공했습니다.");
	}

	SignIn() {
		System.out.println("\n프로그램을 사용하시려면 로그인하세요.");
	}
}
