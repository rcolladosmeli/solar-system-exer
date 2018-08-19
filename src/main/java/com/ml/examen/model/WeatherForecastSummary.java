package com.ml.examen.model;

public class WeatherForecastSummary {

	private int rainPeriods;
	private int optimalPeriods;
	private int droughtPeriods;
	private int normalPeriods;
	private int maxRainDay;
	
	
	public int getRainPeriods() {
		return rainPeriods;
	}
	public void setRainPeriods(int rainPeriods) {
		this.rainPeriods = rainPeriods;
	}
	public int getOptimalPeriods() {
		return optimalPeriods;
	}
	public void setOptimalPeriods(int optimalPeriods) {
		this.optimalPeriods = optimalPeriods;
	}
	public int getDroughtPeriods() {
		return droughtPeriods;
	}
	public void setDroughtPeriods(int droughtPeriods) {
		this.droughtPeriods = droughtPeriods;
	}
	public int getNormalPeriods() {
		return normalPeriods;
	}
	public void setNormalPeriods(int normalPeriods) {
		this.normalPeriods = normalPeriods;
	}
	public int getMaxRainDay() {
		return maxRainDay;
	}
	public void setMaxRainDay(int maxRainDay) {
		this.maxRainDay = maxRainDay;
	}
}
