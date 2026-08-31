import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		boolean nashel1 = false;
		boolean nashel2 = false;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int[] arr1 = new int[n - 1];
		int[] arr2 = new int[n - 2];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 0; i < n - 1; i++) {
			arr1[i] = sc.nextInt();
		}
		for (int i = 0; i < n - 2; i++) {
			arr2[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		for (int i = 0; i < n - 1; i++) {
			if (arr[i] != arr1[i]) {
				System.out.println(arr[i]);
				nashel1=true;
				break;
			}
		}
		if(!nashel1)
		{
			System.out.println(arr[n-1]);
		}
		for (int i = 0; i < n - 2; i++) {
			if (arr1[i] != arr2[i]) {
				System.out.println(arr1[i]);
				nashel2=true;
				break;
			}
		}
		if(!nashel2)
		{
			System.out.println(arr1[n-2]);
		}
	}
}