import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;

 
 
public class Main {
	public static void main(String[] args) throws IOException{
		  	FastScanner sc = new FastScanner();
			PrintWriter out = new PrintWriter(System.out);
			String str = sc.nextToken();
			String a = sc.nextToken();
			String b = sc.nextToken();
			int c[]=new int[27];
			int cc[]=new int[27];
			int ccc[]=new int[27];
			for(int i=0;i<str.length();i++){
				char t = str.charAt(i);
				c[t-'a']++;
			}
			for(int i=0;i<a.length();i++){
				char t = a.charAt(i);
				cc[t-'a']++;
			}
			for(int i=0;i<b.length();i++){
				char t = b.charAt(i);
				ccc[t-'a']++;
			}
			int f=-1;
			int l=-1;
			for(int i=0;i<=10000;i++)
			{
				if(!can(i,c,cc))continue;
				int min=100000000;
				for(int j=0;j<26;j++){
					if(ccc[j]>0)min=Math.min(min, (c[j]-i*cc[j])/ccc[j]);
				}
				if(min<0)continue;
				if(i+min>f+l){
					f=i;
					l=min;
				}
			}
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<f;i++){
				sb.append(a);
				
			}
			for(int i=0;i<l;i++)
				sb.append(b);
			
			for(int i=0;i<26;i++)
				c[i]=c[i]-f*cc[i]-l*ccc[i];
			for(int i=0;i<26;i++)
				while(c[i]-->0)
					sb.append((char)(i+'a'));
			System.out.println(sb);
			
			
			
	}
	static boolean can(int x,int []c , int[] cc){
		for(int i=0;i<26;i++)
			if(cc[i]*x > c[i])
				return false;
		return true;
	}

	

	
	
		
	
			
		
	

			

			
			
			
	
	



	
	
			    
			


			
			
	
	
	

			
	
		
	
	
	
		

			

		

	
	

	
	
	

			
						
			

	
	

		
		
		


















































	static void shuffle(int[] a)
	{
		int n = a.length;
		for(int i = 0; i < n; ++i)
		{
			int r = i + (int)(Math.random() * (n - i));
			int tmp = a[r];
			a[r] = a[i];
			a[i] = tmp;
		}
	}


	static void generate(int[] p, int L, int R) {
		  if (L == R) {
		      
		      
		  }else { 
		    for (int i = L; i <= R; i++) {
		    	int tmp = p[L]; p[L] = p[i]; p[i] = tmp;//swap  do
		      generate(p, L+1, R);//recurse 
		      tmp = p[L]; p[L] = p[i]; p[i] = tmp;//unswap  undo

		    }
		  }
		}


















































































































	
}
	 


	 class point implements Comparable{
		int x ;int y ;
		point(int x ,int y){
			this.x=x;
			this.y=y;
		}
		@Override
		public int compareTo(Object arg0) {
			// TODO Auto-generated method stub
			point p = (point)arg0;
			if(p.x>this.x)return -1;
			if(p.x<this.x)return 1;
			if(p.x==this.x){
				if(p.y>this.y)return -1;
				if(p.y<this.y)return 1;
			}
			return 0;
		}
		
	}
	
	
	











	
 
 
 

 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
class FastScanner {
 
 
 
 
    BufferedReader br;
    StringTokenizer st;
 
    public FastScanner() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }
 
    public FastScanner(String s) {
        try {
            br = new BufferedReader(new FileReader(s));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
 
    String nextToken() {
        while (st == null || !st.hasMoreElements()) {
            try {
 
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }
 
    int nextInt() {
        return Integer.parseInt(nextToken());
    }
 
    long nextLong() {
        return Long.parseLong(nextToken());
    }
 
    double nextDouble() {
        return Double.parseDouble(nextToken());
    }
 
 
}