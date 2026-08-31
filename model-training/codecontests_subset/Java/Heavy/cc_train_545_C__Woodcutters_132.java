import java.io.*;

import java.util.*;
/*


 */










public class C {
    static FastReader sc=null;
    
    public static void main(String[] args) {
		sc=new FastReader();
		int n=sc.nextInt();
		int dp[][]=new int[n][3];
		Pair p[]=new Pair[n];
		for(int i=0;i<n;i++)p[i]=new Pair(sc.nextInt(),sc.nextInt());
		Arrays.sort(p);
		dp[0][1]=1;
		if(checkRight(p,0))dp[0][2]=1;
		for(int i=1;i<n;i++) {
			for(int j=0;j<3;j++)dp[i][0]=Math.max(dp[i-1][j], dp[i][0]);
			if(checkLeft(p,i,p[i-1].r))dp[i][1]=Math.max(dp[i-1][2]+1, dp[i][1]);
			if(checkLeft(p,i,p[i-1].x))dp[i][1]=Math.max(dp[i-1][0]+1, dp[i][1]);
			if(checkLeft(p,i,p[i-1].x))dp[i][1]=Math.max(dp[i-1][1]+1, dp[i][1]);
			if(checkRight(p,i)) {
				for(int j=0;j<3;j++)dp[i][2]=Math.max(dp[i-1][j]+1, dp[i][2]);
			}
			
		}
		System.out.println(Math.max(dp[n-1][0], Math.max(dp[n-1][1], dp[n-1][2])));
		

		
	
	}
    static boolean checkLeft(Pair p[],int i,int c) {
    	if(i==0)return true;
    	return p[i].x-p[i].h>c;
    }
    static boolean checkRight(Pair p[],int i) {
    	if(i==p.length-1)return true;
    	return p[i].x+p[i].h<p[i+1].x;
    	
    }
    static class Pair implements Comparable<Pair>{
    	int x,h;
    	int l,r;
    	Pair(int x,int h){
    		this.x=x;
    		this.h=h;
    		l=x-h;
    		r=x+h;
    	}
		@Override
		public int compareTo(Pair o) {
			return this.x-o.x;
		}
    }
  
   
  
    
    static void ruffleSort(int a[]) {
        ArrayList<Integer> al=new ArrayList<>();
        for(int i:a)al.add(i);
        Collections.sort(al);
        for(int i=0;i<a.length;i++)a[i]=al.get(i);
    }
    static void ruffleSort(long a[]) {
        ArrayList<Long> al=new ArrayList<>();
        for(long i:a)al.add(i);
        Collections.sort(al);
        for(int i=0;i<a.length;i++)a[i]=al.get(i);
    }
    
    static int[] reverse(int a[]) {
        ArrayList<Integer> al=new ArrayList<>();
        for(int i:a)al.add(i);
        Collections.sort(al,Collections.reverseOrder());
        for(int i=0;i<a.length;i++)a[i]=al.get(i);
        return a;
    }
 
    static int gcd(int a,int b) {
		if(b==0)return a;
		else return gcd(b,a%b);
	}  
    static long gcd(long a,long b) {
		if(b==0)return a;
		else return gcd(b,a%b);
	}  
        
 
    
    
    
    static void print(long a[]) {
        for(long e:a) {
            System.out.print(e+" ");
        }
        System.out.println();
    }
    static void print(char a[]) {
        for(char e:a) {
            System.out.print(e);
        }
        System.out.println();
    }
    
    
    static void print(int a[]) {
        for(int e:a) {
            System.out.print(e+" ");
        }
        System.out.println();
    }
    
    
    static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
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
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
        int[] readArray(int n) {
            int a[]=new int [n];
            for(int i=0;i<n;i++) {
                a[i]=sc.nextInt();
            }
            return a;
        }
    } 
}
