import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import javax.sound.sampled.ReverbType;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
public class cf1{
	static public int GCD(int a, int b) {
		   if (b==0) return a;
		   return GCD(b,a%b);
		}
	static boolean[]prime;
	static ArrayList<Integer> primes;
	static void sieveOfEratosthenes(int n) 
    { 
        prime = new boolean[n+1]; 
        for(int i=0;i<=n;i++) 
            prime[i] = true; 
          
        for(int p = 2; p <=n; p++) 
        { 
           
            if(prime[p]) 
            { 
                //ans[(int)p]=c;
            	primes.add(p);
                for(long i = p*1l*p; i <= n; i += p) {
                	//if(ans[i]System.out.println(i);
                    prime[(int)i] = false; 
                    
                    
                }
                //c++;
            } 
        } 
       
    }
	static void dfs(int i,int p) {
		v[i]=true;
		if(p==0) {
			zero.add(i+1);
		}
		else {
			one.add(i+1);
		}
		for(int j:adj[i]) {
			if(!v[j])
				dfs(j,p^1);
		}
	}
	static boolean[]v;
	static LinkedList<Integer>[]adj;
	static LinkedList<Integer>zero;
	static LinkedList<Integer>one;
	
	static long[][]block;
	public static void main(String[] args) throws IOException {
		MScanner sc=new MScanner(System.in);
		//BufferedReader br=new BufferedReader((new InputStreamReader(System.in)));
		PrintWriter pw=new PrintWriter(System.out);
		n=sc.nextInt();
		block=new long[n][5];
		for(int i=0;i<n;i++) {
			int k=sc.nextInt();
			PriorityQueue<Integer>one=new PriorityQueue<Integer>(Collections.reverseOrder());
			PriorityQueue<Integer>two=new PriorityQueue<Integer>(Collections.reverseOrder());
			PriorityQueue<Integer>three=new PriorityQueue<Integer>(Collections.reverseOrder());
			for(int j=0;j<k;j++) {
				int c=sc.nextInt();
				if(c==1) {
					one.add(sc.nextInt());
				}
				else {
					if(c==2) {
						two.add(sc.nextInt());
					}
					else {
						three.add(sc.nextInt());
					}
				}
			}
			long max1=(long)(-7e9);
			if(one.size()!=0)
				max1=one.poll();
			long max11=(long)(-7e9);
			if(one.size()!=0)
				max11=one.poll();
			long max111=(long)(-7e9);
			if(one.size()!=0) {
				max111=one.poll();
			}
			long max2=(long)(-7e9);
			if(two.size()>0) {
				max2=two.poll();
			}
			long max3=(long)(-7e9);
			if(three.size()>0) {
				max3=three.poll();
			}
			block[i][0]=Math.max(Math.max(max1,max2),max3);
			block[i][1]=Math.max(max1+max11,max1+max2);
			block[i][2]=max1+max11+max111;
			block[i][3]=Math.max(max1*2+max11,Math.max(max1+max2*2,max1*2+max2));
			block[i][4]=max1*2+max11+max111;
		}
		memo=new long[n][10];
		for(int i=0;i<n;i++) {
			Arrays.fill(memo[i],-1);
			//System.out.println(block[i][0]+" "+block[i][1]+" "+block[i][2]+" "+block[i][3]+" "+block[i][4]);
		}
		pw.println(dp(0,0));
		pw.flush();
		
 
	}
	static long[][]memo;
	static int n;
	static long dp(int i,int taken) {
		if(i==n)return 0;
		if(memo[i][taken]!=-1)return memo[i][taken];
		if(taken==7) {
			return memo[i][taken]=Math.max(Math.max(dp(i+1,0)+block[i][4],dp(i+1,taken)),Math.max(dp(i+1,8)+block[i][0],dp(i+1,9)+block[i][1]));
		}
		if(taken==8) {
			return memo[i][taken]=Math.max(Math.max(dp(i+1,0)+block[i][3],dp(i+1,taken)),Math.max(dp(i+1,1)+block[i][4],dp(i+1,9)+block[i][0]));
		}
		if(taken==9) {
			return memo[i][taken]=Math.max(Math.max(dp(i+1,0)+2*block[i][0],dp(i+1,taken)),Math.max(dp(i+1,1)+block[i][3],dp(i+1,2)+block[i][4]));
		}
		return memo[i][taken]=Math.max(Math.max(dp(i+1,(taken+1)%10)+block[i][0],dp(i+1,taken)),Math.max(dp(i+1,(taken+2)%10)+block[i][1],dp(i+1,(taken+3)%10)+block[i][2]));
	}
	static class tri implements Comparable<tri>{
    	int l;int idx;
    	tri(int x,int z){
    		l=x;idx=z;
    	}
		@Override
		public int compareTo(tri o) {
			if(l!=o.l) {
				if(l>o.l)return 1;
				return -1;
			}
			return idx-o.idx;
		}
		public boolean equals(tri o) {
			if(this.compareTo(o)==0)return true;
			return false;
		}
		public String toString() {
			return "("+l+" "+idx+")";
		}
    }
	static class MScanner 
	{
	    StringTokenizer st;
	    BufferedReader br;

	    public MScanner(InputStream s){    br = new BufferedReader(new InputStreamReader(s));}

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
}