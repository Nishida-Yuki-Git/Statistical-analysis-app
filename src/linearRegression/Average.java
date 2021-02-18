package linearRegression;

import java.util.List;

public class Average { //平均計算クラス
	private double xAve;
	private double yAve;

	public double getXAve() { return this.xAve; }
	public double getYAve() { return this.yAve; }

	public void averageCalc(List<Double> xNumList, List<Double> yNumList) {
		double xTotal = 0.0;
		double yTotal = 0.0;
		for (int i = 0; i < xNumList.size(); i ++) {
			xTotal += xNumList.get(i);
			yTotal += yNumList.get(i);
		}
		this.xAve = xTotal / xNumList.size();
		this.yAve = yTotal / yNumList.size();
	}
}