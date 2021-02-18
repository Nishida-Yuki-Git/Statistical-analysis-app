package linearRegression;

import java.util.List;

public class Dispersion {
	private double sX2;
	private double sY2;

	public double getSX2() { return this.sX2; }
	public double getSY2() { return this.sY2; }

	public void dispersionCalc(List<Double> xDevList, List<Double> yDevList) {
		double x = 0.0;
		double y = 0.0;
		for (int i = 0; i < xDevList.size(); i ++) {
			x += xDevList.get(i) * xDevList.get(i);
			y += yDevList.get(i) * yDevList.get(i);
		}
		this.sX2 = x / xDevList.size();
		this.sY2 = y / yDevList.size();
	}
}
