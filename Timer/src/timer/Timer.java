package timer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Timer {
	private int hours;
	private int minutes;
	private int seconds;
	
	/**
	 * Timer constructor. Takes 3 integers specifying hours, minutes, and seconds
	 * @param hours
	 * @param minutes
	 * @param seconds
	 */
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
	
	public void startTimer() {
		ScheduledExecutorService executor_service = Executors.newScheduledThreadPool(1);
		executor_service.scheduleAtFixedRate(this.decrementTimer(this, executor_service), 0, 1, TimeUnit.SECONDS);
	}
	
	/**
	 * Starts the timer, printing the current time left on the timer or "Done!" if the timer is at 00:00:00
	 */
	private Runnable decrementTimer(Timer t, ScheduledExecutorService executor_service) {
		Runnable timer_runnable = new Runnable() {
		    public void run() {
		    	System.out.println(t.toString());
				if (hours == 0 && minutes == 0 && seconds == 0) {
					System.out.println("Done!");
					executor_service.shutdown();
				}
				subtractSecond(t);
			};
		};
		return timer_runnable;
	}

	
	/**
	 * Subtract one second off the timer
	 * Precondition: timer is not at 00:00:00
	 * 		This is checked in startTimer
	 */
	private void subtractSecond(Timer t) {
		if (t.seconds > 0) {
			t.seconds = t.seconds - 1;
			return;
		}
		if (t.minutes > 0) {
			t.minutes = t.minutes - 1;
			t.seconds = 59;
			return;
		}
		t.hours = t.hours - 1;
		t.minutes = 59;
		t.seconds = 59;
	}
	
	/**
	 * Method to print the Timer with hours, minutes, and seconds in the format of HH:MM:SS
	 */
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
