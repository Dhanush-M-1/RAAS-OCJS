import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int n = in.nextInt();
		long sum1 = 0;
		long sum2 = 0;
		long sum3 = 0;
		for (int i = 0; i < n; i++) sum1 += in.nextInt();
		for (int i = 0; i < n - 1; i++) sum2 += in.nextInt();
		for (int i = 0; i < n - 2; i++) sum3 += in.nextInt();
		System.out.println(sum1 - sum2);
		System.out.println(sum2 - sum3);
		in.close();
	}

}