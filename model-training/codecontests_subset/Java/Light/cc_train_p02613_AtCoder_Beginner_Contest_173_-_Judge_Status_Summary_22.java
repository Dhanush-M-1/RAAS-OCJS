import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] c = new int[4];
		int n = scan.nextInt();
		while(n-->0) {
			String s = scan.next();
			if(s.equals("AC"))
				c[0]++;
			else if(s.equals("WA"))
				c[1]++;
			else if(s.equals("TLE"))
				c[2]++;
			else 
				c[3]++;
		}
		System.out.println("AC x "+c[0]);
		System.out.println("WA x "+c[1]);
		System.out.println("TLE x "+c[2]);
		System.out.println("RE x "+c[3]);
	}

}
