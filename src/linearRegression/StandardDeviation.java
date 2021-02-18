package linearRegression;

public class StandardDeviation {
	private double sX;
	private double sY;

	public double getSX() { return this.sX; }
	public double getSY() { return this.sY; }

	public void standardDeviationCalc(double sX2, double sY2) {
		this.sX = Math.sqrt(sX2);
		this.sY = Math.sqrt(sY2);
	}
}
