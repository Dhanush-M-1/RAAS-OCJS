import java.util.*;
import java.math.*;

// **** D1. Add on a Tree ****

public class D1 {
	static char [] in = new char [1000000];
	public static void main (String [] arg) throws Throwable {
		int n = nextInt();
		AL [] AL = new AL[n+1];
		for (int i = 0; i<n-1; ++i) {
			int N1 = nextInt();
			int N2 = nextInt();
			if (AL[N1] == null) AL[N1] = new AL();
			if (AL[N2] == null) AL[N2] = new AL();
			AL[N1].add(N2);
			AL[N2].add(N1);
		}
		boolean cancan = true;
		for (int i = 1; i<=n; ++i) if (AL[i].size() == 2) cancan = false;
		System.out.println(cancan ? "YES" : "NO");
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	/************** HELPER CLASSES ***************/
    //static class HS extends HashSet<Integer>{public HS(){super();}public HS(int a){super(a);}};
	static class AL extends ArrayList<Integer>{public AL(){super();}public AL(int a){super (a);}};
	static class Pair implements Comparable<Pair> {int i,j;long L; public Pair(int xx, int yy, long LL){i=xx;j=yy;L=LL;} public int compareTo(Pair p) {
		return (this.L < p.L) ? -1 : ((this.L == p.L && this.i < p.i) ? -1 : 1);}
	}
	
	/************** FAST IO CODE FOLLOWS *****************/
	public static long nextLong() throws Throwable {
		long i = System.in.read();boolean neg = false;while (i < 33) i = System.in.read();if (i == 45) {neg=true;i=48;}i = i - 48;
		int j = System.in.read();while (j > 32) {i*=10;i+=j-48;j = System.in.read();}return (neg) ? -i : i;
	}
	public static int nextInt() throws Throwable {return (int)nextLong();}
	public static String next() throws Throwable {
		int i = 0; while (i < 33 && i != -1) i = System.in.read(); int cptr = 0; while (i >= 33) { in[cptr++] = (char)i; i = System.in.read();}
		return new String(in, 0,cptr);
	}
	/**** LIBRARIES ****/
	public static long gcdL(long a, long b) {while (b != 0) {long tmp = b;b = (a % b);a = tmp;}return a;}
	public static int gcd(int a, int b) {while (b != 0) {int tmp = b;b = (a % b);a = tmp;}return a;}
	public static int[] sieve(int LIM) {
		int i,count = 0;
		boolean [] b = new boolean [LIM];
		for (i = 2;i<LIM; ++i) if (!b[i]) {count++; for (int j = i<<1; j<LIM; j+=i) b[j] = true;}
		int [] primes = new int[count];
		for (i = 2,count=0;i<LIM;++i) if (!b[i]) primes[count++] = i;
		return primes;
	}
	public static int[] numPrimeFactors(int LIM) {
		int i,count = 0;
		int [] b = new int [LIM];
		for (i = 2;i<LIM; ++i) if (b[i] == 0) {count++; for (int j = i; j<LIM; j+=i) b[j]++;}
		return b;
	}
	public static StringBuilder stringFromArray(int [] a) {
		StringBuilder b = new StringBuilder(9*a.length);
		for (int i = 0; i<a.length; ++i) {
			if (i != 0) b = b.append(' ');
			b = b.append(a[i]);
		}
		return b;
	}
}

/* Full Problem Text:
  
Note that this is the first problem of the two similar problems.
You can hack this problem only if you solve both problems.
You are given a tree with n nodes.
In the beginning, 0 is written on all edges.
In one operation, you can choose any 2 distinct leaves u, v and any real number x and add x to values written on all edges on the simple path between u and v.
For example, on the picture below you can see the result of applying two operations to the graph: adding 2 on the path from 7 to 6, and then adding -0.5 on the path from 4 to 5.
Is it true that for any configuration of real numbers written on edges, we can achieve it with a finite number of operations?

Leaf is a node of a tree of degree 1.
Simple path is a path that doesn't contain any node twice.

 */