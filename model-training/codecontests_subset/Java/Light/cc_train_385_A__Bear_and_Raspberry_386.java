import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), c = sc.nextInt(), v[] = new int[n], may = 0;
//precio de barril de miel en kilogramos dfram
		for (int i = 0; i < n; i++) {
			v[i] = sc.nextInt();
		}
		for (int i = 1; i < n; i++) {
			may = Math.max(may, v[i - 1] - v[i] - c);
		}
		if (may < 0) {
			System.out.println(0);
		} else {
			System.out.println(may);
		}

	}

}
