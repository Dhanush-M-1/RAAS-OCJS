import java.util.Scanner;

public class BearandRaspberry {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int c = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int profit = 0;
		for (int i = 0; i < arr.length-1; i++) {
			if(arr[i]>arr[i+1]) {
				int curr = arr[i]-arr[i+1]-c;
				profit = Math.max(profit, curr);
			}
		}
		System.out.println(profit);

	}

}