import java.util.Arrays;
import java.util.Scanner;

public class BestGift {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[] genres = new int[m+1];
		Arrays.fill(genres, 0);
		/*
		if (n < 2) { //exception
			System.out.println("0");
			return;
		}
		*/
		while (in.hasNext()) {
			int curr = in.nextInt();
			//System.out.println("curr = " + curr);
			genres[curr]++;
		}

		int sum = 0;
		for (int i = 0; i < m; i++) {
			int tempSum = 0;
			for (int j = i+1; j < m+1; j++) {
				tempSum += genres[j];
			}
			sum += tempSum * genres[i];
		}

		System.out.println(sum);

	}
	
}
