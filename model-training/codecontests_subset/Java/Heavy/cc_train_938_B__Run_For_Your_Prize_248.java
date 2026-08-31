import java.util.Scanner;

public class B938_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		int maxValLessThan500000 = 1;
		int minValGreaterThan500000 = 1000000;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			if (arr[i] <= 500000 && arr[i] > maxValLessThan500000)
				maxValLessThan500000 = arr[i];
			if (arr[i] > 500000 && arr[i] < minValGreaterThan500000)
				minValGreaterThan500000 = arr[i];
		}
		System.out.println(maxValLessThan500000-1>1000000-minValGreaterThan500000?maxValLessThan500000-1:1000000-minValGreaterThan500000);
	}

}