
import java.util.*;
public class A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int s = sc.nextInt();
		int[] arr = new int[n];
		for(int i  =0 ;i<n;i++)
			arr[i] = sc.nextInt();
		Arrays.sort(arr);
		long ans = 0;
		int mid =n/2; 
		if(arr[mid] > s){
			for(int i = mid;i>=0;i--){
				if(arr[i] <= s)
					break;
				ans  = ans + arr[i] - s;
			}
		}
		else if(arr[mid] < s){
			for(int i = mid;i<n;i++){
				if(arr[i] >= s)
					break;
				ans = ans + s - arr[i];
			}
		}
		System.out.println(ans);
	}
}
