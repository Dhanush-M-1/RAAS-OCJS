import java.util.Scanner;

public class BearRaspberry {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++){
			arr[i] = scan.nextInt();
		}
		long ans = 0;
		for(int i = 0; i < n-1; i++){
			ans = Math.max(ans, arr[i]-arr[i+1]-k);
		}
		System.out.println(ans);
	}
}
