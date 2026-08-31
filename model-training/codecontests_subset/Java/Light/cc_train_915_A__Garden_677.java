import java.util.*;

public class ER36A {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++){
			arr[i] = scan.nextInt();
		}
		int ans = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++){
			if(k % arr[i] == 0){
				ans = Math.min(ans, k/arr[i]);
			}
		}
		System.out.println(ans);
	}
}
