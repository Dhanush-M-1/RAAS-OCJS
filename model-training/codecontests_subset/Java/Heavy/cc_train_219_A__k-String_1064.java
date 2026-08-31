import java.util.*;
import java.io.*;
import java.math.*;

public class Main{
  /*
  .
  .
  .
  .
  .
  .
  .
  some constants
  .
  */
  static int gcd(int a,int b){
    while(a!=0 && b!=0){
      if(a>b){
        a%=b;
      }
      else{
        b%=a;
      }
    }
    return (a+b);
  }
  /*
  .
  .
  .
  if any
  .
  .
  */
  public static void main(String[] args) throws IOException{
		/*
		.
		.
		.
		.
		.
		.
    */
    int k=ni();
    String str=ns();
    int arr[]=new int[26];
    int i,j;
    int g=0;
    String ans="";
    int n=str.length();
    for(i=0;i<n;i++){
      arr[str.charAt(i)-'a']++;
    }
    for(i=0;i<26;i++){
      g=gcd(g,arr[i]);
    }
    if(g%k==0){
      for(i=0;i<26;i++){
        for(j=0;j<(arr[i])/k;j++){
          ans+=(char)('a'+i);
        }
      }
      for(i=0;i<k;i++)
        System.out.print(ans);
    }
    else{
      sop("-1");
    }
    /*

		.
		.
		.
		.
		.
		.
		.
		*/
	}
	/*
	temporary functions
	.
	.
	*/
	/*
	fuctions
	.
	.
	.
	.
	.
	.
	.
	.
	.
	.
	.
	.
	.
	.
	.
	.
	.
	abcdefghijklmnopqrstuvwxyz
	.
	.
	.
	.
	.
	.
	*/
	static int modulo(int j,int m){
		if(j<0)
			return m+j;
		  if(j>=m)
			return j-m;

			return j;
	}
	static final int mod=1000000007;
	static final double eps=1e-8;
	static final long inf=100000000000000000L;
	static final boolean debug=true;
	static Reader in=new Reader();
	static StringBuilder ans=new StringBuilder();
	static long powm(long a,long b,long m){
		long an=1;
		long c=a;
		while(b>0){
			if(b%2==1)
				an=(an*c)%m;
			c=(c*c)%m;
			b>>=1;
		}
		return an;
	}
	static Random rn=new Random();
	static void sop(Object a){System.out.println(a);}
	static int ni(){return in.nextInt();}
	static int[] nia(int n){int a[]=new int[n];for(int i=0;i<n;i++)a[i]=ni();return a;}
	static long nl(){return in.nextLong();}
	static long[] nla(int n){long a[]=new long[n];for(int i=0; i<n; i++)a[i]=nl();return a;}
	static String ns(){return in.next();}
	static String[] nsa(int n){String a[]=new String[n];for(int i=0; i<n; i++)a[i]=ns();return a;}
	static double nd(){return in.nextDouble();}
	static double[] nda(int n){double a[]=new double[n];for(int i=0;i<n;i++)a[i]=nd();return a;}
	static class Reader{
		public BufferedReader reader;
		public StringTokenizer tokenizer;
		public Reader(){
			reader=new BufferedReader(new InputStreamReader(System.in),32768);
			tokenizer=null;
		}
		public String next(){
			while(tokenizer==null || !tokenizer.hasMoreTokens()){
				try{
					tokenizer=new StringTokenizer(reader.readLine());
				}
				catch(IOException e){
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}
		public int nextInt(){
			return Integer.parseInt(next());
		}
		public long nextLong(){
			return Long.parseLong(next());
		}
		public double nextDouble(){
			return Double.parseDouble(next());
		}
	}
}
