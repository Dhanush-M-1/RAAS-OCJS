import java.io.*;
public class ProD {
	static StreamTokenizer in=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
	static int nextInt() throws IOException    
	{  
	    in.nextToken();    
	    return (int)in.nval;     
	}
	static String next() throws IOException    
	{  
	    in.nextToken();    
	    return in.sval;     
	}
	static PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out));
	static int n,k,a,b,q,c,x,y;
	static long s,ans,z;
	static long[] bit=new long[200005];
	static long[] bit2=new long[200005];
	static long[] m1=new long[200005];
	static long[] m2=new long[200005];
	static void add(int i,long x)
	{
		while(i<=n)
		{
			bit[i]+=x;
			i+=i&-i;
		}
	}
	static long sum(int i)
	{
		long s=0;
		while(i>0)
		{
			s+=bit[i];
			i-=i&-i;
		}
		return s;
	}
	static void add2(int i,long x)
	{
		while(i<=n)
		{
			bit2[i]+=x;
			i+=i&-i;
		}
	}
	static long sum2(int i)
	{
		long s=0;
		while(i>0)
		{
			s+=bit2[i];
			i-=i&-i;
		}
		return s;
	}

	public static void main(String[] args) throws IOException {
		//Scanner in=new Scanner(System.in);
		n=nextInt();k=nextInt();
		a=nextInt();b=nextInt();
		q=nextInt();
		while(q-->0)
		{
			c=nextInt();
			if(c==1)
			{
				x=nextInt();y=nextInt();
				z=Math.min(m1[x]+y,a)-m1[x];
				add(x,z);m1[x]+=z;
				s+=z;
				z=Math.min(m2[x]+y,b)-m2[x];
				add2(x,z);m2[x]+=z;
			}
			else
			{
				x=nextInt();
				ans=sum2(x-1)+s-sum(x+k-1);
				out.println(ans);
			}
		}
		out.flush();
	}
}
