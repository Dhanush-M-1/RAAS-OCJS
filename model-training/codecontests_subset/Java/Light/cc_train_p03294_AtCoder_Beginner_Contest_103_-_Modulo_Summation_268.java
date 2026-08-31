import java.util.Scanner;
public class Main{

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int seisu = scan.nextInt();
		int[] array = new int[seisu];

		for(int i=0;i<seisu;i++) {
			array[i] = scan.nextInt();
		}

		int sum = 0;
		for(int i=0;i<seisu;i++) {

			sum += (array[i]-1);
		}

			System.out.println(sum);
		scan.close();

	}

}
