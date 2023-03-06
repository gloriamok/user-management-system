package week8_Midterm;

import java.util.Scanner;

public class ChangePassword { // 암호 변경 클래스
	Scanner in = new Scanner(System.in);

	User user;

	public void setUser(User user) {
		this.user = user;
	}

	public void startChangePassword() {
		System.out.print("현재 암호를 입력하세요 : ");
		String password = in.nextLine();
		while (!password.equals(user.getPassword())) { // 입력한 암호가 저장된 암호와 같은지 확인
			System.out.print("암호가 맞지 않습니다. 다시 입력하세요 : ");
			password = in.nextLine();
		}

		// 암호 유효성 검증
		String input;
		boolean flag = true;
		while (flag) {
			System.out.print("새로운 암호를 입력하세요 (최소 6글자, 최대 16글자, 영어, 숫자, 특수기호 사용 가능) : ");
			input = in.nextLine();
			if (input.length() < 6 || input.length() > 16) {
				System.out.println("암호 길이는 최소 6글자, 최대 16글자입니다. 암호를 다시 입력하세요.");
			} else {
				boolean flag2 = true;
				for (int i = 0; i < input.length(); i++) {
					if (flag2 && input.substring(i, i + 1).matches("[\uAC00-\uD7A3\\s]")) {
						System.out.println("영어, 숫자, 특수기호만 사용 가능합니다. 암호를 다시 입력하세요.");
						flag2 = false;
					}
				}
				if (flag2) {
					flag = false;
					user.setPassword(input);
				}
			}
		}

		System.out.println("암호 변경이 완료되었습니다.");
	}

	ChangePassword() {
		System.out.println("\n암호를 변경합니다.");
	}
}
