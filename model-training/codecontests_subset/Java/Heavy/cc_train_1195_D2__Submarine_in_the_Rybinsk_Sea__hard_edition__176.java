import java.io.*;
import java.util.*;



import java.math.*;
import java.math.BigInteger;


public final class A
{    
	static PrintWriter out = new PrintWriter(System.out); 
	static StringBuilder ans=new StringBuilder();
	static FastReader in=new FastReader();
	static ArrayList<Pair> g[];
	static long mod=(long)998244353,INF=Long.MAX_VALUE;
	static boolean set[],col[]; 
	static int par[],tot[],partial[];
	static int D[],P[][];
	static int dp[][],sum=0,size[];
	//	static node1 seg[];
	//static pair moves[]= {new pair(-1,0),new pair(1,0), new pair(0,-1), new pair(0,1)};
	public static void main(String args[])throws IOException
	{				


		long s=0;
		int N=i();
		long n=N;
		long pow[]=new long[25];
		pow[0]=1L;
		for(int i=1; i<25; i++)
		{
			pow[i]=pow[i-1]*10L;
			pow[i]%=mod;
		}
		long A[]=inputLong(N);
		HashMap<Integer,Long> mp=new HashMap<>();
		for(long a:A)
		{
			int l=(a+"").length();
			long f=mp.getOrDefault(l, 0L)+1;
			mp.put(l, f);
		}
//		System.out.println(mp);
//		print(pow);
		for(long a:A)
		{
			long b=a;
			int x=(b+"").length(); //length of A[i]
			for(int len=1; len<=10; len++)
			{
				if(!mp.containsKey(len))continue;
				long f=mp.get(len);
				//b acts as p
				b=a;
				if(x>=len)
				{
					int l=len;
					int i=-1;
					//System.out.println(i+" "+len+" "+s);
					while(l-->0)
					{
						i+=2;
						long r=b%10;
						b/=10;
						r*=pow[i];
						r%=mod;
						r*=f;
						r%=mod;
						s+=r;s%=mod;
					}
					
					while(b!=0)
					{
						i++;
						long r=b%10;
						b/=10;
						r*=pow[i];
						r%=mod;
						r*=f;
						r%=mod;
						s+=r;s%=mod;
					}
					//System.out.println(s);
				}
				else
				{
					int i=1;
					while(b!=0)
					{
						long r=b%10;
						b/=10;
						r*=pow[i];
						r%=mod;
						r*=f;
						r%=mod;
						s+=r;s%=mod;
						i+=2;
					}
				}			
				//b acts as q
				b=a;
				if(x>len)
				{
					int i=-2;
					int l=len;
					while(l-->0)
					{
						long r=b%10;
						b/=10;
						i+=2;
						r*=pow[i];r%=mod;
						r*=f; r%=mod;
						s+=r;
					}
					i++;
//					System.out.println("sum has been increased by "+s+" "+i);
					while(b!=0)
					{
						long r=b%10;
						b/=10;
						i+=1;
						r*=pow[i];r%=mod;
						r*=f; r%=mod;
						s+=r;s%=mod;
					}
					//System.out.println("s"+s);
				}
				else
				{
					int i=-2;
					while(b!=0)
					{
						long r=b%10;
						b/=10;
						i+=2;
						r*=pow[i];r%=mod;
						r*=f; r%=mod;
						s+=r;
						s%=mod;
					}
				}
			}
			
		}
		out.println(s);
		out.close();
	}
	static int [] sub(int A[],int B[])
	{
		int N=A.length;
		int f[]=new int[N];
		for(int i=N-1; i>=0; i--)
		{
			if(B[i]<A[i])
			{
				B[i]+=26;
				B[i-1]-=1;
			}
			f[i]=B[i]-A[i];
		}
		for(int i=0; i<N; i++)
		{
			if(f[i]%2!=0)f[i+1]+=26;
			f[i]/=2;
		}
		return f;
	}
	static int[] f(int  N)
	{
		char X[]=in.next().toCharArray();
		int A[]=new int[N];
		for(int i=0; i<N; i++)A[i]=X[i]-'a';
		return A;
	}




	static int max(int a ,int b,int c,int d)
	{
		a=Math.max(a, b);
		c=Math.max(c,d);
		return Math.max(a, c);
	}
	static int min(int a ,int b,int c,int d)
	{
		a=Math.min(a, b);
		c=Math.min(c,d);
		return Math.min(a, c);
	}



	static HashMap<Integer,Integer> Hash(int A[])
	{
		HashMap<Integer,Integer> mp=new HashMap<>();
		for(int a:A)
		{
			int f=mp.getOrDefault(a,0)+1;
			mp.put(a, f);
		}
		return mp;
	}
	static long mul(long a, long b)
	{
		return ( a %mod * 1L * b%mod )%mod;
	}
	static void swap(int A[],int a,int b)
	{
		int t=A[a];
		A[a]=A[b];
		A[b]=t;
	}


	static int find(int a)
	{
		if(par[a]<0)return a;
		return par[a]=find(par[a]);
	}
	static void union(int a,int b)
	{
		a=find(a);
		b=find(b);
		if(a!=b)
		{
			par[a]+=par[b];
			par[b]=a;
		}
	}
	static boolean isSorted(int A[])
	{
		for(int i=1; i<A.length; i++)
		{
			if(A[i]<A[i-1])return false;
		}
		return true;
	}

	static boolean isDivisible(StringBuilder X,int i,long num)
	{
		long r=0;
		for(; i<X.length(); i++)
		{
			r=r*10+(X.charAt(i)-'0');
			r=r%num;
		}
		return r==0;
	}    



	static int lower_Bound(int A[],int low,int high, int x) 
	{ 
		if (low > high) 
			if (x >= A[high]) 
				return A[high]; 

		int mid = (low + high) / 2; 

		if (A[mid] == x) 
			return A[mid]; 

		if (mid > 0 && A[mid - 1] <= x && x < A[mid]) 
			return A[mid - 1]; 

		if (x < A[mid]) 
			return lower_Bound( A, low, mid - 1, x); 

		return lower_Bound(A, mid + 1, high, x); 
	} 

	static String f(String A)
	{
		String X="";
		for(int i=A.length()-1; i>=0; i--)
		{
			int c=A.charAt(i)-'0';
			X+=(c+1)%2;
		}
		return X;
	}

	static void sort(long[] a) //check for long
	{
		ArrayList<Long> l=new ArrayList<>();
		for (long i:a) l.add(i);
		Collections.sort(l);
		for (int i=0; i<a.length; i++) a[i]=l.get(i);
	}

	static String swap(String X,int i,int j)
	{
		char ch[]=X.toCharArray();
		char a=ch[i];
		ch[i]=ch[j];
		ch[j]=a;
		return new String(ch);
	}

	static int sD(long n)  
	{  

		if (n % 2 == 0 )  
			return 2;  

		for (int i = 3; i * i <= n; i += 2) {  
			if (n % i == 0 )  
				return i;  
		}  

		return (int)n;  
	}  

	static void setGraph(int N)
	{
		tot=new int[N+1];
		partial=new int[N+1];
		D=new int[N+1];
		P=new int[N+1][(int)(Math.log(N)+10)];
		set=new boolean[N+1];
		g=new ArrayList[N+1];
		for(int i=0; i<=N; i++)
		{

			g[i]=new ArrayList<>();		
			D[i]=Integer.MAX_VALUE;
			//D2[i]=INF;
		}
	}



	static  long pow(long a,long b)
	{
		//long mod=1000000007;
		long pow=1;
		long x=a;
		while(b!=0)
		{
			if((b&1)!=0)pow=(pow*x)%mod;
			x=(x*x)%mod;
			b/=2;
		}
		return pow;
	}

	static long toggleBits(long x)//one's complement || Toggle bits
	{
		int n=(int)(Math.floor(Math.log(x)/Math.log(2)))+1;

		return ((1<<n)-1)^x;
	}

	static int countBits(long a)
	{
		return (int)(Math.log(a)/Math.log(2)+1);
	}

	static long fact(long N)
	{ 
		long n=2; 
		if(N<=1)return 1;
		else
		{
			for(int i=3; i<=N; i++)n=(n*i)%mod;
		}
		return n;
	}

	static int kadane(int A[])
	{
		int lsum=A[0],gsum=A[0];
		for(int i=1; i<A.length; i++)
		{
			lsum=Math.max(lsum+A[i],A[i]);
			gsum=Math.max(gsum,lsum);
		}
		return gsum;
	}

	static void sort(int[] a) {
		ArrayList<Integer> l=new ArrayList<>();
		for (int i:a) l.add(i);
		Collections.sort(l);
		for (int i=0; i<a.length; i++) a[i]=l.get(i);
	}

	static boolean isPrime(long N)
	{
		if (N<=1)  return false; 
		if (N<=3)  return true; 
		if (N%2 == 0 || N%3 == 0) return false; 
		for (int i=5; i*i<=N; i=i+6) 
			if (N%i == 0 || N%(i+2) == 0) 
				return false; 
		return true; 
	}
	static void print(char A[])
	{
		for(char c:A)System.out.print(c+" ");
		System.out.println();
	}
	static void print(boolean A[])
	{
		for(boolean c:A)System.out.print(c+" ");
		System.out.println();
	}
	static void print(int A[])
	{
		for(int a:A)System.out.print(a+" ");
		System.out.println();	
	}
	static void print(long A[])
	{
		for(long i:A)System.out.print(i+ " ");
		System.out.println();

	}
	static void print(boolean A[][])
	{
		for(boolean a[]:A)print(a);
	}
	static void print(long A[][])
	{
		for(long a[]:A)print(a);
	}
	static void print(int A[][])
	{
		for(int a[]:A)print(a);
	}
	static void print(ArrayList<Integer> A)
	{
		for(int a:A)System.out.print(a+" ");
		System.out.println();
	}

	static int i()
	{
		return in.nextInt();
	}

	static long l()
	{
		return in.nextLong();
	}

	static int[] input(int N){
		int A[]=new int[N];
		for(int i=0; i<N; i++)
		{
			A[i]=in.nextInt();
		}
		return A;
	}

	static long[] inputLong(int N)     {
		long A[]=new long[N];
		for(int i=0; i<A.length; i++)A[i]=in.nextLong();
		return A;
	}

	static long GCD(long a,long b) 
	{
		if(b==0)
		{
			return a;
		}
		else return GCD(b,a%b );
	}

}
class Pair implements Comparable<Pair>
{
	long a,b,d;
	Pair(long a,long  b)
	{
		this.a=a;
		this.b=b;
		d=a-b;
	}
	public int compareTo(Pair x)
	{
		if(this.d>x.d)return 1;
		if(this.d==x.d)return 0;
		else return -1;
	}
}


//Code For FastReader
//Code For FastReader
//Code For FastReader
//Code For FastReader
class FastReader
{
	BufferedReader br;
	StringTokenizer st;
	public FastReader()
	{
		br=new BufferedReader(new InputStreamReader(System.in));
	}

	String next()
	{
		while(st==null || !st.hasMoreElements())
		{
			try
			{
				st=new StringTokenizer(br.readLine());
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}

	int nextInt()
	{
		return Integer.parseInt(next());
	}

	long nextLong()
	{
		return Long.parseLong(next());
	}

	double nextDouble()
	{
		return Double.parseDouble(next());
	}

	String nextLine()
	{
		String str="";
		try
		{
			str=br.readLine();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return str;
	}

}