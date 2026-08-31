import java.util.*;
import java.io.*;

public class TestClass {
	public static void main(String args[]) throws IOException 
	{ 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//for(int cases = 0; cases<c; cases++){
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st1.nextToken());
			int k = Integer.parseInt(st1.nextToken());
			ArrayList<Integer> both = new ArrayList<>();
			ArrayList<Integer> alice = new ArrayList<>();
			ArrayList<Integer> bob = new ArrayList<>();
			for(int i = 0; i<n; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				int t = Integer.parseInt(st2.nextToken());
				int val1 = Integer.parseInt(st2.nextToken());
				int val2 = Integer.parseInt(st2.nextToken());
				if(val1 == val2 && val1 == 1) both.add(t);
				else if(val1 == 1) alice.add(t);
				else if(val2 == 1) bob.add(t);
			}
			int time = 0;
			int min = Math.min(alice.size(),bob.size());
			if(both.size() + min < k){
				System.out.println(-1);
			}
			else {
				int ind1 = 0;
				int ind2 = 0;
				both.sort(null);
				alice.sort(null);
				bob.sort(null);
				//System.out.println(both);
				//System.out.println(alice);
				//System.out.println(bob);
				while(k > 0) {
					int t1 = Integer.MAX_VALUE;; int t2 = Integer.MAX_VALUE;
					if(ind1 < both.size()) t1 = both.get(ind1);
					if(ind2 < min) {
						t2 = alice.get(ind2)+bob.get(ind2);
					}
					
					if(t2 < t1) {
						time += t2;
						ind2++;
						k--;
					}
					else {
						time += t1;
						ind1++;
						k--;
					}
					//System.out.println(time);
				}
				System.out.println(time);
			}
		//}
	}
}
