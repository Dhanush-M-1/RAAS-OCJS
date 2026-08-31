//package leto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class force_424 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		int p = scan.nextInt();
		int []men = new int [n];
		for(int i = 0;i<n;i++){
			men[i] = scan.nextInt();
		}
		Arrays.sort(men);
		int []key = new int [k];
		for(int i = 0;i<k;i++){
			key[i] = scan.nextInt();
		}
		Arrays.sort(key);
		int min = Integer.MAX_VALUE;
		for(int i = 0;i<k-n+1;i++){
			int max = Integer.MIN_VALUE;
			for(int j = i;j<i+n;j++){
				max = Math.max(max, Math.abs(men[j-i]-key[j])+Math.abs(p-key[j]));
			}
			min = Math.min(min, max);
		}
		System.out.println(min);
	}
}
