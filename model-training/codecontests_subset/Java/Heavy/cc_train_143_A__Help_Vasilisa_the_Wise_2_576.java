import java.util.*;

import java.io.*;
public class main {
static FastScanner sc;
static PrintWriter pw;
    public static void main(String[] args) {
//	        Scanner sc = new Scanner(System.in);
    		sc = new FastScanner();
    		pw = new PrintWriter(System.out);

//	        int t = sc.ni();
//	        while(t-->0)
//	        {
//	        }
    		int r1=sc.ni(),r2=sc.ni(),c1=sc.ni(),c2=sc.ni(),d1=sc.ni(),d2=sc.ni(),a[][] = new int[2][2],fg=0;
    		for(int i=1;i<10;i++)
    		{
    			for(int j=1;j<10;j++)
    			{
    				for(int k=1;k<10;k++)
        			{
    					for(int l=1;l<10;l++)
    	    			{
    	    				if(i!=j&&j!=k&&k!=l&&l!=i)
    	    				{
    	    					a[0][0]=i;a[0][1]=j;a[1][0]=k;a[1][1]=l;
    	    					if(a[0][0]!=a[0][1]&& a[0][1]!=a[1][0]&&a[1][0]!=a[1][1]&&a[1][1]!=a[0][0] && a[0][0]!=a[1][0]&&a[0][1]!=a[1][1])
    	    					{
    	    						if(a[0][0]+a[0][1]==r1)
        	    					{
        	    						if(a[1][0]+a[1][1]==r2)
        	    						{
        	    							if(a[0][0]+a[1][0]==c1)
        	    							{
        	    								if(a[0][1]+a[1][1]==c2)
        	    								{
        	    									if(a[0][0]+a[1][1]==d1)
        	    									{
        	    										if(a[0][1]+a[1][0]==d2)
        	    										{
        	    											pw.println(a[0][0]+" "+a[0][1]);
        	    											pw.println(a[1][0]+" "+a[1][1]);
        	    											fg=1;
        	    										}
        	    									}
        	    								}
        	    							}
        	    						}
        	    					}
    	    					}
    	    				}
    	    			}
        			}
    			}
    		}
    		if(fg==0)
    		{
    			pw.println(-1);
    		}
	        pw.close();
    }


    static boolean check(int[][] a,int n,int m)
    {
    	for(int i=1;i<=n;i++)
    	{
    		for(int j=1;j<=m;j++)if(a[i][j]!=-1)return false;
    	}
    	return true;
    }
//    static boolean check2(int n,int d)
//    {
//    	while(n>d)
//		{
//				n -=d;
//				if(check(n,d))return true;
//		}
//    	return false;
//    }
//    static int sum(int n)
//    {
//    	if(n>=10)return n;
//    	else
//    	{
//    		sum(n);
//    	}
//    }
    static int gcd(int a,int b)
    {
    	if(b!=0)return gcd(b,a%b);
    	else return a;
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
 
        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in), 32768);
            st = null;
        }
 
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int ni() {
            return Integer.parseInt(next());
        }
 
        int[] intArray(int N) {
            int[] ret = new int[N];
            for (int i = 0; i < N; i++)
                ret[i] = ni();
            return ret;
        }
 
        long nl() {
            return Long.parseLong(next());
        }
 
        long[] longArray(int N) {
            long[] ret = new long[N];
            for (int i = 0; i < N; i++)
                ret[i] = nl();
            return ret;
        }
 
        double nd() {
            return Double.parseDouble(next());
        }
 
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}