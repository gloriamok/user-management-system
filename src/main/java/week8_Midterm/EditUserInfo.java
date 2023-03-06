package week8_Midterm;

import java.util.Scanner;

public class EditUserInfo { // 회원정보 수정
	Scanner in = new Scanner(System.in);

	User user;

	public void setUser(User user) {
		this.user = user;
	}

	public void startEditUserInfo() {
		System.out.print("이름 : ");
		String input = in.nextLine();
		if (!input.equals("")) // 콘솔에 아무것도 입력하지 않으면 정보를 변경하지 않음
			user.setName(input);

		// System.out.print("휴대폰번호 : ");
		// input = in.nextLine();
		// if (!input.equals(""))
		// user.setPhoneNum(input);

		// 휴대폰번호 유효성 검증
		boolean flag = true;
		while (flag) {
			System.out.print("휴대폰번호 (xxx-xxxx-xxxx 형식으로 입력) : ");
			input = in.nextLine();
			if (input.equals("")) // 콘솔에 아무것도 입력하지 않으면 정보를 변경하지 않음
				flag = false;
			else if (input.matches("^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$")) {
				// 번호 형식 : 첫번째 번호는 010,011,016~019만 가능, 중간 번호는 digit 3~4개, 마지막 번호는 digit 4개만 가능
				flag = false;
				user.setPhoneNum(input);
			} else
				System.out.println("잘못된 번호이거나 잘못된 형식입니다. 다시 입력하세요.");
		}

		// System.out.print("E-mail : ");
		// input = in.nextLine();
		// if (!input.equals(""))
		// user.setEmail(input);

		// 이메일 유효성 검증
		flag = true;
		while (flag) {
			System.out.print("E-mail : ");
			input = in.nextLine();
			if (input.equals("")) // 콘솔에 아무것도 입력하지 않으면 정보를 변경하지 않음
				flag = false;
			else if (input.matches("\\w+@\\w+\\.\\w+(\\.\\w+)?")) {
				// 이메일 형식 : 영어/숫자 @ 영어/숫자 . 영어/숫자 (. 영어/숫자) 만 가능
				flag = false;
				user.setEmail(input);
			} else
				System.out.println("잘못된 이메일이거나 잘못된 형식입니다. 다시 입력하세요.");
		}

		System.out.print("학교명 : ");
		input = in.nextLine();
		if (!input.equals("")) // 콘솔에 아무것도 입력하지 않으면 정보를 변경하지 않음
			user.setSchool(input);

		System.out.println("회원정보 수정이 완료되었습니다.");
	}

	EditUserInfo() {
		System.out.println("\n회원정보를 수정합니다. 아무것도 입력하지 않고 <Enter> 키를 누르시면 정보를 변경하지 않습니다.");
	}
}
