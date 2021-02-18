package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.Entry;
import model.Login;

public class AccountDAO {
	//DB接続に使用する情報
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/Account";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	public Account findByLogin(Login login) {
		Account account = null;

		//DBに接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			//SELECT文を準備
			String sql = "SELECT USER_ID, PASS, MAIL, NAME, AGE FROM ACCOUNT WHERE USER_ID = ? AND PASS = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//他のファイルからloginに格納されたuserIdとpassで、ユーザーを検索する
			pStmt.setString(1, login.getUserId());
			pStmt.setString(2, login.getPass());

			//実行し、結果を取得
			ResultSet rs = pStmt.executeQuery();

			//一致したユーザーが存在した場合、Accountインスタンスを作成
			if (rs.next()) {
				String userId = rs.getString("USER_ID");
				String pass = rs.getString("PASS");
				String mail = rs.getString("MAIL");
				String name = rs.getString("NAME");
				int age = rs.getInt("AGE");
				//Account.javaに、ユーザーの情報を渡す
				account = new Account(userId, pass, mail, name, age);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return account;
	}

	public Account entrySave(Entry entry) {
		Account account = null;
		//DBに接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "INSERT INTO ACCOUNT VALUES(?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, entry.getUserId());
			pStmt.setString(2, entry.getPass());
			pStmt.setString(3, entry.getMail());
			pStmt.setString(4, entry.getName());
			pStmt.setInt(5, entry.getAge());

			int i = pStmt.executeUpdate();
			System.out.println("処理件数" + i);

			account = new Account(entry.getUserId(), entry.getPass(), entry.getMail(), entry.getName(), entry.getAge());

			//全データ出力
			String sql2 = "SELECT * FROM ACCOUNT";
			PreparedStatement pStmt2 = conn.prepareStatement(sql2);
			ResultSet rs = pStmt2.executeQuery();
			int dataCount = 0;
			while (rs.next()) {
				dataCount ++;
				System.out.println("-----------------");
				System.out.println("ユーザー名: " + rs.getString("USER_ID"));
				System.out.println("パスワード: " + rs.getString("PASS"));
				System.out.println("メールアドレス: " + rs.getString("MAIL"));
				System.out.println("姓名: " + rs.getString("NAME"));
				System.out.println("年齢: " + rs.getInt("AGE"));
				System.out.println("-----------------");
			}
			System.out.println(dataCount + "件のユーザーが格納されています。");
		} catch (SQLException e) {
			System.out.println("SQL処理でエラーが発生");
			return null;
		}
		return account;
	}
}