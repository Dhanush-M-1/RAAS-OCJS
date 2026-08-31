import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
 
 
public class q5 {
	
	static long power(long x, long y, long p) 
    { 
        // Initialize result 
        long res = 1;      
         
        // Update x if it is more   
        // than or equal to p 
        x = x % p;  
      
        while (y > 0) 
        { 
            
            if((y & 1)==1) 
                res = (res * x) % p; 
            y = y >> 1;  
            x = (x * x) % p;  
        } 
        return res; 
    } 
	
    
  
	
 
	public static void main(String[] args) throws IOException {
	
	Reader.init(System.in);
	PrintWriter out=new PrintWriter(System.out);
	int n=Reader.nextInt();
	long mod=998244353;
	long[] pow=new long[25];
	pow[0]=1;
	for(int i=1;i<25;i++) {
		pow[i]=pow[i-1]*10;
		pow[i]%=mod;
	}
	
	long ans=0;
	int[] count=new int[12];
	String[] arr=new String[n];
	for(int i=0;i<n;i++) {
		arr[i]=Reader.next();
		int l=arr[i].length();
		count[l]++;
	}
	Arrays.sort(arr,new Comparator<String>() {
		public int compare(String a, String b) {
			return a.length()-b.length();
		}
	});
	int[] index=new int[12];
	int min=arr[0].length();
	int max=arr[n-1].length();
	int prev=min;
	index[min]=0;
	for(int i=1;i<n;i++) {
		if(arr[i].length()!=prev) {
			prev=arr[i].length();
			index[prev]=i;
		}
	}
	for(int i=min;i<=max;i++) {
		for(int j=index[i];j<n;j++) {
			int p1=0,p2=1;
			int k=arr[j].length()-1;
			int cc=0;
			int l=count[i];
			if(k+1==i) l=n-index[i];
			for(;cc<i;k--) {
				cc++;
				int c=arr[j].charAt(k)-'0';
				ans+=(l*c)%mod* pow[p1];
				ans%=mod;
				ans+=(l*c)%mod* pow[p2];
				ans%=mod;
				p1+=2;p2+=2;
			}
			p2=2*i;
			l=2*count[i];
			for(;k>=0;k--) {
				int c=arr[j].charAt(k)-'0';
				ans+=(l*c)%mod* pow[p2];
				ans%=mod;
				p2+=1;
			}
		}
	}
	out.print(ans);
	
	
	out.flush();
	}
}




 
 
 
class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;
    /** call this method to initialize reader for InputStream */
    static void init() throws IOException {
    	 reader = new BufferedReader(
                 new FileReader("detect.in"));
    tokenizer = new StringTokenizer("");
    }
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }
    /** get next word */
    static String nextLine() throws IOException{
    	return reader.readLine();
    }
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }
    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
    static long nextLong() throws IOException {
        return Long.parseLong( next() );
    }
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}