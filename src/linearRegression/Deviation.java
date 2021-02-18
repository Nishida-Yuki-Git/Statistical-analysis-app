package linearRegression;

import java.util.ArrayList;
import java.util.List;

public class Deviation {
	private List<Double> xDevList;
	private List<Double> yDevList;

	public Deviation() {
		this.xDevList = new ArrayList<Double>();
		this.yDevList = new ArrayList<Double>();
	}

	public List<Double> getXDevList() { return this.xDevList; }
	public List<Double> getYDevList() { return this.yDevList; }

	public void deviationCalc(List<Double> xNumList, List<Double> yNumList, double xAve, double yAve) {
		for (int i = 0; i < xNumList.size(); i ++) {
			this.xDevList.add(xNumList.get(i) - xAve);
			this.yDevList.add(yNumList.get(i) - yAve);
		}
	}
}
