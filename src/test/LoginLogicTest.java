package test;

import model.Login;
import model.LoginLogic;

public class LoginLogicTest {
	public static void main(String[] args) {
		testExecute1(); //ログイン成功時のテスト
		testExecute2(); //失敗時
	}
	public static void testExecute1() {
		Login login = new Login("yuki", "gyudon176");
		LoginLogic bo = new LoginLogic();
		boolean result = bo.execute(login);
		if (result) {
			System.out.println("1:成功");
		} else {
			System.out.println("1:失敗");
		}
	}
	public static void testExecute2() {
		Login login = new Login("yuki", "gyudon175");
		LoginLogic bo = new LoginLogic();
		boolean result = bo.execute(login);
		if (!result) {
			System.out.println("1:成功");
		} else {
			System.out.println("1:失敗");
		}
	}
}
