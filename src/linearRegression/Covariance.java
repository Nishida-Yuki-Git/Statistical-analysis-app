package linearRegression;

import java.util.List;

public class Covariance {
	private double sXY;

	public double getSXY() { return this.sXY; }

	public void covarianceCalc(List<Double> xDevList, List<Double> yDevList) {
		double devTotal = 0.0;
		for (int i = 0; i < xDevList.size(); i ++) {
			devTotal += xDevList.get(i) * yDevList.get(i);
		}
		this.sXY = devTotal / xDevList.size();
	}
}
