/*Author: Satyajeet Singh*/
import java.io.*;
import java.util.*;
import java.text.*; 
import java.lang.*;

public class Main {
	static PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out));		
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main (String[] args) throws Exception {
/****************************************Solutions Begins***************************************************/
		String st[]=br.readLine().split(" ");
		int q=Integer.parseInt(st[0]);
		for(int i1=0;i1<q;i1++){
			st=br.readLine().split(" ");
			long l=Long.parseLong(st[0]);
			long r=Long.parseLong(st[1]);
			long d=Long.parseLong(st[2]);

			if(d<l){
				out.println(d);
				continue;
			}
			long m2=r%d;
			long a2=r-m2+d;
			out.println(a2);
			
		}
/****************************************Solutions Ends*****************************************************/
		out.flush();
		out.close();
    }
/****************************************Template Begins***************************************************/
	static class PairCompL implements Comparator<Pairl>{
		public int compare(Pairl p1,Pairl p2){
			if(p1.v>p2.v){
				return 1;
			}
			else if(p1.v<p2.v){
				return -1;
			}
			else{
				return 0;
			}
		}
	}
	static class PairComp implements Comparator<Pair>{
		public int compare(Pair p1,Pair p2){
			if(p1.u>p2.u){
				return 1;
			}
			else if(p1.u<p2.u){
				return -1;
			}
			else{
				return 0;
			}
		}
	}
	static class Pair implements Comparable<Pair> {
		int u;
		int v;
		int index=-1;
		public Pair(int u, int v) {
			this.u = u;
			this.v = v;
		}
 
		public int hashCode() {
			int hu = (int) (u ^ (u >>> 32));
			int hv = (int) (v ^ (v >>> 32));
			return 31 * hu + hv;
		}
 
		public boolean equals(Object o) {
			Pair other = (Pair) o;
			return u == other.u && v == other.v;
		}
 
		public int compareTo(Pair other) {
			if(index!=other.index)
				return Long.compare(index, other.index);
			return Long.compare(v, other.v)!=0?Long.compare(v, other.v):Long.compare(u, other.u);
		}
 
		public String toString() {
			return "[u=" + u + ", v=" + v + "]";
		}
	}
static class Pairl implements Comparable<Pair> {
		long u;
		long v;
		int index=-1;
		public Pairl(long u, long v) {
			this.u = u;
			this.v = v;
		}
 
		public int hashCode() {
			int hu = (int) (u ^ (u >>> 32));
			int hv = (int) (v ^ (v >>> 32));
			return 31 * hu + hv;
		}
 
		public boolean equals(Object o) {
			Pair other = (Pair) o;
			return u == other.u && v == other.v;
		}
 
		public int compareTo(Pair other) {
			if(index!=other.index)
				return Long.compare(index, other.index);
			return Long.compare(v, other.v)!=0?Long.compare(v, other.v):Long.compare(u, other.u);
		}
 
		public String toString() {
			return "[u=" + u + ", v=" + v + "]";
		}
	}
	
	public static void debug(Object... o) {
		System.out.println(Arrays.deepToString(o));
	}
	static long modulo(long a,long b,long c) {
		long x=1;
		long y=a;
		while(b > 0){
			if(b%2 == 1){
				x=(x*y)%c;
			}
			y = (y*y)%c; // squaring the base
			b /= 2;
		}
		return  x%c;
	}
	static long gcd(long x, long y)
	{
		if(x==0)
			return y;
		if(y==0)
			return x;
		long r=0, a, b;
		a = (x > y) ? x : y; // a is greater number
		b = (x < y) ? x : y; // b is smaller number
		r = b;
		while(a % b != 0)
		{
			r = a % b;
			a = b;
			b = r;
		}
		return r;
	}
}
/*******************************************************End***********************************************************/