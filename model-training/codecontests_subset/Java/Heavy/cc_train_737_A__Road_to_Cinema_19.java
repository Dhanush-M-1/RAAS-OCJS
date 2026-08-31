import java.io.*;
import java.util.*;
public 	class Main
{
	static class InputReader {
 
	private InputStream stream;
	private byte[] buf = new byte[8192];
	private int curChar, snumChars;
	private SpaceCharFilter filter;
 
	public InputReader(InputStream stream) {
	    this.stream = stream;
	}
 
	public int snext() {
	    if (snumChars == -1)
		throw new InputMismatchException();
	    if (curChar >= snumChars) {
		curChar = 0;
		try {
		    snumChars = stream.read(buf);
		} catch (IOException e) {
		    throw new InputMismatchException();
		}
		if (snumChars <= 0)
		    return -1;
	    }
	    return buf[curChar++];
	}
 
	public int nextInt() {
	    int c = snext();
	    while (isSpaceChar(c))
		c = snext();
	    int sgn = 1;
	    if (c == '-') {
		sgn = -1;
		c = snext();
	    }
	    int res = 0;
	    do {
		if (c < '0' || c > '9')
		    throw new InputMismatchException();
		res *= 10;
		res += c - '0';
		c = snext();
	    } while (!isSpaceChar(c));
	    return res * sgn;
	}
 
	public long nextLong() {
	    int c = snext();
	    while (isSpaceChar(c))
		c = snext();
	    int sgn = 1;
	    if (c == '-') {
		sgn = -1;
		c = snext();
	    }
	    long res = 0;
	    do {
		if (c < '0' || c > '9')
		    throw new InputMismatchException();
		res *= 10;
		res += c - '0';
		c = snext();
	    } while (!isSpaceChar(c));
	    return res * sgn;
	}
 
	public int[] nextIntArray(int n) {
	    int a[] = new int[n];
	    for (int i = 0; i < n; i++)
		a[i] = nextInt();
	    return a;
	}
 
	public String readString() {
	    int c = snext();
	    while (isSpaceChar(c))
		c = snext();
	    StringBuilder res = new StringBuilder();
	    do {
		res.appendCodePoint(c);
		c = snext();
	    } while (!isSpaceChar(c));
	    return res.toString();
	}
 
	public boolean isSpaceChar(int c) {
	    if (filter != null)
		return filter.isSpaceChar(c);
	    return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}
 
	public interface SpaceCharFilter {
	    public boolean isSpaceChar(int ch);
	}
}
	static class FastReader
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
				try{
				st= new StringTokenizer(br.readLine());
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
		double nextDouble()
		{
			return Double.parseDouble(next());

		}
		String nextLine()
		{
			String s="";
			try
			{
				s=br.readLine();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			return s;
		}
		Long nextLong()
		{
			return Long.parseLong(next());
		}
	}

		static class Car implements Comparable<Car>
		{
				long c;
				long v;
				public Car(long c,long v)
				{
					this.c=c;
					this.v=v;
				}
				public int compareTo(Car k)
				{
					if(v==k.v)
						return 0;
					else
					{
						if(v>k.v)
							return 1;
						else
							return -1;
					}
				} 
		}
	public static void main(String ar[])
	{
		InputReader s=new InputReader(System.in);
		PrintWriter out=new PrintWriter(System.out);
		int n=s.nextInt();
		int k=s.nextInt();
		long d=s.nextLong();
		long t=s.nextLong();
		ArrayList<Car> a=new ArrayList<Car>();
		for(int j=0;j<n;j++)
			a.add(new Car(s.nextLong(),s.nextLong()));
		Collections.sort(a);
		int g[]=new int[k+1];
		for(int j=1;j<=k;j++)
			g[j]=s.nextInt();
		Arrays.sort(g);
		//System.out.println("hello 1");
		int gd[]=new int[k+2];
		for(int j=1;j<=k;j++)
		{
			//int temp=s.nextInt();
			gd[j]=g[j]-g[j-1];
			//System.out.println("j== "+j+" gd[j] = = "+gd[j]);
			//lastg=temp;
		}	
		gd[k+1]=(int)d-g[k];
		//for(int p=1;p<=k+1;p++)
		//	System.out.print(gd[p]+" " );
		int lastg=0;
		int l=0,r=n-1;
		int mid=(l+r)/2;
		int minmid=-1;
		while(l<=r)
		{
			mid=(l+r)/2;
			long t1=0;
			int x;
			for( x=1;x<=k+1;x++)
			{
				long temp=Math.round(Math.min(gd[x],(int)(a.get(mid).v-gd[x])));
				if(temp<0)
					break;
				t1+=2*gd[x]-temp;
			}
			if(t1>t || x!=k+2 )
				l=mid+1;
			else
			{
				//System.out.println("the following capacity satisfied   "+a.get(mid).v + "with t1 = = "+t1);
				minmid=mid;
				r=mid-1	;
			}
		}
	//	System.out.println("minimum capacity   "+a.get(minmid).v);
		long mincost=Long.MAX_VALUE;
		if(minmid==-1)
			out.print("-1");
		else
			{
				for(int j=minmid;j<n;j++)
					mincost=Math.min(mincost,a.get(j).c);
				out.print(mincost);
			}
		/*int g[]=new int[k+1];
		for(int j=1;j<=k;j++)
			g[j]=s.nextInt();
		Arrays.sort(g);
		//for(int p=1;p<=k;p++)
		//	System.out.print(g[p]+" " );
		for(int j=1;j<=k;j++)
		{
			//int temp=s.nextInt();
			gd[j]=g[j]-g[j-1];
			//System.out.println("j== "+j+" gd[j] = = "+gd[j]);
			//lastg=temp;
		}	
		//System.out.println("hello 2");
		gd[k+1]=(int)d-g[k];
		Arrays.sort(gd);
		//for(int p=1;p<=k+1;p++)
		//	System.out.print(gd[p]+" " );
		//System.out.println();
		for(int j=n-1;j>=0;j--)
		{
			//System.out.println("   a(j) = = = "+a.get(j).v+" gd[k+1] = = "+gd[k+1] );
			if(a.get(j).v<gd[k+1])
				{	//	System.out.println("removing = ==  = "+ j);
					a.remove(j);
				}
		}
		int j;
		for( j=0;j<a.size();j++)
		{
			long t1=0;
			for(int x=1;x<=k+1;x++)
				t1+=2*gd[x]-Math.round(Math.min(gd[x],(int)(a.get(j).v-gd[x])));
		//	out.println(a.get(j).c+" " +t1);
			if(t1<=t)
			{
				out.print(a.get(j).c);
				break;
			}

		}
		if(j==a.size())
			out.print("-1");*/
		out.close();
	}
}