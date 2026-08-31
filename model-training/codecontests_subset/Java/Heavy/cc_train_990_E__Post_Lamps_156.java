 import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class E
{

	
	
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		PrintWriter pw=new PrintWriter(System.out);
		 int n=sc.nextInt(),m=sc.nextInt();
		 int k=sc.nextInt();
		boolean[] notFree=new boolean[n];
		for(int i=0;i<m;i++)
			notFree[sc.nextInt()]=true;
		
		int []c=new int [k];
		for(int i=0;i<k;i++)
			c[i]=sc.nextInt();
		if(notFree[0])
		{
			System.out.println(-1);
			return;
		}
		int last=0;
		int []prev=new int [n];
		for(int i=1;i<n;i++)
		{
			if(notFree[i])
				prev[i]=last;
			else
				last=i;
		}
		long ans=Long.MAX_VALUE;
		outer: for(int p=1;p<=k;p++)
		{
			int curr=0;
			long cnt=1;
			
			while(curr+p<n)
			{
				int nxt=curr+p;
				if(notFree[nxt])
					nxt=prev[nxt];
				if(nxt==curr)
					continue outer;
				 curr=nxt;
				cnt++;
			}
			ans=Math.min(ans, cnt*c[p-1]);
		}
		pw.println(ans==Long.MAX_VALUE?-1:ans);
		pw.close();
		
		
	}
	
	static class Scanner
	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public Scanner( String s) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(s));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public boolean ready() throws IOException {
			return br.ready();
		}
	}
}