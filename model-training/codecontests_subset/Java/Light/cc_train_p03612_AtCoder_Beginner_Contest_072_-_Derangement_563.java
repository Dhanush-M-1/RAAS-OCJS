import java.io.*;
import java.math.*;
import java.util.*;
public class Main { 

	public static void main(String[] args) { //Look for adjacent outliers first
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int[] arr = new int[N];
		int ans = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = input.nextInt();
		}
		for (int i = 0; i < N-1; i++) {
			if (arr[i]==i+1&&arr[i+1]==i+2) {
				ans++;
				int tempA = arr[i];
				int tempB = arr[i+1];
				arr[i] = tempB;
				arr[i+1]=tempA;
			}
		}
		for (int i = 0; i < N; i++) {
			if (arr[i]==i+1) ans++;
		}
		System.out.println(ans);
	}
}