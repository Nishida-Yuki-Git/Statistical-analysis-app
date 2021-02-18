package model;

import java.io.Serializable;

public class RegResult implements Serializable {
	private String analysisName;
	private double straightInc;
	private double straightIntercept;
	private double correlation;
	private double determination;

	public RegResult() {}
	public RegResult(String analysisName, double straightInc, double straightIntercept, double correlation, double determination) {
		this.analysisName = analysisName;
		this.straightInc = straightInc;
		this.straightIntercept = straightIntercept;
		this.correlation = correlation;
		this.determination = determination;
	}

	public String getAnalysisName() { return analysisName; }
	public double getStraightInc() { return straightInc; }
	public double getStraightIntercept() { return straightIntercept; }
	public double getCorrelation() { return correlation; }
	public double getDetermination() { return determination; }

}











