import java.util.*;
import java.math.*;

// **** D1. Submarine in the Rybinsk Sea (easy edition) ****

public class D1 {
	static char [] in = new char [1000000];
	static long MOD = 998244353;
	public static void main (String [] arg) throws Throwable {
		int n = nextInt();
		long sum = 0;
		BigInteger n11 = BigInteger.valueOf(n).multiply(BigInteger.valueOf(11));
		BigInteger bMOD = BigInteger.valueOf(MOD);
		int [] lengths = new int [11];
		int [] aa = new int [n];
		for (int i = 0; i<n; ++i) {
			aa[i] = nextInt();
			int tmp = aa[i];
			int cnt = 0;
			while (tmp > 0) {
				cnt++;
				tmp/=10;
			}
			lengths[cnt]++;
		}
		BigInteger [] lens = new BigInteger[lengths.length];
		for (int i = 0; i<lens.length; ++i) lens[i] = BigInteger.valueOf(lengths[i]);
		BigInteger [] lens10 = new BigInteger[lengths.length];
		for (int i = 0; i<lens.length; ++i) lens10[i] = BigInteger.valueOf(lengths[i]*10);
		
		for (int i = 0; i<n; ++i) {
			long a = aa[i];
			long a2 = a;
			long a3 = a2;
			long tmp = 10;
			
			for (int len = 1; len < lengths.length; ++len) {
			
				if (a >= tmp) {
					long res = a % tmp;
					long tmpleft = (a - res) * 10;
					a = tmpleft + res;
					tmp *= 100;
				}
				
				// Paired with Length = len
				if (lengths[len] != 0) {
					// This in lowest
					sum += BigInteger.valueOf(a).multiply(lens[len]).mod(bMOD).longValue();
					// This not in lowest
					sum += BigInteger.valueOf(a2).multiply(lens10[len]).mod(bMOD).longValue();
					//System.err.println("Considering " + a + " and " + a2*10 + " for len = " + len);
				}
				a2 = a;
			}
			//System.err.println(a3 + " becomes " + a);
			sum %= MOD;
		}
		System.out.println(sum);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	/************** HELPER CLASSES ***************/
    //static class HS extends HashSet<Integer>{public HS(){super();}public HS(int a){super(a);}};
	//static class AL extends ArrayList<Integer>{public AL(){super();}public AL(int a){super (a);}};
	static class Pair implements Comparable<Pair> {
		int i,j;long L; public Pair(int xx, int yy, long LL){i=xx;j=yy;L=LL;} 
		public int compareTo(Pair p) { return (this.L < p.L) ? -1 : ((this.L == p.L && this.i < p.i) ? -1 : 1);}
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
	public static long modPow (long a, long n, long MOD) { long S = 1; for (;n > 0; n>>=1, a=(a*a)%MOD) if ((n & 1) != 0) S = (a*S) % MOD; return S;}
}

/* Full Problem Text:
  
This problem differs from the next one only in the presence of the constraint on the equal length of all numbers a_1, a_2, \dots, a_n.
Actually, this problem is a subtask of the problem D2 from the same contest and the solution of D2 solves this subtask too.
A team of SIS students is going to make a trip on a submarine.
Their target is an ancient treasure in a sunken ship lying on the bottom of the Great Rybinsk sea.
Unfortunately, the students don't know the coordinates of the ship, so they asked Meshanya (who is a hereditary mage) to help them.
He agreed to help them, but only if they solve his problem.
Let's denote a function that alternates digits of two numbers f(a_1 a_2 \dots a_{p - 1} a_p, b_1 b_2 \dots b_{q - 1} b_q),
where a_1 \dots a_p and b_1 \dots b_q are digits of two integers written in the decimal notation without leading zeros.
In other words, the function f(x, y) alternately shuffles the digits of the numbers x and y by writing them from the lowest digits to the older ones, starting with the number y.
The result of the function is also built from right to left (that is, from the lower digits to the older ones).
If the digits of one of the arguments have ended, then the remaining digits of the other argument are written out.
Familiarize with examples and formal definitions of the function below.
For example: f(1111, 2222) = 12121212 f(7777, 888) = 7787878 f(33, 44444) = 4443434 f(555, 6) = 5556 f(111, 2222) = 2121212

Formally,
 
 if p > q then f(a_1 \dots a_p, b_1 \dots b_q) = a_1 a_2 \dots a_{p - q + 1} b_1 a_{p - q} b_2 \dots a_{p - 1} b_{q - 1} a_p b_q; 
 if p 
Mishanya gives you an array consisting of n integers a_i.
All numbers in this array are of equal length (that is, they consist of the same number of digits).
Your task is to help students to calculate \sum_{i = 1}^{n}\sum_{j = 1}^{n} f(a_i, a_j) modulo 998\,244\,353.

 */