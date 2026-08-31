import java.util.ArrayList;
import java.util.Scanner;


public class C_107 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		
		sieve((int)Math.sqrt(n+1));
		int num = 0;
		Pair aa = null;
		Pair bb = null;
		for(Pair p : factorize(n)){
			num += p.second;
			if(aa == null) aa = p;
			else if(bb == null) bb = p;
		}
		//System.out.println("b="+num);
		if(num == 0 || num == 1){
			System.out.println(1);
			System.out.println(0);
		}
		else if(num == 2){
			System.out.println(2);
		} else{
			System.out.println(1);
			if(aa.second > 1) System.out.println(aa.first*aa.first);
			else System.out.println((aa.first*bb.first));
		}
		
		
	}
	
	static ArrayList<Integer> primes;
	static void sieve(int n){
		primes = new ArrayList<Integer>();
		boolean vis[] = new boolean[n+1];
		for(int p = 2; p <= n; p++){
			if(!vis[p]){
				primes.add(p);
				for(int j = 2*p; j <= n; j += p) vis[j] = true;
			}
		}
	}
	static ArrayList<Pair> factorize(long m){
		ArrayList<Pair> result = new ArrayList<Pair>();
		for(int i = 0; i < primes.size(); i++){
			int p = primes.get(i);
			if(p*p > m) break;
			int alpha = 0;
			while(m % p == 0){alpha++; m /= p;}
			if(alpha > 0) result.add(new Pair(p, alpha));
		}
		if(m > 1) result.add(new Pair((int)m, 1));
		return result;
	}
	
	
	static class Pair{
		public int first;
		public int second;
		public Pair(int frst, int scnd){
			first = frst;
			second = scnd;
		}
	}

}
