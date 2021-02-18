package model;

import dao.AccountDAO;

public class EntryLogic {
	public boolean execute(Entry entry) {
		AccountDAO dao = new AccountDAO();
		Account account = dao.entrySave(entry);
		return account != null;
	}
}
