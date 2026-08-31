import java.util.Scanner;

public class Main {

	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int k = scan.nextInt();
		int[] line = {1, 1, 1, 2, 1, 2, 1, 5, 2,
				2, 1, 5, 1, 2, 1, 14, 1, 5, 1, 5, 2, 2, 1, 15, 2, 2, 5, 4, 1, 4, 1, 51};
		System.out.println(line[k-1]);
 	}

}