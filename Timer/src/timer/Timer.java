package timer;


public class Timer {
	private int hours;
	private int minutes;
	private int seconds;
	
	public Timer(int hours, int minutes, int seconds) {
		if (seconds >= 60) {
			int addminutes = seconds/60;
			this.seconds = seconds - addminutes * 60;
			minutes = minutes + addminutes;
		}
		else {
			this.seconds = seconds;
		}
		if (minutes >= 60) {
			int addhours = minutes/60;
			this.minutes = minutes - addhours * 60;
			hours = hours + addhours;
		}
		else {
			this.minutes = minutes;
		}
		if (hours > 99) {
			this.hours = 99;
		}
		else {
			this.hours = hours;
		}
		
	}
	@Override
	public String toString() {
		String shours = "";
		String sminutes = "";
		String sseconds = "";
		if (hours < 10) {
			shours = "0" + hours + ":";
		}
		else {
			shours = hours + ":";
		}
		if (minutes < 10) {
			sminutes = "0" + minutes + ":";
		}
		else {
			sminutes = minutes + ":";
		}
		if (seconds < 10) {
			sseconds = "0" + seconds;
		}
		else {
			sseconds = Integer.toString(seconds);
		}
		return shours + sminutes + sseconds;
	}
}
