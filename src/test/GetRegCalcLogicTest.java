package test;

import java.util.List;

import model.GetRegCalcLogic;
import model.RegResult;

public class GetRegCalcLogicTest {
	public static void main(String[] args) {
		test1();
	}

	public static void test1() {
		GetRegCalcLogic bo = new GetRegCalcLogic();
		List<RegResult> RegressionList = bo.execute();
		for (RegResult regresult : RegressionList) {
			System.out.println(regresult.getAnalysisName());
			System.out.println(regresult.getStraightInc());
		}
	}
}
