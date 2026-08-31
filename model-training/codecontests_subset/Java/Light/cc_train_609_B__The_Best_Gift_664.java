

import java.util.Arrays;
import java.util.Scanner;

public class B {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] genres = new int[m+1];
		Arrays.fill(genres, 0);
		for(int i = 0;i<n;i++){
			int index = sc.nextInt();
			genres[index]++;
		}
		long res = 0;
		for(int i = 1;i<=m;i++){
			res += genres[i]*(n-genres[i]);
		}
//		for(int i = 0;i<=m;i++){
//			System.out.print(genres[i] + " ");
//		}
//		System.out.println(res);
		System.out.println(res/2);
	}
}
