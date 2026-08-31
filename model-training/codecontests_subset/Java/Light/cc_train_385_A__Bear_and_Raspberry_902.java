import java.io.*;
import java.util.*;
public class id1 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n =	 sc.nextInt();
		int c = sc.nextInt();
		int[] arr = new int[n];
		for (int i=0; i < arr.length; i++){
			arr[i] = sc.nextInt();
		}
		int[] output = new int[n - 1];
		for (int i=0; i < arr.length - 1; i++){
			output[i] = arr[i] - c - arr[i+1];
		}
		int max = 0;
		for (int i=0; i < output.length; i++){
			if (max < output[i]){
				max = output[i];
			}
		}
		System.out.println(max);
	}
}
