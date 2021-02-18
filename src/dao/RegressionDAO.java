package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.RegResult;

public class RegressionDAO {
	//DB接続情報
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/Account";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";

	public List<RegResult> findAll() {
		List<RegResult> RegressionList = new ArrayList<>();

		//DB接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT ANALYSIS_NAME, STRAIGHT_INC, STRAIGHT_INTERCEPT, CORRELATION, DETERMINATION FROM REGRESSION";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			ResultSet rs = pStmt.executeQuery();

			//ArrayListに格納
			while (rs.next()) {
				String analysisName = rs.getString("ANALYSIS_NAME");
				double straightInc = rs.getDouble("STRAIGHT_INC");
				double straightIntercept = rs.getDouble("STRAIGHT_INTERCEPT");
				double correlation = rs.getDouble("CORRELATION");
				double determination = rs.getDouble("DETERMINATION");
				RegResult regResult = new RegResult(analysisName, straightInc, straightIntercept, correlation, determination);
				RegressionList.add(regResult);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return RegressionList;
	}

	public boolean create(RegResult regResult) {
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			//insert
			String sql = "insert into regression (ANALYSIS_NAME, STRAIGHT_INC, STRAIGHT_INTERCEPT, correlation, determination) VALUES(?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//?の値を設定
			pStmt.setString(1, regResult.getAnalysisName());
			pStmt.setDouble(2, regResult.getStraightInc());
			pStmt.setDouble(3, regResult.getStraightIntercept());
			pStmt.setDouble(4, regResult.getCorrelation());
			pStmt.setDouble(5, regResult.getDetermination());

			int result = pStmt.executeUpdate();
			if (result != 1) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}







