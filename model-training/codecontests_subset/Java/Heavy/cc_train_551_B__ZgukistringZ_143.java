import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ZquikStringZ {
public static int solve(int []a,int []b)
{
	int ans=1000000;
	for(int i=0;i<26;i++)
	{
		int x=a[i];int y=b[i];
		if(y==0)
			continue;
		ans=Math.min(ans, x/y);
	}
	return ans;
}
public static int [] removeCount(int []a,int []b,int len)
{
	for(int i=0;i<26;i++)
	{
		int x=b[i]*len;
		a[i]-=x;
	}
	return a;
}
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		String a=sc.nextLine();String b=sc.nextLine();String c=sc.nextLine();
		int [] f1=new int [26];int [] f2=new int [26];int [] f3=new int [26];
		for(char x:a.toCharArray())
			f1[x-'a']++;
		for(char x:b.toCharArray())
			f2[x-'a']++;
		for(char x:c.toCharArray())
			f3[x-'a']++;
		int ans=solve(f1,f2);
		int rep1=0;int rep2=0;
		for(int i=0,x=ans;i<=x;i++)
		{
			int []z=removeCount(f1.clone(),f2,i);
			int o=i+solve(z,f3);
			if(o>=ans)
			{
				ans=o;
				rep1=i;
				
			}
			
		}
		rep2=ans-rep1;
		for(int i=1;i<=rep1;i++)
			System.out.print(b);
		removeCount(f1,f2,rep1);
		for(int i=1;i<=rep2;i++)
			System.out.print(c);
		removeCount(f1,f3,rep2);
		for(int i=0;i<26;i++)
		{
			char x=(char)('a'+i);
			while(f1[i]-->0)
				System.out.print(x);
		}
	}	
}
class Scanner 
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
 
	public int nextInt() throws IOException {return Integer.parseInt(next());}
 
	public long nextLong() throws IOException {return Long.parseLong(next());}
 
	public String nextLine() throws IOException {return br.readLine();}
 
	public double nextDouble() throws IOException
	{
		String x = next();
		StringBuilder sb = new StringBuilder("0");
		double res = 0, f = 1;
		boolean dec = false, neg = false;
		int start = 0;
		if(x.charAt(0) == '-')
		{
			neg = true;
			start++;
		}
		for(int i = start; i < x.length(); i++)
			if(x.charAt(i) == '.')
			{
				res = Long.parseLong(sb.toString());
				sb = new StringBuilder("0");
				dec = true;
			}
			else
			{
				sb.append(x.charAt(i));
				if(dec)
					f *= 10;
			}
		res += Long.parseLong(sb.toString()) / f;
		return res * (neg?-1:1);
	}
 
	public boolean ready() throws IOException {return br.ready();}
 
 
}