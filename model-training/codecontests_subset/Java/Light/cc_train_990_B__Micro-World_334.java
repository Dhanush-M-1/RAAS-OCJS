//package pack;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class first
{	
	public static Scanner sc = new Scanner(System.in);
	static int T;
	static int N, M, K;
	
	public static void main(String[] args) {
		N = sc.nextInt();
		K = sc.nextInt();
		List<Integer> lst = new ArrayList<>();
		int[] freq = new int[1000006];
		for (int i = 0; i < N; i++) {
			int v = sc.nextInt();
			if (freq[v] == 0) {
				lst.add(v);
			}
			freq[v]++;
		}
		
		Collections.sort(lst);
		
		int ans = N;
		for (int i = 1; i < lst.size(); i++) {
			if (lst.get(i) - lst.get(i-1) <= K) {
				ans -= freq[lst.get(i-1)];
			}
			}
		System.out.println(ans);
		System.exit(0);	
	}
}