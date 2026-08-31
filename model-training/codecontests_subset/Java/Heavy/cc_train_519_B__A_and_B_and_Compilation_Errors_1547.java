import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Achilles
 *
 * Jan 2, 2020
 */
public class Solution {

	private static final Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		
		int n = scan.nextInt();
		
		int[] arr = new int[n];
		int[] arr1 = new int[n-1];
		int[] arr2 = new int[n-2];
		
		for(int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		for(int i = 0; i < n-1; i++) {
			arr1[i] = scan.nextInt();
		}
		for(int i = 0; i < n-2; i++) {
			arr2[i] = scan.nextInt();
		}
		findError(arr, arr1, arr2);

	}
	static void findError(int[] arr, int[] arr1, int[] arr2) {
		
		Arrays.sort(arr);
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		int first = 0;
		int second = 0;
		
		boolean isFirst = false;
		boolean isSecond = false;
		
		for(int i = 0; i < arr1.length; i++) {
			if(arr[i] != arr1[i]) {
				first = arr[i];
				isFirst = true;
				break;
			}
		}
		if(!isFirst) {
			first = arr[arr.length-1];
		}
		
		for(int i = 0; i < arr2.length; i++) {
			if(arr1[i] != arr2[i]) {
				second = arr1[i];
				isSecond = true;
				break;
			}
		}
		if(!isSecond) {
			second = arr1[arr1.length-1];
		}
		
		System.out.println(first);
		System.out.println(second);
	}

}
