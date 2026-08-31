import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] array = new int[4];
		for (int i = 0; i < n; i++) {
			switch (sc.next().charAt(0)) {
				case 'A':
					++array[0];
					break;
				case 'W':
					++array[1];
					break;
				case 'T':
					++array[2];
					break;
				case 'R':
					++array[3];
					break;
			}
		}
		System.out.println("AC x " + array[0]);
		System.out.println("WA x " + array[1]);
		System.out.println("TLE x " + array[2]);
		System.out.println("RE x " + array[3]);
	}
}
