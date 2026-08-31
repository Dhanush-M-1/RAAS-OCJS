import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		ArrayList<Integer> both = new ArrayList<Integer>();
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		for (int j = 0; j < n; j++) {
			int t = sc.nextInt(), temp1 = sc.nextInt(), temp2 = sc.nextInt();
			if (temp1==1 && temp2==1) {
				both.add(t);
			}
			else if(temp1==1) {
				a.add(t);
			}
			else if(temp2==1) {
				b.add(t);
			}
		}
		if (both.size() + Math.min(a.size(), b.size()) < k) System.out.println(-1);
		else {
			Collections.sort(both);
			Collections.sort(a);
			Collections.sort(b);
			int min = Math.min(k, both.size());
			int[] counts = {min, k-min};
			while (counts[0] > 0 && counts[1] < Math.min(b.size(), a.size()) && both.get(counts[0]-1) > a.get(counts[1]) + b.get(counts[1])) {
				counts[0]--;
				counts[1]++;
			}
			long sum = 0;
			for (int i = 0; i < counts[0]; i++) {
				sum += both.get(i);
			}
			for (int i = 0; i < counts[1]; i++) {
				sum += a.get(i) + b.get(i);
			}
			System.out.println(sum);
		}
		
		
	}
	
}
