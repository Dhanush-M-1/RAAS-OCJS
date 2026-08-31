import java.util.*;
public class BearAndRaspberry {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int c = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		int t = 0;
		for(int i=0;i<n-1;i++) {
			t = Math.max(t, arr[i]-arr[i+1]-c);
		}
		System.out.println(t);
	}

}
