import java.util.Arrays;
import java.util.Scanner;

public class elections {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[]arr = new int[n];
		int sumB = 0;
		for(int i = 0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
			sumB += arr[i];
		}
		Arrays.sort(arr);
		int ans = arr[n-1];
		int sumA = 0;
		while(true) {
			sumA = 0;
			for(int i = 0; i<arr.length;i++) {
				sumA+=(ans-arr[i]);
			}
			if(sumA>sumB) {
				System.out.println(ans);
				return;
			}else {
				ans++;
			}
		}

	}

}
