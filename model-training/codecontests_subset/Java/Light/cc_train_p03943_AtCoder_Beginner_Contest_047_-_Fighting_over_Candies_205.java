import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int[] candyPack = {sc.nextInt(), sc.nextInt(), sc.nextInt()};

		Arrays.sort(candyPack);

		if((candyPack[0] + candyPack[1]) == candyPack[2]) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

		sc.close();
	}
}
