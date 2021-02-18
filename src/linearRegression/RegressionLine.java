package linearRegression;

public class RegressionLine {
	private double inclination; //傾き
	private double intercept; //切片
	private double correlation; //相関係数
	private double determination; //決定係数

	public double getInclination() { return this.inclination; }
	public double getIntercept() { return this.intercept; }
	public double getCorrelation() { return this.correlation; }
	public double getDetermination() { return this.determination; }

	public void inclinationCalc(double sXY, double sX2) {
		double inc = sXY / sX2;
		this.inclination = inc;
	}
	public void interceptCalc(double xAve, double yAve, double sX2, double sXY) {
		double itc = yAve - ((sXY / sX2) * xAve);
		this.intercept = itc;
	}

	public void coefCalc(double sXY, double sX, double sY) {
		double r = sXY / (sX * sY);
		this.correlation = r;
		double rr = r * r;
		this.determination = rr;
	}
}



