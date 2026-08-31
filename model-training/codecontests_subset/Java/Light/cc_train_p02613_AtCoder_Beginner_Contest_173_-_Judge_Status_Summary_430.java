import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] x = new int[4];
		for(int i = 0; i < N; i++) {
			String S = sc.next();
			if(S.equals("AC"))
				x[0]++;
			else if(S.equals("WA"))
				x[1]++;
			else if(S.equals("TLE"))
				x[2]++;
			else
				x[3]++;
		}
		System.out.println("AC x " + x[0]);
		System.out.println("WA x " + x[1]);
		System.out.println("TLE x " + x[2]);
		System.out.println("RE x " + x[3]);
	}

}