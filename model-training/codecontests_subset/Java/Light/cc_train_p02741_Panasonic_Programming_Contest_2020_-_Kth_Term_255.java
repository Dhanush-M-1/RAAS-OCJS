import java.util.Scanner;

public class Main {

	private static int data[] = {1 , 1, 1, 2, 1, 2, 1, 5, 2, 2, 1, 5, 1, 2, 1, 14, 1, 5, 1, 5, 2, 2, 1, 15, 2, 2, 5, 4, 1, 4, 1, 51};

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int k = scan.nextInt();
		System.out.println(data[k-1]);
	}

}

