import java.util.Scanner;

public class TheBestGift {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] array = new int[n];
		int m = input.nextInt();
		int[] genres = new int[m];
		int sum = 0;
		int result = 0;
		for (int i = 0; i < n; ++i) {
			array[i] = input.nextInt();

			switch (array[i]) {

			case 1:
				genres[0]++;
				break;

			case 2:
				genres[1]++;
				break;

			case 3:
				genres[2]++;
				break;

			case 4:
				genres[3]++;
				break;

			case 5:
				genres[4]++;
				break;

			case 6:
				genres[5]++;
				break;

			case 7:
				genres[6]++;
				break;

			case 8:
				genres[7]++;
				break;

			case 9:
				genres[8]++;
				break;

			case 10:
				genres[9]++;
				break;
			}
		}
		input.close();

		for (int i = 0; i < m; ++i) {

			for (int j = i + 1; j < m; ++j) {
				sum += genres[j];

			}
			result += genres[i] * (sum);
			sum = 0;
		}
		
		System.out.println(result);

	}

}
