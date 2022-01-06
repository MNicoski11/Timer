package timer;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit; 

public class Start {
	public static void main(String[] args) {		
		Scanner input = new Scanner(System.in);
		
		
		while(true) {			
			System.out.println("Instructions: \n"
					+ "Enter \"t\" to start a timer\n"
					+ "Enter \"s\" to start a stopwatch\n"
					+ "Enter \"q\" to quit");
			
			String option = input.next();
			if (option.equals("t")) {
				System.out.println("Enter the number of hours: ");
				int h = input.nextInt();
				System.out.println("Enter the number of minutes: ");
				int m = input.nextInt();
				System.out.println("Enter the number of seconds: ");
				int s = input.nextInt();
				Timer time = new Timer(h,m,s);
				System.out.println(time.toString());
				while(true) {
					System.out.println("Enter \"s\" to start the timer or \"b\" to go back to start.");
					String option2 = input.next();
					
					if (option2.equals("s")) {
						//start timer
						//System.out.println(System.currentTimeMillis()/1000);
						time.startTimer();
					}
					else if (option2.equals("b")) {
						break;
					}
					else {
						System.out.println("Invalid input.");
						continue;
					}
				}
			}
			else if (option.equals("s")) {
				System.out.println(118/60);
			}
			else if (option.equals("q")) {
				break;
			}
			else {
				System.out.println("Unrecognizable input. Enter \"t\" for setting a timer and \"s\" for starting a stopwatch.");
			}
		}
		input.close();
		
	}
}
