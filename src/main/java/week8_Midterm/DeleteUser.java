package week8_Midterm;

import java.util.Scanner;

public class DeleteUser { // 회원탈퇴 클래스
	Scanner in = new Scanner(System.in);

	User user;

	public void setUser(User user) {
		this.user = user;
	}

	public void startDeleteUser() {
		System.out.print("정말 탈퇴를 진행하시겠습니까? (y나 Y를 입력하시면 회원 탈퇴가 진행됩니다.) : ");
		String answer = in.nextLine();
		if (answer.equals("y") || answer.equals("Y")) { // y나 Y를 입력하면 회원 정보 리셋됨
			user.resetUserInfo();
			System.out.println("회원 탈퇴가 완료되었습니다.");
		} else
			System.out.println("회원 탈퇴가 취소되었습니다.");
	}

	DeleteUser() {
		System.out.println("\n회원 탈퇴를 진행합니다.");
	}
}
