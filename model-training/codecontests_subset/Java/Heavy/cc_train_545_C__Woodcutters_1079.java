import java.util.*;
import java.io.*;
import java.math.*;
import java.math.BigInteger;
public class test {
	static long sum=0,sum1=Long.MAX_VALUE;
	public static final int MOD = (int) (1e9 + 7);
 public static void main(String args[])
	{
		InputReader in = new InputReader(System.in);
		OutputStream outputStream = System.out;
		PrintWriter out = new PrintWriter(outputStream);
		int n=in.nextInt(),i,j,k;
		long x[]=new long[n];
		long h[]=new long[n];
		for(i=0;i<n;i++)
		{
			x[i]=in.nextLong();
			h[i]=in.nextLong();
		}
		long point=x[0];
		int count=2;
		for(i=1;i<n-1;i++)
		{
			if(x[i]-h[i]>point)
			{
				count++;
				point=x[i];
			}
			else if(x[i]+h[i]<x[i+1])
			{
				count++;
				point=x[i]+h[i];
			}
			else
			{
				point=x[i];
			}
		}
		if(n>=2)
			out.println(count);
		else
			out.println(1);
		out.close();
	}
	private static int[] nextIntArray(InputReader in,int n)	
	{
		int[] a=new int[n];
		for(int i=0;i<n;i++)
			a[i]=in.nextInt();
		return a;
	}
	private static String[] nextStringArray(InputReader in,int n)	
	{
		String[] a=new String[n];
		for(int i=0;i<n;i++)
			a[i]=in.next();
		return a;
	}
	private static void show(int[] a)
	{
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}
	private static void show2DArray(char[][] a)
	{
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a[0].length;j++)
				System.out.print(a[i][j]);
			System.out.println();
		}
	}
 static long fact(long x)
 {
	 long i=x,mul=1;
	 while(i>0)
	 {
		 mul=(mul%1000000007)*(i%1000000007)%1000000007;
		 i--;
	 }
	 return mul;
 }
 static long output(ArrayList<Integer> h[],int j,boolean[] v)
 {
	 int k;
	 v[j]=true;
	 sum++;
	 for(k=0;k<h[j].size();k++)
	 {
		 if(v[h[j].get(k)]==false)
		 {
			 output(h,h[j].get(k),v);
		 }
	 }
	 return sum;
 }
 static long func(boolean v[],int j,ArrayList<Integer> h[],long ban[])
 {
	 	v[j]=true;
	 	 int k;
	 	long sum=0;
	    sum=sum+ban[j];
	 	//System.out.println(h[j].size());
	 	for(k=0;k<h[j].size();k++)
	 	{
	 		if(v[h[j].get(k)]==false)
	 		{
	 			v[h[j].get(k)]=true;
	 			sum+=func(v,h[j].get(k),h,ban);
	 		}
	 	}
	 	return sum;
 }
/*static class Graph {
    	
    	private static Deque<Integer> stack = new ArrayDeque<Integer>();
 		private int least,count,v;
 		
		Set<Integer>[] cities;
    	private int[] risk;
    	
    	Graph(int n,String[] risk){
    		
    		cities = new HashSet[n];
    		this.risk = new int[n];
    		for(int i =0;i<n;i++){
    			cities[i] = new HashSet<>();
    		}
    		for(int i =0;i<n;i++){
    			this.risk[i] = Integer.parseInt(risk[i]);
    		}
    		visited = new boolean[n];
    	}
    	
    	
    	public void add(int x,int y){
    		cities[x].add(y);
    		cities[y].add(x);
    	}
}*/
	static int root(int arr[],int i)
	{
		while(arr[i]!=i)
		{
			i=arr[i];
		}
		return i;
	}
	static boolean find(int arr[],int a,int b)
	{
		if(root(arr,a)==root(arr,b))
		{
			return true;
		}
		else
			return false;
	}
	static void weighted_union(int arr[],int size[],int a,int b)
	{
		int root_a=root(arr,a);
		int root_b=root(arr,b);
		if(root_a!=root_b)
		{
			if(size[root_a]<size[root_b])
			{
				arr[root_a]=arr[root_b];
				size[root_b]+=size[root_a];
			}
			else
			{
				arr[root_b]=arr[root_a];
				size[root_a]+=size[root_b];
			}
		//	count--;
		}
	}
	static class Pair implements Comparable<Pair>
	{
		private long first;
		private long index;
		//private long second;;

		public Pair(long i, long j) 
		{ 
			this.first = i;
			this.index = j;
		}
		public long getFirst() { return first; }
		//public long getSecond() { return second; }
		public long getIndex() { return index ;}
		public void setFirst(long k) { this.first=k ; }
		public void setIndex(long k) { this.index=k ;}
		//public void setSecond(long k) { this.second=k ;}
		@Override
		public int compareTo(Pair o) 
		{
			return Long.compare(this.first, o.first);
		}
	}
	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream inputstream) {
			reader = new BufferedReader(new InputStreamReader(inputstream));
			tokenizer = null;
		}

		public String nextLine(){
			String fullLine=null;
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					fullLine=reader.readLine();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
				return fullLine;
			}
			return fullLine;
		}
		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}
		public long nextLong() {
			return Long.parseLong(next());
		}
		public int nextInt() {
			return Integer.parseInt(next());
		}
	}
}