import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

public class a248 {

	static class Task {		
		
		public void Solve(InputReader in, PrintWriter o)
		{
			int n=in.nextInt();
			long sum=0;
			int a100=0,a200=0;
			for(int i=0;i<n;i++)
			{
				if(in.nextInt()==100)
					a100++;
				else
					a200++;
			}
			sum=a100*100+a200*200;
			sum/=100;
			if(sum%2!=0)
				o.println("NO");
			else
			{
				if((sum/2)%2!=0)
				{
					if(a100<2)
						o.println("NO");
					else
						o.println("YES");
				}
				else
				{
					o.println("YES");
				}
				
				
			}
	    }
     }
	
	  public static int SieveOfErathostenes(int n,boolean sieve[]){
	  		int cnt = 0;
	  		for(int i = 2 ; i <= n ; i++)
	  			if(sieve[i] == false){
	  			    cnt++;
	  				for(int j = i + i ; j <= n ; j += i)
	  					sieve[j] = true;
	  			}
	  		return cnt;	
	  	}


	
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        solver.Solve(in,out);
        out.close();
    }
  
    static int[][] sort2D(int arr[][]){
        Arrays.sort(arr,new java.util.Comparator<int[]>(){
        public int compare(int[] a, int[] b) {
            return Integer.compare(a[0], b[0]);
        }});
        return arr;
    }
    
	static int[] di={1,0,-1,0,1,-1,-1,1};
	static int[] dj={0,1,0,-1,1,1,-1,-1};
    
	static class point{
		int x;int y;
		public point(int x,int y){
			this.x=x;
			this.y=y;
		}
	}

    static void sort(int arr[]){
		int cnt[]=new int[(1<<16)+1];
		int ys[]=new int[arr.length];	
		for(int j=0;j<=16;j+=16){
			Arrays.fill(cnt,0);
			for(int x:arr){cnt[(x>>j&0xFFFF)+1]++;}
			for(int i=1;i<cnt.length;i++){cnt[i]+=cnt[i-1];}
			for(int x:arr){ys[cnt[x>>j&0xFFFF]++]=x;}
			{ final int t[]=arr;arr=ys;ys=t;}
		}
		if(arr[0]<0||arr[arr.length-1]>=0)return;
		int i,j,c;
		for(i=arr.length-1,c=0;arr[i]<0;i--,c++){ys[c]=arr[i];}
		for(j=arr.length-1;i>=0;i--,j--){arr[j]=arr[i];}
		for(i=c-1;i>=0;i--){arr[i]=ys[c-1-i];}
	}
    
    static int lcm(int a,int b){return a*b/gcd(a,b);}
    static int abs(int x){if(x>=0)return x;else return -x;}
    static int gcd(int a,int b){return b==0?a:gcd(b,a%b);} 
    static int min(int x,int y){return x<y?x:y;}
    static int min(int x,int y,int z){return x<y?(x<z?x:z):(y<z?y:z);}
    static int max(int x,int y){return x>y?x:y;}
    static int max(int x,int y,int z){return x>y?(x>z?x:z):(y>z?y:z);}
    
    static void joutArray(int arr[]){
    	for(int i=0;i<arr.length;i++){
    		System.out.print(arr[i]+" ");
    	}
    	System.out.println();
    }
    
    static void joutArray(int arr[][],int n,int m){
    	for(int i=0;i<n;i++){
    		for(int j=0;j<m;j++)
    		System.out.print(arr[i][j]+" ");
    		System.out.println();
    	}
    	System.out.println();
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
        
        public String nextLine() {
			String fullLine=null;
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					fullLine=reader.readLine();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
				return fullLine;
			}
			return fullLine;
		}

        public int nextInt() {
            return Integer.parseInt(next());
        }
        
        public long nextLong() {
        	return Long.parseLong(next());
        }
        
        public double nextDouble() {
        	return Double.parseDouble(next());
        }
        
        public int[] nextIntArray(int n) {
        	int arr[]=new int[n];
        	for(int i=0;i<n;i++)
        		arr[i]=nextInt();
        	return arr;
        }
        
        public char[] nextCharArray(){
        	char arr[]=next().toCharArray();
        	return arr;
        }
        
        public HashMap<Integer,Integer> inHashMap(int n){
        	HashMap<Integer,Integer> hm=new HashMap<>();
        	for(int i=0;i<n;i++){
    			int num=nextInt();
    			hm.put(num,hm.get(num)==null?1:hm.get(num)+1);
    		}
        	return hm;
        }
     }
    
   }