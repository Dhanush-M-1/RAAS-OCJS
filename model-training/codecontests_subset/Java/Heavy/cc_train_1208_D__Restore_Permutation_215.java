import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
 
 
public class q5 {
	
	
	public static void main(String[] args) throws IOException {
	
		Reader.init(System.in);
		PrintWriter out=new PrintWriter(System.out);
		int n=Reader.nextInt();
		long[] arr=new long[n];
		for(int i=0;i<n;i++) arr[i]=Reader.nextLong();
		Seg st=new Seg(n);
		st.build(0, 0, n-1);
		int[] ans=new int[n];
		for(int i=n-1;i>=0;i--) {
			ans[i]=st.query(0, 0, n-1, arr[i]);
			st.update(0, 0, n-1, ans[i]);
		}
		for(int i=0;i<n;i++) {
			out.print(ans[i]+1+" ");
		}
		out.flush();
	}	
}
class Seg{
	long[] st;
	Seg(int n){
		st=new long[4*n];
	}
	
	void build(int index, int left, int right) {
		if(left==right) {
			st[index]=left+1;
		}
		else {
			int mid=(left+right)/2;
			build(2*index+1,left,mid);build(2*index+2,mid+1,right);
			st[index]=st[2*index+1]+st[2*index+2];
		}
	}
	int query(int index, int left, int right, long v) {
		if(left==right) {
			return left;
		}
		int mid=left+right;mid/=2;
		if(st[2*index+1]>v) return query(2*index+1,left,mid,v);
		return query(2*index+2,mid+1,right,v-st[2*index+1]);
	}
	
	void update(int index, int left, int right, int pos) {
		if(left==right) st[index]=0;
		else {
			int mid=(left+right)/2;
			if(pos<=mid) update(2*index+1,left,mid,pos);
			else update(2*index+2,mid+1,right,pos);
			st[index]=st[2*index+1]+st[2*index+2];
		}
	}
}
 
 
 
class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;
    /** call this method to initialize reader for InputStream */
    static void init() throws IOException {
    	 reader = new BufferedReader(
                 new FileReader("input.txt"));
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