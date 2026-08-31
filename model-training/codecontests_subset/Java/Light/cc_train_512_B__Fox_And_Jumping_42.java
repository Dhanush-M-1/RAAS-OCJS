import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;


public class D510 {
	public static void main(String[] Args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] val = new int[n];
		int[] cos = new int[n];
		for (int k = 0; k < n; k++){
			val[k] = sc.nextInt();
		}
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
		for (int k = 0; k < n; k++){
			cos[k] = sc.nextInt();
			pq.add(new Pair(val[k],cos[k]));
		}
		HashSet<Integer> Seen= new HashSet<Integer>();
		while(!pq.isEmpty()){
			Pair pp = pq.poll();
		//	System.out.println(pp.val);
			if (Seen.contains(pp.val))
				continue;
			Seen.add(pp.val);
			if (pp.val == 1){
				System.out.println(pp.cost);
				return;
			}
			for (int k = 0; k < n; k++){
				int g = gcd(pp.val, val[k]);
				if (!Seen.contains(g))
					pq.add(new Pair(g,pp.cost + cos[k]));
			}
		}
		System.out.println(-1);
		
	}
	public static int gcd(int a, int b){
		return (b==0)?a:gcd(b,a%b);
	}
	public static class Pair implements Comparable<Pair>{
		Pair(int a, int b){
			val = a;
			cost = b;
		}
		int cost;
		int val;
		public int compareTo(Pair o){
			return cost - o.cost;
		}
	}
}
