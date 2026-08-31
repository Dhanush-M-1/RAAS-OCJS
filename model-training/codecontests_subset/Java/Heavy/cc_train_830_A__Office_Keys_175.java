import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class q5 {
	
	
	public static void main(String[] args) throws IOException {
		
		Reader.init(System.in);
		PrintWriter out=new PrintWriter(System.out);
		StringBuffer output=new StringBuffer("");
		int n=Reader.nextInt(),k=Reader.nextInt(),p=Reader.nextInt();
		int[] a1=new int[n];
		int[] a2=new int[k];
		for(int i=0;i<n;i++)a1[i]=Reader.nextInt();
		for(int i=0;i<k;i++)a2[i]=Reader.nextInt();
		Arrays.sort(a1);
		Arrays.sort(a2);
		int[][] dp=new int[n][k];
		for(int i=0;i<n;i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
		for(int i=0;i<k;i++) {
			if(i==0) {
				dp[0][i]=Math.min(Math.abs(a1[0]-a2[i])+Math.abs(a2[i]-p), dp[0][i]);
			}
			else {
				dp[0][i]=Math.min(Math.abs(a1[0]-a2[i])+Math.abs(a2[i]-p), dp[0][i-1]);
			}
		}
		for(int i=1;i<n;i++) {
			for(int j=i;j<k;j++) {
				dp[i][j]=Math.max(dp[i-1][j-1], Math.abs(a1[i]-a2[j])+Math.abs(a2[j]-p));
				dp[i][j]=Math.min(dp[i][j], dp[i][j-1]);
			}
		}
		output.append(dp[n-1][k-1]);
		
		out.write(output.toString());
		out.flush();
		
	}
}



class NoD{
	int a,b,c;
	
	String s;
	long ms,ls,rs,ts;
	NoD(int aa,int bb){
		a=aa;b=bb;
		s=a+" "+b;
		
	}
	NoD(int aa,int bb,int cc){
		a=aa;b=bb;c=cc;
	}
	NoD(long m,long l,long r,long t){
		ms=m;ls=l;rs=r;ts=t;
	}
	@Override
	public boolean equals(Object o) {
		if(o!=null && o.getClass()==getClass()) {
			NoD c= (NoD) o;
			return c.a==a && c.b==b;
		}
		return false;
	}
	@Override
	public int hashCode() {
		return s.hashCode();
	}
}
class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;
    /** call this method to initialize reader for InputStream */
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