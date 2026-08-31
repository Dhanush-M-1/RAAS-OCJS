import java.util.*;		
import java.util.function.Function;
import java.util.stream.Collectors;
import java.io.*;
import java.math.*;
public class Main12{
	static public void main(String args[])throws IOException{
		int tt=1;
		StringBuilder sb=new StringBuilder();
		for(int ttt=1;ttt<=tt;ttt++){
			int n=i();
			int k=i();
			int[] a=new int[n];
			int[] b=new int[n];
			int[] c=new int[n];
			Pair[] pair=new Pair[n];
			ArrayList<Integer> alice=new ArrayList<>();
			ArrayList<Integer> bob=new ArrayList<>();
			ArrayList<Integer> both=new ArrayList<>();
			for(int i=0;i<n;i++){
				a[i]=i();
				b[i]=i();
				c[i]=i();
				if(b[i]==1 && c[i]==1){
					both.add(a[i]);
				}else if(b[i]==1){
					alice.add(a[i]);
				}else if(c[i]==1){
					bob.add(a[i]);
				}
			}
			Collections.sort(both);
			Collections.sort(bob);
			Collections.sort(alice);
			int[] pre=new int[bob.size()+1];
			if(bob.size()>0){
			pre[0]=bob.get(0);
			for(int i=1;i<bob.size();i++){
				pre[i]=pre[i-1]+bob.get(i);
			}}
			long[] pp=new long[alice.size()+1];
			if(alice.size()>0){
			pp[0]=alice.get(0);
			for(int i=1;i<alice.size();i++){
				pp[i]=pp[i-1]+alice.get(i);
			}}
			long[] sum=new long[both.size()+1];
			if(both.size()>0){
			sum[0]=both.get(0);
			for(int i=1;i<both.size();i++){
				sum[i]=sum[i-1]+both.get(i);
			}
			}
			long min=Long.MAX_VALUE;
			for(int i=0;i<=both.size();i++){
				int taken=i;
				long ans=0;
				if(taken-1>=0){
					ans=sum[taken-1];
				}
				int remBob=k-taken;
				int remAlice=k-taken;
				if(remBob<=0){
					remBob=0;
				}
				if(remAlice<=0){
					remAlice=0;
				}
				if(remBob>bob.size()){
					continue;
				}
				if(remAlice>alice.size()){
					continue;
				}
				if(remBob>0){
					ans=ans+pre[remBob-1];
				}
				if(remAlice>0){
					ans=ans+pp[remAlice-1];
				}
				min=Math.min(ans,min);
			}
			if(min==Long.MAX_VALUE){
				sb.append("-1\n");
			}else{
				sb.append(min+"\n");
			}
		}
		System.out.print(sb.toString());
	}
	
	static InputReader in=new InputReader(System.in);
	static OutputWriter out=new OutputWriter(System.out);
	static ArrayList<ArrayList<Integer>> graph;
	static int mod=1000000007;
	static class Pair{
		int x;
		int y;
		Pair(int x,int y){
			this.x=x;
			this.y=y;
		}
	/*	@Override
		public int hashCode() 
		{ 
			final int temp = 14; 
			int ans = 1; 
			ans =x*31+y*13; 
			return (int)ans;
		}*/ 
   /*    @Override
        public boolean equals(Object o) 
        { 
            if (this == o) { 
                return true; 
            } 
            if (o == null) { 
                return false; 
            } 
            if (this.getClass() != o.getClass()) { 
                return false; 
            } 
            Pair other = (Pair)o; 
            if (this.x != other.x || this.y!=other.y) { 
                return false; 
            } 
            return true; 
        }*/
	}
	public static int[] sort(int[] a){
		int n=a.length;
		ArrayList<Integer> ar=new ArrayList<>();
		for(int i=0;i<a.length;i++){
			ar.add(a[i]);
		}
		Collections.sort(ar);
		for(int i=0;i<n;i++){
			a[i]=ar.get(i);
		}
		return a;
	}
	public static long pow(long a, long b){
        long result=1;
        while(b>0){
            if (b % 2 != 0){
                result=(result*a)%mod;
                b--;
            } 
            a=(a*a)%mod;
            b /= 2;
        }   
        return result;
    }
	public static long gcd(long a, long b){
        if (a == 0){
            return b;
		}
        return gcd(b%a, a);
    }
	public static long lcm(long a, long b){
		return a*(b/gcd(a,b));
	}
	public static long l(){
		String s=in.String();
		return Long.parseLong(s);
	}
	public static void pln(String value){
		System.out.println(value);
	}
	public static int i(){
		return in.Int();
	}
	public static String s(){
		return in.String();
	}
} 
class InputReader 
{
	private InputStream stream;
	private byte[] buf = new byte[1024];
	private int curChar;
	private int numChars;
	private SpaceCharFilter filter;
	public InputReader(InputStream stream) {
		this.stream = stream;
	}
	public int read() {
		if (numChars== -1)
			throw new InputMismatchException();
		if (curChar >= numChars) {
			curChar = 0;
			try {
				numChars = stream.read(buf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (numChars <= 0)
				return -1;
		}
		return buf[curChar++];
	}
	public int Int() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		int res = 0;
		do {
			if (c < '0' || c > '9')
				throw new InputMismatchException();
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
	}
	public String String() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		StringBuilder res = new StringBuilder();
		do {
			res.appendCodePoint(c);
			c = read();
		} while (!isSpaceChar(c));
		return res.toString();
	} 
	public boolean isSpaceChar(int c) {
		if (filter != null)
			return filter.isSpaceChar(c);
		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	} 
	public String next() {
		return String();
	} 
	public interface SpaceCharFilter {
		public boolean isSpaceChar(int ch);
	}
}
class OutputWriter {
	private final PrintWriter writer;
	public OutputWriter(OutputStream outputStream) {
		writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
	}
	public OutputWriter(Writer writer) {
		this.writer = new PrintWriter(writer);
	}
	public void print(Object...objects) {
		for (int i = 0; i < objects.length; i++) {
			if (i != 0)
				writer.print(' ');
			writer.print(objects[i]);
		}
	}
	public void printLine(Object...objects) {
		print(objects);
		writer.println();
	}
	public void close() {
		writer.close();
	}
	public void flush() {
		writer.flush();
	}
 }
class IOUtils {
	public static int[] readIntArray(InputReader in, int size) {
		int[] array = new int[size];
		for (int i = 0; i < size; i++)
			array[i] = in.Int();
		return array;
	}
} 
