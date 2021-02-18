package model;

import java.util.List;

import dao.RegressionDAO;
import linearRegression.Average;
import linearRegression.Covariance;
import linearRegression.Deviation;
import linearRegression.Dispersion;
import linearRegression.RegressionLine;
import linearRegression.StandardDeviation;

public class PostRegCalcLogic {
	public void execute(String analysisName, List<Double> xNumList, List<Double> yNumList) {
		//単回帰分析
		Average ave = new Average(); //平均計算クラス
		Deviation dev = new Deviation(); //偏差計算クラス
		Dispersion disp = new Dispersion(); //分散計算クラス
		StandardDeviation sd = new StandardDeviation(); //標準偏差計算クラス
		Covariance co = new Covariance(); //共分散クラス
		RegressionLine rl = new RegressionLine(); //回帰直線クラス

		ave.averageCalc(xNumList, yNumList); //平均計算メソッド
		dev.deviationCalc(xNumList, yNumList, ave.getXAve(), ave.getYAve()); //偏差計算メソッド
		disp.dispersionCalc(dev.getXDevList(), dev.getYDevList()); //分散計算メソッド
		sd.standardDeviationCalc(disp.getSX2(), disp.getSY2()); //標準偏差計算メソッド
		co.covarianceCalc(dev.getXDevList(), dev.getYDevList()); //共分散計算メソッド
		rl.inclinationCalc(co.getSXY(), disp.getSX2()); //回帰直線の傾き計算メソッド
		rl.interceptCalc(ave.getXAve(), ave.getYAve(), disp.getSX2(), co.getSXY()); //回帰直線の切片計算メソッド
		rl.coefCalc(co.getSXY(), sd.getSX(), sd.getSY()); //係数計算メソッド

		double straightInc = rl.getInclination(); //回帰直線の傾き
		double straightIntercept = rl.getIntercept(); //回帰直線の切片
		double correlation = rl.getCorrelation(); //相関係数
		double determination = rl.getDetermination(); //決定係数

		RegressionDAO dao = new RegressionDAO();
		RegResult regResult = new RegResult(analysisName, straightInc, straightIntercept, correlation, determination);
		dao.create(regResult);
	}
}





