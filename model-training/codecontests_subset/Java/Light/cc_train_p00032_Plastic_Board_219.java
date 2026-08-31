import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private Scanner sc;
	
	public static void main(String[] args) {
		new Main();
	}
	
	public Main() {
		sc = new Scanner(System.in);
		
		int r = 0;
		int l = 0;
		while (sc.hasNextLine() == true) {
			String[] params = sc.nextLine().split(",");
			
			int a = Integer.parseInt(params[0]);
			int b = Integer.parseInt(params[1]);
			int c = Integer.parseInt(params[2]);

			
			if ((a * a + b * b) == (c * c)) r++;
			else if (a == b) l++;
		}

		System.out.println(r);
		System.out.println(l);
	}
}