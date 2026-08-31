import java.util.Scanner;

public class B938 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		int minDistFrom500000 = Integer.MAX_VALUE;
		int x = -1;
		int maxValLessThan500000 = Integer.MIN_VALUE;
		int minValGreaterThan500000 = Integer.MAX_VALUE;
		int index1 = -1;
		int index2 = -1;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			if (arr[i] <= 500000 && arr[i] > maxValLessThan500000) {
				maxValLessThan500000 = arr[i];
				index1 = i;
			}
			if (arr[i] > 500000 && arr[i] < minValGreaterThan500000) {
				minValGreaterThan500000 = arr[i];
				index2 = i;
			}
			if (Math.abs(arr[i] - 500000) < minDistFrom500000) {
				minDistFrom500000 = Math.abs(arr[i] - 500000);
				x = arr[i];
			}
		}
		if (arr[n - 1] <= 500000) {
			System.out.println(arr[n - 1] - 1);
			System.exit(0);
		}
		if (arr[0] > 500000) {
			System.out.println(1000000 - arr[0]);
			System.exit(0);
		}
		if ((minValGreaterThan500000 - maxValLessThan500000) < ((index1 > 0)?arr[index1 - 1]:(maxValLessThan500000-1))
				|| (minValGreaterThan500000 - maxValLessThan500000) < ((index2 < (n - 1))?arr[index2 + 1]:(1000000-minDistFrom500000))) {
			if (Math.abs(500000 - minValGreaterThan500000) > Math.abs(500000 - maxValLessThan500000))
				System.out.println(x - 1);
			else{
				if(1000000 - x>499999)
					System.out.println("499999");
				else
				System.out.println(1000000 - x);
				}
			System.exit(0);
		}
//		if (x <= 500000) {
//			System.out.println(1000000 - x);
//		} else {
//			System.out.println(x - 1);
//		}
		if(maxValLessThan500000-1>1000000-minValGreaterThan500000)
			System.out.println(maxValLessThan500000-1);
		else System.out.println(1000000-minValGreaterThan500000);
	}

}