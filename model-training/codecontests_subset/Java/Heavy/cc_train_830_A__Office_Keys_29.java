//package C830;


import java.util.*;
import java.util.Arrays;
public class D{
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		int end = scan.nextInt();
		int[] people = new int[n];
		for (int i = 0; i < n; i++)
			people[i] = scan.nextInt();
		int[] keys = new int[k];
		for (int i = 0; i < k; i++)
			keys[i] = scan.nextInt();
		Arrays.sort(people);
		Arrays.sort(keys);
		int min = Integer.MAX_VALUE;
		for (int i = n-1; i < k; i++)
		{
			int time = 0;
			int start = i-n+1;
			for (int j = 0; j < n; j++)
			{
				int key = keys[start+j];
				int dist = Math.abs(people[j]-key) + Math.abs(key-end);
				time = Math.max(time, dist);
			}
			min = Math.min(min, time);
		}
		System.out.println(min);
	}
}

