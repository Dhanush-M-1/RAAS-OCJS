import java.io.*;
import java.util.*;
public final class zq_string
{
    static FastScanner sc=new FastScanner(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out=new PrintWriter(System.out);

	public static void main(String args[]) throws Exception
	{
		char[] a=sc.next().toCharArray(),b=sc.next().toCharArray(),c=sc.next().toCharArray();
		int[] cnt1=new int[123],cnt2=new int[123],cnt3=new int[123];
		int min_len=Math.min(b.length,c.length);
		for(int i=0;i<a.length;i++)
		{
			cnt1[a[i]]++;
		}
		for(int i=0;i<b.length;i++)
		{
			cnt2[b[i]]++;
		}
		for(int i=0;i<c.length;i++)
		{
			cnt3[c[i]]++;
		}
		int max=0,acount=0,bcount=0;
		for(int i=0;i<=a.length/(min_len);i++)
		{
			boolean now=false;
			for(int j=97;j<=122;j++)
			{
				if(cnt1[j]<cnt2[j]*i)
				{
					now=true;
					break;
				}
			}
			if(now)
			{
				break;
			}
			else
			{
				int min=Integer.MAX_VALUE;
				for(int j=97;j<=122;j++)
				{
					if(cnt3[j]>0)
					{
						int val=cnt1[j]-(cnt2[j]*i);
						int curr_min=val/cnt3[j];
						min=Math.min(min,curr_min);
						if(min==0)
						{
							break;
						}
					}
				}
				if(i+min>max)
				{
					max=i+min;
					acount=i;
					bcount=min;
				}
			}
		}
		String ans="";
		String s1=new String(b),s2=new String(c);
		int acount1=acount,bcount1=bcount;
		while(acount>0)
		{
			out.print(s1);
			acount--;
		}
		while(bcount>0)
		{
			out.print(s2);
			bcount--;
		}
		for(int i=97;i<=122;i++)
		{
			int curr_cnt=cnt1[i]-(cnt2[i]*acount1)-(cnt3[i]*bcount1);
			while(curr_cnt>0)
			{
				out.print((char)i);
				curr_cnt--;
			}
		}
		out.println("");
		out.close();
	}
}
class FastScanner
{
    BufferedReader in;
    StringTokenizer st;

    public FastScanner(BufferedReader in) {
        this.in = in;
    }
	
    public String nextToken() throws Exception {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }
	
	public String next() throws Exception {
		return nextToken().toString();
	}
	
    public int nextInt() throws Exception {
        return Integer.parseInt(nextToken());
    }

    public long nextLong() throws Exception {
        return Long.parseLong(nextToken());
    }

    public double nextDouble() throws Exception {
        return Double.parseDouble(nextToken());
    }
}