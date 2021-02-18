package test;

import dao.AccountDAO;
import model.Account;
import model.Entry;

public class AccountDAOEntryTest {
	public static void main(String[] args) {
		testEntry();
	}

	public static void testEntry() {
		Entry entry = new Entry("takeda", "1234", "takeda@gmail.com", "武田樹", 22);
		AccountDAO dao = new AccountDAO();
		Account result = dao.entrySave(entry);
		if (result != null) {
			System.out.println("ユーザー登録成功");
		} else {
			System.out.println("ユーザー登録失敗");
		}
	}
}
