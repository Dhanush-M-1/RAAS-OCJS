
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.ObjectInputStream.GetField;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;


public class N714 {
	static PrintWriter out;
	static Scanner sc;
	static ArrayList<Integer>q,w;
	static ArrayList<Integer>adj[];
	static HashSet<Integer>primesH;
	static boolean prime[];
	//static ArrayList<Integer>a;
	static HashSet<Long>tmp;
	static boolean[]v;
	static int[]c,d;
	static int[][]dp;
	static char[][]mp;
	static int A,B,n,m,h,ans;
	//static String a,b;
	static long oo=(long)1e9+7;
	public static void main(String[]args) throws IOException {
		sc=new Scanner(System.in);
		out=new PrintWriter(System.out);
		//A();
		//B();
	    CC();
		//D();
	//E();
		//F();
		//G();
		out.close();
	}
	  private static void A() throws IOException {
		  int t=ni();
			while(t-->0) {
				int n=ni(),k=ni();
				if(n%2==1&&k>n/2||n%2==0&&k>(n-1)/2)ol(-1);
				else {
					//boolean[]tk=new boolean[n+1];
					ArrayList<Integer>ans=new ArrayList<Integer>();
					int trgt=n-k;
					for(int i=1;i<=trgt;i++) {
						ans.add(i);
					}
					for(int idx=1,i=0;i<k;i++,idx+=2) {
						ans.add(idx,trgt+i+1);
					}
					for(int x:ans) {
						out.print(x+" ");
					}
					ol("");
				}
						
			}
		
	   }
		static void B() throws IOException {
			int t=ni();
			long fc[]=new long[(int)(2e5)+1];
			fc[0]=fc[1]=1;
			for(int i=2;i<fc.length;i++) {
				fc[i]=(fc[i-1]*i)%oo;
			}
			while(t-->0) {
				int n=ni();
				int[]a=nai(n);
				int mn=Integer.MAX_VALUE;
				for(int x:a)mn=Math.min(mn, x);
				long cnt=0;
				for(int i=0;i<n;i++) {
					if(a[i]==mn)cnt++;
					if((a[i]&mn)!=mn) {
						cnt=0;break;
					}
				}
				long ans=(cnt*(cnt-1))%oo;
				ans=(ans*fc[n-2])%oo;
				ol(""+ans);
			}
		}
		
		static void C() throws IOException{
			 int t=ni();
			 while(t-->0) {
				 String s=ns();
					int m=ni();
					long ans=s.length();
					long[]num=new long[10];
					for(int i=0;i<s.length();i++) {
						num[(s.charAt(i)-'0')]++;
					}
					int st=0;
					for(;st<m;) {
						int mx=getMax(num);
						int diff=10-mx;
						if(st+diff>m)break;
						long[]tmp=new long[10];
						tmp[0]=tmp[1]=num[mx]%oo;
						for(int i=0;i<mx;i++) {
							tmp[i+diff]=(tmp[i+diff]+num[i])%oo;
						}
						ans=(ans+tmp[0])%oo;
						st+=diff;
						for(int i=0;i<10;i++) {
							num[i]=tmp[i];
						}
					}
					ol(ans+"");
			 }
		}
	private static int getMax(long[] x) {
			int idx=-1;
			for(int i=9;i>=0;i--) {
				if(x[i]>0) {
					idx=i;
					break;
				}
			}
			return idx;
		}
	static void CC() throws IOException {
		int t=ni();
		long[]dp=new long[(int)2e5+1];
		for(int i=0;i<=8;i++)dp[i]=2;
		dp[9]=3;
		for(int i=10;i<dp.length;i++) {
			dp[i]=(dp[i-10]+dp[i-9])%oo;
		}
		while(t-->0) {
			String s=ns();
			int m=ni();
			long ans=0;
			for(int i=0;i<s.length();i++) {
				int x=s.charAt(i)-'0';
				int k=m;
				k-=(10-x);
				ans=(ans+(k>=0?dp[k]:1))%oo;
			}
			ol(""+ans);
			
		}
		
	}
	static void E() throws IOException {
		int t=ni();
		while(t-->0) {
			
			
		}
		
	}
	static void D() throws IOException {
		int t=ni();
		while(t-->0) {
			int n=ni();
			Long[]a=new Long[n+2];
			for(int i=0;i<n+2;i++) {
				a[i]=nl();
			}
			Arrays.sort(a);
			long sum=0;
			for(int i=0;i<=n;i++) {
				sum+=a[i];
			}
			boolean ok=false;
			int ex=-1;
			for(int i=0;i<n;i++) {
				sum-=a[i];
				if(sum==a[n+1]) {
					ok=true;
					ex=i;
					break;
				}
				sum+=a[i];
			}
			if(!ok) {
			sum-=a[n];
			if(sum==a[n+1]||sum==a[n]) {
				ex=n;
				ok=true;
			}
			}
			if(ok) {
				for(int i=0;i<=n;i++) {
					if(i!=ex)
						out.print(a[i]+" ");
				}
				ol("");
			}else {
				ol(-1);
			}
		
		}
	}
	static void F() throws IOException {
		int t=ni();
		while(t-->0) {
			
		}
	}
	static void G() throws IOException {
		int t=ni();
		int lim=(int)1e7+1;
		int[]a=new int[lim];
		Arrays.fill(a, 1);
		for(int i=2;i<a.length;i++) {
			for(int j=i;j<a.length;j+=i) {
				a[j]+=i;
			}
		}
		int gt[]=new int[lim];
		for(int i=1;i<gt.length;i++) {
			if(a[i]<lim&&gt[a[i]]==0)gt[a[i]]=i;
		}
		while(t-->0) {
			int n=ni();
			int ans=gt[n];
			ol(ans==0?-1:ans);
		}
	}
	static int ni() throws IOException {
		return sc.nextInt();
	}
	static double nd() throws IOException {
		return sc.nextDouble();
	}
	static long nl() throws IOException {
		return  sc.nextLong();
	}
	static String ns() throws IOException {
		return sc.next();
	}
	static int[] nai(int n) throws IOException {
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = sc.nextInt();
		return a;
	}
	static long[] nal(int n) throws IOException {
		long[] a = new long[n];
		for (int i = 0; i < n; i++)
			a[i] = sc.nextLong();
		return a;
	}
	static int[][] nmi(int n,int m) throws IOException{
		int[][]a=new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				a[i][j]=sc.nextInt();
			}
		}
		return a;
	}

	static long[][] nml(int n,int m) throws IOException{
		long[][]a=new long[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				a[i][j]=sc.nextLong();
			}
		}
		return a;
	}
	static void o(String x) {
		out.print(x);
	}
	static void ol(String x) {
		out.println(x);
	}
	static void ol(int x) {
		out.println(x);
	}
	static void disp1(int []a) {
		for(int i=0;i<a.length;i++) {
			out.print(a[i]+" ");
		}
		out.println();
	}

	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

		public String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens()) 
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}
		public boolean hasNext() {return st.hasMoreTokens();}
		public int nextInt() throws IOException {return Integer.parseInt(next());}
		
		public double nextDouble() throws IOException {return Double.parseDouble(next());}
		
		public long nextLong() throws IOException {return Long.parseLong(next());}

		public String nextLine() throws IOException {return br.readLine();}
			
		public boolean ready() throws IOException {return br.ready(); }
		

	}
}
