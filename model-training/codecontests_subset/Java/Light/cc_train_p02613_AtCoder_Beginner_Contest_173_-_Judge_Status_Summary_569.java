import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int a[] = new int [4];
		int n; n = in.nextInt();
		String s;
		for (int i = 0; i < n; i++) {
			s = in.next();
			if (s.equals("AC"))	a[0]++;
			if (s.equals("WA"))	a[1]++;
			if (s.equals("TLE"))a[2]++;
			if (s.equals("RE"))	a[3]++;
		}
		System.out.println("AC x " + a[0]);
		System.out.println("WA x " + a[1]);
		System.out.println("TLE x " + a[2]);
		System.out.println("RE x " + a[3]);
	}
}
