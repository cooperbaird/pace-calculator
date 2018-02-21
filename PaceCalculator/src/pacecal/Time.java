package pacecal;

/**
 * The hours, minutes, and seconds components of a runner's time
 * 
 * @author cooperbaird
 */
public class Time {
	private final int hours, minutes;
	private final double seconds;
	
	/**
	 * @param hours the hours component of the time
	 * @param minutes the minutes component of the time
	 * @param seconds the seconds component of the time
	 */
	public Time(int hours, int minutes, double seconds) {
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
	}

	/**
	 * @return the hours
	 */
	public int getHours() {
		return hours;
	}

	/**
	 * @return the minutes
	 */
	public int getMinutes() {
		return minutes;
	}

	/**
	 * @return the seconds
	 */
	public double getSeconds() {
		return seconds;
	}
	
	/**
	 * @param decimalPlaces the number of decimal places to round to
	 * @return the seconds rounded
	 */
	public double getRoundedSeconds(int decimalPlaces) {
		return RunningCalculations.roundToDecimal(seconds, decimalPlaces);
	}
	
	/**
	 * @return the total time in seconds
	 */
	public double getTimeInSeconds() {
		return hours*3600 + minutes*60 + seconds;
	}
}
