import java.util.*;
import java.io.*;

public class codechef
{
	static long mod=1000000007;
	public static void main(String[] args) throws IOException
	{
		FastReader in=new FastReader();
		int n=in.nextInt();
		int s=in.nextInt();
		int m=n/2;
		ArrayList<Integer> al=new ArrayList<>();
		for(int i=0;i<n;i++)
			al.add(in.nextInt());
		Collections.sort(al);
		int ind=Collections.binarySearch(al,s);
		if(ind<0)
			ind=-ind-1;
		if(ind<m && al.get(ind)<=s)
			ind++;
		else if(ind>m)
			ind--;
		long ans=0;
		if(ind<m)
		{
			for(int i=ind;i<=m;i++)
			{
				ans+=al.get(i)-s;
			}
		}
		else if(ind>m)
		{
			for(int i=ind;i>=m;i--)
			{
				ans+=s-al.get(i);
			}
		}
		else ans=al.get(m)>=s?al.get(m)-s:s-al.get(m);
		System.out.println(ans);
	}
}

class FastReader
{
	BufferedReader br;
	StringTokenizer st;
 
	public FastReader()
	{
		br=new BufferedReader(new InputStreamReader(System.in));
	}
 
	public String next() throws IOException
	{
		if(st==null || !st.hasMoreElements())
		{
			st=new StringTokenizer(br.readLine());
		}
		return st.nextToken();
	}
 
	public int nextInt() throws IOException
	{
		return Integer.parseInt(next());
	}
 
	public long nextLong() throws IOException
	{
		return Long.parseLong(next());
	}
}