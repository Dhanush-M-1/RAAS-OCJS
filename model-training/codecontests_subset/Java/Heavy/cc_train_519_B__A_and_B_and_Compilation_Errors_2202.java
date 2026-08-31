import java.util.*;
import java.io.*;
public class Test {

	private static Scanner s;
	public static int []arr;
	public static void main(String[] args) {
		s = new Scanner(System.in);
		int m = s.nextInt();
		long sum = 0;
		for(int i=0;i<m;i++)
			sum+=s.nextLong();
		long sum2 = 0;
		for(int i=0;i<m-1;i++)
			sum2+=s.nextLong();
		System.out.println(sum-sum2);
		sum = 0;
		for(int i=0;i<m-2;i++)
			sum += s.nextLong();
		System.out.println(sum2-sum);
	}
	public static boolean canbe(int m,int st) {
		return (st>=0 || st<=9*m);
	}
	public static void sieveOfErathosthenes(boolean []a, int n) {
		for(int i=0;i<n;i++)
			a[i] = true;
		for(int i=2;i*i<n;i++) {
			if(a[i]) {
				for(int j = i*2;j<n;j+=i) {
					a[j] = false;
				}
			}
		}
	}
	public static boolean isPrime(int n) {
		if(n==1)
			return false;
		if(n<=3)
			return true;
		for(int i=2;i<=(int)Math.sqrt((double)n);i++){
			if(n%i==0)
				return false;
		}
		return true;
	}
	public static class duel{
		public int x;
		public int freq;
		public duel(int x,int y) {
			this.x = x;
			this.freq = y;
		}
	}
	public static int bracketSequenceConcat(String a,String b) {
		int ans= 0;
		boolean aflag = true,bflag =true;
		Stack<Character> st = new Stack<Character>();
		for(int i=0;i<a.length();i++) {
			if(a.charAt(i)=='(')
				st.push('(');
			else if(st.isEmpty()) {
				aflag = false;
			}else {
				st.pop();
			}
		}
		if(!st.isEmpty())
			aflag = false;
		System.out.println(aflag);
		if(!aflag)
			b = a+b;
		System.out.println("b :"+b);
		for(int i=0;i<b.length();i++) {
			if(b.charAt(i)=='(')
				st.push('(');
			else if(st.isEmpty()) {
				bflag = false;
				break;
			}else {
				st.pop();
			}
			System.out.println(st.size());
		}
		if(!st.isEmpty())
			bflag = false;
		System.out.println(bflag);
		if(aflag && bflag)
			return 1;
		else if(!aflag && bflag)
			return 1;
		return ans;
	}
	public static int cuttingRod(int []a,int n) {
		if(n<=0)
			return 0;
		int ans = Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			ans = Math.max(cuttingRod(a,n-i-1)+a[i], ans);
		}
		return ans;
	}
	/*public static int memoCuttingRod(int []a,int n) {
		if(n<=0)
			return 0;
		if(memo[n-1]!=-1)
			return memo[n-1];
		for(int i=0;i<n;i++) {
			memo[n-1] = Math.max(memo[n-1], memoCuttingRod(a,n-i-1)+a[i]);
		}
		return memo[n-1];
	}*/
	public static boolean isPrimeSqrt(int n) {
		if(n<=1)
			return false;
		else if(n==2||n==3)
			return true;
		for(int i=2;i<=Math.sqrt(n);i++) {
			if(n%i==0)
				return false;
		}
		return true;
	}
	public static int lcm(int a,int b,int c) {
		return (int)(((long)a*(long)b)/(long)c);
	}
	public static int gcd(int a,int b) {
		if(a==0)
			return b;
		if(b==0)
			return a;
		if(a%b==0)
			return b;
		else
			return gcd(b,a%b);
	}
	public static boolean isPowerOfTwo(long a) {
		long diff = a;
		long test = 1;
		while(test>0) {
			if(diff==(diff&test)) {
				return true;
			}
			test = test<<1;
		}
		return false;
	}
	public static boolean boolBinarySearch(long []a,int l,int r,long target) {
		if(l<r) {
			int mid = l+(r-l)/2;
			if(target==a[mid])
				return true;
			else if(target>a[mid])
				return boolBinarySearch(a,mid+1,r,target);
			else
				return boolBinarySearch(a,l,mid-1,target);
		}
		return false; 
	}
}