import java.io.*;
import java.util.*;

public class runforyourprize {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		int max_sec = 0;
		for (int i = 0; i < n; i++) {
			max_sec = Math.max(max_sec, Math.min(Math.abs(arr[i] - 1), Math.abs(arr[i] - 1000000)));
		}
		System.out.println(max_sec);
	}
}
