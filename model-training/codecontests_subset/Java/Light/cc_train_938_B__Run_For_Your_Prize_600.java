import java.util.Scanner;

public class Prize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = input.nextInt();
		}
		double pi = 1;
		double pj = Math.pow(10, 6);
		int sum = 0;
		int max=0;
		for (int i = 0; i < arr.length; i++) {
			if (Math.abs(arr[i] - pi) < Math.abs(pj - arr[i])) {
				sum= (int) Math.abs(arr[i] - pi);
			} else {
				sum= (int) Math.abs(arr[i] - pj);
			}
			max=Math.max(sum, max);

		}
		System.out.println(max);
	}

}
