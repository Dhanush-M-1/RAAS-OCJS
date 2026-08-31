import java.util.Arrays;
import java.util.Scanner;


public class buddy {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int w = sc.nextInt();
		int per = sc.nextInt();
		
		double needed = n*(per/100.0);
		
		if(w >= needed) {
			System.out.println("0");
			
		}
		else {
			System.out.println((int)Math.ceil(needed-w));
		}
		
	}
}
