package model;

import java.util.List;

import dao.RegressionDAO;

public class GetRegCalcLogic {
	public List<RegResult> execute() {
		RegressionDAO dao = new RegressionDAO();
		List<RegResult> RegressionList = dao.findAll();
		return RegressionList;
	}
}
