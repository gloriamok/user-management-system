package week8_Midterm;

import java.util.Scanner;

public class SignUp { // 회원가입 클래스
	Scanner in = new Scanner(System.in);

	User user;

	public void setUser(User user) {
		this.user = user;
	}

	public void startSignUp() {
		System.out.print("이름 : ");
		user.setName(in.nextLine());

		// 휴대폰번호 유효성 검증
		String input;
		boolean flag = true;
		while (flag) {
			System.out.print("휴대폰번호 (xxx-xxxx-xxxx 형식으로 입력) : ");
			input = in.nextLine();
			if (input.matches("^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$")) {
				// 번호 형식 : 첫번째 번호는 010,011,016~019만 가능, 중간 번호는 digit 3~4개, 마지막 번호는 digit 4개만 가능
				flag = false;
				user.setPhoneNum(input);
			} else
				System.out.println("잘못된 번호이거나 잘못된 형식입니다. 다시 입력하세요.");
		}
		// user.setPhoneNum(in.nextLine());

		// 이메일 유효성 검증
		flag = true;
		while (flag) {
			System.out.print("E-mail : ");
			input = in.nextLine();
			if (input.matches("\\w+@\\w+\\.\\w+(\\.\\w+)?")) {
				// 이메일 형식 : 영어/숫자 @ 영어/숫자 . 영어/숫자 (. 영어/숫자) 만 가능
				flag = false;
				user.setEmail(input);
			} else
				System.out.println("잘못된 이메일이거나 잘못된 형식입니다. 다시 입력하세요.");
		}

		// user.setEmail(in.nextLine());

		System.out.print("학교명 : ");
		user.setSchool(in.nextLine());

		// 아이디 유효성 검증
		flag = true;
		while (flag) {
			System.out.print("사용할 아이디를 입력하세요 (영문으로 시작하며 최대 8글자, 영어(대소문자 무관), 숫자 사용 가능) : ");
			input = in.nextLine();
			if (input.length() > 8) { // 아이디 최대 길이인 8글자를 초과했을 때
				System.out.println("아이디 최대 길이를 초과했습니다(최대 8글자). 아이디를 다시 입력하세요.");
			} else if (input.length() == 0 || input.substring(0, 1).matches("[^a-zA-z]")) {
				// 아이디가 영문이 아닌 문자로 시작할 경우
				System.out.println("아이디는 영문으로 시작해야합니다. 아이디를 다시 입력하세요.");
			} else {
				boolean flag2 = true;
				for (int i = 0; i < input.length(); i++) {
					if (flag2 && input.substring(i, i + 1).matches("[^a-zA-Z0-9]")) {
						// 아이디의 각 문자가 영어, 숫자가 아닐 경우
						System.out.println("영어(대소문자 무관), 숫자만 사용 가능합니다. 아이디를 다시 입력하세요.");
						flag2 = false;
					}
				}
				if (flag2) {
					flag = false;
					user.setID(input);
				}
			}
		}

		// 암호 유효성 검증
		flag = true;
		while (flag) {
			System.out.print("사용할 암호를 입력하세요 (최소 6글자, 최대 16글자, 영어, 숫자, 특수기호 사용 가능) : ");
			input = in.nextLine();
			if (input.length() < 6 || input.length() > 16) { // 암호가 6글자 미만이거나 16글자 이상일 경우
				System.out.println("암호 길이는 최소 6글자, 최대 16글자입니다. 암호를 다시 입력하세요.");
			} else {
				boolean flag2 = true;
				for (int i = 0; i < input.length(); i++) {
					if (flag2 && input.substring(i, i + 1).matches("[\uAC00-\uD7A3\\s]")) {
						// 암호의 각 문자가 영어, 숫자, 특수기호가 아닐 경우
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

		System.out.println("회원가입이 완료되었습니다.");
	}

	SignUp() {
		System.out.println("\n회원가입을 진행합니다.");
	}

}
