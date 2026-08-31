import java.util.*;
import java.math.*;

// **** A. Reverse a Substring ****

public class A {
	static char [] in = new char [400000];
	public static void main (String [] arg) throws Throwable {
		int n = nextInt();
		char [] str = next().toCharArray();
		char ini = str[0];
		for (int i = 1; i<str.length; ++i) {
			if (str[i] < ini) {
				System.out.println("YES");
				System.out.printf("%d %d\n", i, i+1);
				return;
			}
			ini = str[i];
		}
		System.out.println("NO");
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/************** FAST IO CODE FOLLOWS *****************/
	public static long nextLong() throws Throwable {
		long i = System.in.read();boolean neg = false;while (i < 45) i = System.in.read();if (i == 45) {neg=true;i=48;}i = i - 48;
		int j = System.in.read();while (j > 32) {i*=10;i+=j-48;j = System.in.read();}return (neg) ? -i : i;
	}
	public static int nextInt() throws Throwable {return (int)nextLong();}
	public static String next() throws Throwable {
		int i = 0; while (i < 40 && i != -1) i = System.in.read(); int cptr = 0; while (i >= 40) { in[cptr++] = (char)i; i = System.in.read();}
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
}

/* Full Problem Text:
  
You are given a string s consisting of n lowercase Latin letters.
Let's define a substring as a contiguous subsegment of a string.
For example, "acab" is a substring of "abacaba" (it starts in position 3 and ends in position 6),
but "aa" or "d" aren't substrings of this string.
So the substring of the string s from position l to position r is s[l; r] = s_l s_{l + 1} \dots s_r.
You have to choose exactly one of the substrings of the given string and reverse it (i.e. make s[l; r] = s_r s_{r - 1} \dots s_l) to obtain a string that is less lexicographically.
Note that it is not necessary to obtain the minimum possible string.
If it is impossible to reverse some substring of the given string to obtain a string that is less, print "NO".
Otherwise print "YES" and any suitable substring.
String x is lexicographically less than string y, if either x is a prefix of y (and x \ne y),
or there exists such i (1 < i < min(|x|, |y|)),
that x_i  in modern programming languages.

 */