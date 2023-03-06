package week8_Midterm;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProgramTest { // 메인 클래스

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);

		UserManagementProgram m = ctx.getBean("userManagementProgram", UserManagementProgram.class);
		m.chooseProgram(); // 메뉴 입력이 가능한 회원 관리 프로그램 실행

		ctx.close();
	}

}