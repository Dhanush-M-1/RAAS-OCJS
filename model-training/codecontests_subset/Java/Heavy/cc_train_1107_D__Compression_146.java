/*Author: Satyajeet Singh, Delhi Technological University*/
import java.io.*;
import java.util.*;
import java.text.*; 
import java.lang.*;

public class Main {
	static PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out));		
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static long mod=(long)1e9+7;
	static long mod1=998244353;
	static boolean sieve[];
	static ArrayList<Integer> primes;
	static ArrayList<Long> factorial;
	static ArrayList<HashSet<Integer>> graph;
/****************************************Solutions Begins***************************************************/
	static int input[][];
	static int dp[][];
	static int n=0;

	static boolean possible(int k){
		if(n%k!=0){
			return false;
		}
		for(int i=0;i<n;i+=k){
			for(int j=0;j<n;j+=k){
				int k1=k-1;
				int kk=dp[i+k1][j+k1];
				if(i!=0){
					kk-=dp[i-1][j+k1];
				}
				if(j!=0){
					kk-=dp[i+k1][j-1];
				}
				if(i!=0&&j!=0){
					kk+=dp[i-1][j-1];
				}
				//out.print()
				if(!(input[i][j]==0&&kk==0||input[i][j]==1&&kk==k*k)){
					return false;
					//out.println("prob");
				}
			}
		}
		return true;
	}
	public static void main (String[] args) throws Exception {
		String st[]=br.readLine().split(" ");
		n=Integer.parseInt(st[0]);
		String str[]={"0000","0001","0010","0011","0100","0101","0110","0111","1000","1001","1010","1011","1100","1101","1110","1111"};
		input=new int[n][n];
		dp=new int[n][n];
		HashMap<Character,Integer> map=new HashMap<>();
		for(int i=0;i<10;i++){
			map.put((char)('0'+i),i);
		}
		char aa='A';
		for(int i=0;i<6;i++){
			map.put((char)(aa+i),i+10);
		}
	//	debug(map);
		for(int i=0;i<n;i++){
			st=br.readLine().split(" ");
			String inp=st[0];
			for(int j=0;j<inp.length();j++){
				for(int k=0;k<4;k++){
					input[i][4*j+k]=str[map.get(inp.charAt(j))].charAt(k)-'0';
				}
			}
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(i==0&&j==0){
					dp[i][j]=input[i][j];
				}
				else if(i==0){
					dp[i][j]+=dp[i][j-1]+input[i][j];
				}
				else if(j==0){
					dp[i][j]+=dp[i-1][j]+input[i][j];
				}
				else{
					dp[i][j]+=dp[i-1][j]+dp[i][j-1]+input[i][j]-dp[i-1][j-1];
				}
				//out.print(dp[i][j]+" ");
			}
			//out.println();
		}
		int ans=1;
		for(int i=n;i>=1;i--){
			if(possible(i)){
				//out.println("h");
				out.println(i);
				out.flush();
				return;
			}
		}
		//out.println(possible(1));
		out.println(ans);

	/*	for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				out.print(input[i][j]+" ");
			}
			out.println();
		}*/

/****************************************Solutions Ends*****************************************************/
		out.flush();
		out.close();
    }
/****************************************Template Begins***************************************************/
/***************************************Precision Printing**********************************************/
	static void printPrecision(double d){
		DecimalFormat ft = new DecimalFormat("0.000000"); 
		out.println(ft.format(d));
	}
/******************************************Graph***********************************************************/
	static void Makegraph(int n){
		graph=new ArrayList<>();
		for(int i=0;i<n;i++){
			graph.add(new HashSet<>());
		}
	}
	static void addEdge(int a,int b){
		graph.get(a).add(b);
		graph.get(b).add(a);
	}	
/*******************************************************TRIPLET********************************************/
	static class tripletComparator implements Comparator<triplet>{
		public int compare(triplet p1,triplet p2){
			if(p1.u<p2.u){
				return 1;
			}
			else if(p1.u>p2.u){
				return -1;
			}
			else{
				return 0;
			}
		}
	}
	static class triplet{
		int u;
		int v;
		int i;
		public triplet(int u,int v,int i){
			this.u=u;
			this.v=v;
			this.i=i;
		}
		public String toString() {
			return "[u=" + u + ", v=" + v + ", i="+i+"]";
		}
	}
/*********************************************PAIR*************************************************/
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
/*******************************************LONG PAIR******************************************/
	static class PairCompL implements Comparator<Pairl>{
		public int compare(Pairl p1,Pairl p2){
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
/*****************************************DEBUG***********************************************************/
	public static void debug(Object... o) {
		System.out.println(Arrays.deepToString(o));
	}
/*****************************************NUMBER THEORY***********************************************/

/************************************MODULAR EXPONENTIATION************************************/
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
/*********************************************GCD*****************************/
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
/*******************************************SIEVE*********************************/
	static void sieveMake(int n){
		sieve=new boolean[n];
		Arrays.fill(sieve,true);
		sieve[0]=false;
		sieve[1]=false;
		for(int i=2;i*i<n;i++){
			if(sieve[i]){
				for(int j=i*i;j<n;j+=i){
					sieve[j]=false;
				}
			}
		}
		primes=new ArrayList<Integer>();
		for(int i=0;i<n;i++){
			if(sieve[i]){
				primes.add(i);
			}
		}		
	}
/***************************************FACTORIAL*********************************************************/
	static void fact(int n){
		factorial=new ArrayList<>();
		factorial.add((long)1);
		for(int i=1;i<=n;i++){
			factorial.add((factorial.get(i-1)*i)%mod);
		}
	}
/*******************************************ncr*********************************************************/
	static long ncr(int n,int k){
		long aa=modulo(factorial.get(n-k),mod-2,mod);
		long bb=modulo(factorial.get(k),mod-2,mod);
		long cc=factorial.get(n);
		long ans=(aa*cc)%mod;
		ans=(ans*bb)%mod;
		return ans;
	}
/***************************************STRING REVERSE****************************************************/
	static String reverse(String str){
		char r[]=new char[str.length()];
		int j=0;
		for(int i=str.length()-1;i>=0;i--){
			r[j]=str.charAt(i);
			j++;
		}
		return new String(r);
	}
}
/*******************************************************End***********************************************************/