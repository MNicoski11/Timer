package timer;
import java.util.Scanner; 

public class Start {
	public static void main(String[] args) {
		System.out.println("Instructions: \n"
				+ "Enter \"t\" to start a timer\n"
				+ "Enter \"s\" to start a stopwatch\n"
				+ "Enter \"q\" to quit");
		while(true) {
			
			
			//for reading user input
			Scanner input = new Scanner(System.in);
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
				System.out.println("Enter \"s\" to start.");
				//System.out.println(System.currentTimeMillis()/1000);
				
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
		
	}
}
