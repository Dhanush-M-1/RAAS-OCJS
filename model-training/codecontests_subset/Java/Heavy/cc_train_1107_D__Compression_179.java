import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main
{
    static final long mod=(int)1e9+7;
    static int n;
    public static void main(String[] args) throws Exception
    {
    	FastReader in=new FastReader();
    	PrintWriter pw=new PrintWriter(System.out);
    	n=in.nextInt();
    	int[][] mat=new int[n][n];
    	for(int i=0;i<n;i++)
    	{
    		mat[i]=hexToBin(in.next().toCharArray());
    	}
    	int ans=n,o1=0,z1=0,o2=0,z2=0;
    	for(int i=0;i<n;i++)
    	{
    		o1=z1=o2=z2=n;
    		for(int j=0;j<n;j++)
    		{
    			if(mat[i][j]==1)
    			{
    				ans=gcd(ans,z1);
    				z1=0;
    				o1++;
    			}
    			else
    			{
    				ans=gcd(ans,o1);
    				o1=0;
    				z1++;
    			}
    			if(mat[j][i]==1)
    			{
    				ans=gcd(ans,z2);
    				z2=0;
    				o2++;
    			}
    			else
    			{
    				ans=gcd(ans,o2);
    				o2=0;
    				z2++;
    			}
    		}
    		ans=gcd(ans,o1);
    		ans=gcd(ans,z1);
    		ans=gcd(ans,o2);
    		ans=gcd(ans,z2);
    	}
    	pw.print(ans);
    	pw.flush();
    }

    static int[] hexToBin(char[] s)
    {
    	int[] arr=new int[n];
    	int j=n-1;
    	for(int i=s.length-1;i>=0;i--)
    	{
    		int a=Character.isDigit(s[i])?s[i]-'0':s[i]-'A'+10;
    		int k=0;
    		while(k<4)
    		{
    			if(((a>>k)&1)==1)
    				arr[j]=1;
    			j--;
    			k++;
    		}
    	}

    	return arr;
    }

    static int gcd(int a,int b)
    {
    	if(b==0)
    		return a;
    	return gcd(b,a%b);
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