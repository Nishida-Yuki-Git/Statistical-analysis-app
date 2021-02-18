package test;

import dao.AccountDAO;
import model.Account;
import model.Login;

public class AccountDAOTest {
	public static void main(String[] args) {
		testFindByLogin1(); //ユーザーが見つかる場合のテスト
		//testFindByLogin2();
	}

	public static void testFindByLogin1() {
		Login login = new Login("takeda", "1234");
		AccountDAO dao = new AccountDAO();
		Account result = dao.findByLogin(login);
		if (result != null &&
			result.getUserId().equals("takeda") &&
			result.getPass().equals("1234") &&
			result.getMail().equals("takeda@gmail.com") &&
			result.getName().equals("武田樹") &&
			result.getAge() == 22) {
			System.out.println("1:成功");
		} else {
			System.out.println("1:失敗");
		}
	}

	public static void testFindByLogin2() {
		Login login = new Login("minato", "12345");
		AccountDAO dao = new AccountDAO();
		Account result = dao.findByLogin(login);
		if (result == null) {
			System.out.println("2:成功");
		} else {
			System.out.println("2:失敗");
		}
	}
}







