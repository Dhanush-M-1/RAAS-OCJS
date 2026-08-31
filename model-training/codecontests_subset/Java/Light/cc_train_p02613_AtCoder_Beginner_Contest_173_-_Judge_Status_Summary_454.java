import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int a[] = new int[4];
		for (int i=0;i<N;i++) {
			String temp = sc.next();
			if ("AC".equals(temp)) {
				a[0]++;
			} else if  ("WA".equals(temp)) {
				a[1]++;
			} else if("TLE".equals(temp)) {
				a[2]++;
			} else {
				a[3]++;
			}
		}
		System.out.println("AC x "+a[0]);
		System.out.println("WA x "+a[1]);
		System.out.println("TLE x "+a[2]);
		System.out.println("RE x "+a[3]);
	}
}