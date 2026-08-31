import java.util.Scanner;

public class Main {

	public Main() {
		
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int a = in.nextInt();
		int b = in.nextInt();
		int hours = 0;
		if (a >= b) {
			while (a > 0) {
				hours++;
				a--;
				if (hours % b == 0) {
					a++;
				}
			}
		} else {
			hours = a;
		}
		System.out.println(hours);
		in.close();
	}
}