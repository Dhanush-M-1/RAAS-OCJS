import java.io.*;
import java.util.*;
public class CFEdu14D
{
	public static final int MOD = (int) (1e9 + 7);
	private static int[] nextIntArray(InputReader in,int n)	
	{
		int[] a=new int[n];
		for(int i=0;i<n;i++)
			a[i]=in.nextInt();
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
	static class Pair
	{
		private int first;
		private int second;
		public Pair(int i, int j) 
		{ 
			this.first = i;
			this.second = j;
		}
		public int getFirst() { return first; }
		public int getSecond() { return second ;}
		public void setFirst(int k) { this.first=k ; }
		public void setSecond(int k) { this.second=k ;}
	}
	static ArrayList<Integer> index;
	static ArrayList<Integer> value;
	static boolean v[];
	static int[] ans;
	static ArrayList<ArrayList<Integer>> al;
	static int[] a;
	public static void main(String args[])
	{
		InputReader in = new InputReader(System.in);
		OutputStream outputStream = System.out;
		PrintWriter out = new PrintWriter(outputStream);
		/*------------------------------My Code starts here------------------------------*/
		int i=0,n=in.nextInt(),m=in.nextInt(),p,q,j;
		a=nextIntArray(in, n);
		al=new ArrayList<>();
		for(i=0;i<=n;i++)
			al.add(new ArrayList<Integer>());
		v=new boolean[n+1];
		ans=new int[n+1];
		index=new ArrayList<>();
		value=new ArrayList<>();
		for(i=0;i<m;i++)
		{
			p=in.nextInt()-1;
			q=in.nextInt()-1;
			al.get(p).add(q);
			al.get(q).add(p);
		}
		for(i=0;i<n;i++)
		{
			if(!v[i])
			{
				index.clear();
				value.clear();
				dfs(i);
				Collections.sort(index);
				Collections.sort(value,Collections.reverseOrder());
				for(j=0;j<index.size();j++)
					ans[index.get(j)]=value.get(j);
			}
		}
		for(i=0;i<n;i++)
			out.print(ans[i]+" ");
		out.close();
		/*------------------------------The End------------------------------------------*/
	}
	private static void dfs(int i) 
	{
		v[i]=true;
		index.add(i);
		value.add(a[i]);
		for(Integer j:al.get(i))
		{
			if(!v[j])
				dfs(j);
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