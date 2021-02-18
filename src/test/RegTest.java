package test;

import java.util.ArrayList;
import java.util.List;

import model.GetRegCalcLogic;
import model.PostRegCalcLogic;
import model.RegResult;

public class RegTest {
	public static void main(String[] args) {
		String analysisName = "こんにちは";
		List<Double> xNumList = new ArrayList<>();
		List<Double> yNumList = new ArrayList<>();
		xNumList.add(1.0);
		xNumList.add(2.0);
		xNumList.add(2.0);
		xNumList.add(3.0);
		xNumList.add(4.0);
		xNumList.add(6.0);
		xNumList.add(4.0);
		xNumList.add(9.0);
		xNumList.add(8.0);
		xNumList.add(4.0);

		yNumList.add(3.0);
		yNumList.add(4.0);
		yNumList.add(12.0);
		yNumList.add(10.0);
		yNumList.add(3.0);
		yNumList.add(7.0);
		yNumList.add(1.0);
		yNumList.add(8.0);
		yNumList.add(23.0);
		yNumList.add(19.0);

		PostRegCalcLogic bo = new PostRegCalcLogic();
		bo.execute(analysisName, xNumList, yNumList);

		GetRegCalcLogic bo2 = new GetRegCalcLogic();
		List<RegResult> RegressionList = bo2.execute();
		for (RegResult regresult : RegressionList) {
			System.out.println(regresult.getAnalysisName());
			System.out.println(regresult.getDetermination());
		}
	}
}
