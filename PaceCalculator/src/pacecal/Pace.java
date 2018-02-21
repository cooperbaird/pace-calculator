package pacecal;

/**
 * The minutes and seconds component of a runner's pace
 * 
 * @author cooperbaird
 */
public class Pace {
	private final int minutes;
	private final double seconds;
	
	/**
	 * @param minutes the minutes component of the pace
	 * @param seconds the seconds component of the pace
	 */
	public Pace(int minutes, double seconds) {
		this.minutes = minutes;
		this.seconds = seconds;
	}

	/**
	 * @return the pace minutes
	 */
	public int getMinutes() {
		return minutes;
	}

	/**
	 * @return the pace seconds
	 */
	public double getSeconds() {
		return seconds;
	}
	
	/**
	 * @param decimalPlaces the number of decimal places to round to
	 * @return the rounded seconds
	 */
	public double getRoundedSeconds(int decimalPlaces) {
		return RunningCalculations.roundToDecimal(seconds, decimalPlaces);
	}
	
	/**
	 * @return the pace only in seconds
	 */
	public double getPaceInSeconds() {
		return minutes*60 + seconds;
	}
}
