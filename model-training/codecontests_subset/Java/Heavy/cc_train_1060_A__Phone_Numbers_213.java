//Author: Mo Abjal, MJP Rohilkhand University Bareilly, UP, India 2018.
/////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////***/////////////////////////////////////////////////////////////
////////////////////////////////////////*****////////////////////////////////////////////////////////////
///////////////////////////////////////**///**///////////////////////////////////////////////////////////
//////////////////////////////////////**/////**//////////////////////////////////////////////////////////
/////////////////////////////////////**///////**/////////////////////////////////////////////////////////
////////////////////////////////////*************////////////////////////////////////////////////////////
///////////////////////////////////***************///////////////////////////////////////////////////////
//////////////////////////////////**/////////////**//////////////////////////////////////////////////////
/////////////////////////////////**///////////////**/////////////////////////////////////////////////////
////////////////////////////////**/////////////////**////////////////////////////////////////////////////
///////////////////////////////**///////////////////**///////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////
// https://mymapit.in/code4/#/test/8235535
import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
public class Main{
	public static StringTokenizer token = new StringTokenizer("");
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static PrintWriter output = new PrintWriter(System.out);
	public static void main(String[] afzal) throws Exception {	
		int N = ni();
		String str = ns();
		//char S[] = str.toCharArray();
		int count=0;
		if(N>10 && str.contains("8")){
			for(int i=0;i<N;i++){
				if(str.charAt(i)=='8'){
					count++;
				}
			}
			if(count>0){
				int min = N/11;
				output.println(Math.min(min,count));
			}
			else{
				output.println(0);
			}
		}
		else{
			output.println(0);
		}
		output.close();
	}
	public String pc(char c){
		return Character.toString(c);
	} 
	public static Integer pi(String str){
		return Integer.parseInt(str);
	}
	public static Long pl(String str){
		return Long.parseLong(str);
	}
	public static String ps(Integer N){
		return Integer.toString(N);
	}
	public static char[] pcc(String str){
		return str.toCharArray();
	}
	public static Integer ni() throws IOException{
		if(!token.hasMoreElements()){
			token = new StringTokenizer(br.readLine());
		}
		return Integer.parseInt(token.nextToken());
	}
	public static Long nl() throws IOException{
		if(!token.hasMoreElements()){
			token = new StringTokenizer(br.readLine());
		}
		return Long.parseLong(token.nextToken());
	}
	public static String ns() throws IOException{
		return new StringTokenizer(br.readLine()).nextToken();
	}
	public static Integer[] ai(int N) throws IOException{
		Integer A[] = new Integer[N];
		token = new StringTokenizer(br.readLine());
		for(int i=0;i<A.length;i++){
			A[i] = pi(token.nextToken());
		}
		return A;
	}
	public static long[] al(int N) throws IOException{
		long A[] = new long[N];
		token = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++){
			A[i] = Long.parseLong(token.nextToken());
		}
		return A;
	}
	public static char[][] acc(int N,int M) throws IOException{
		char C[][] = new char[N][M];
		for(int i=0;i<N;i++){
			token = new StringTokenizer(br.readLine());
			String s = token.nextToken();
			for(int j=0;j<M;j++){
				C[i][j] = s.charAt(j);
			}
		}
		return C;
	}
	public static String[] as(int N) throws IOException{
		String S[] = new String[N];
		token = new StringTokenizer(br.readLine());
		for(int i=0;i<S.length;i++){
			S[i] = token.nextToken();
		}
		return S;
	}

	public static long fact(long N){
		long fact = 1;
		for(int i=1;i<=N;i++){
			fact = fact * i;
		}
		return fact;
	}
	public static BigInteger factB(int N){
		BigInteger b = new BigInteger("1");
		for(int i=1;i<=N;i++){
			b = b.multiply(BigInteger.valueOf(i));
		}
		return b;
	}
	public static long mp(long N,long size){
		long mul=1;
		long temp = N;
		for(long i=N;i>N-size;i--){
			mul = mul*temp--;
		}
		long fact = fact(size);
		if(mul/fact==0) return 1;
		return mul/fact;
	}
	public static long sod(long N){
		long sum = 0;
		while(N>0){
			long x = N%10;
			sum = sum + x;
			N = N/10;
		}
		return sum;
	}
}
class Pair implements Comparable{
	int a,b;
	public Pair(int a,int b){
		this.a = a;
		this.b = b;
	}
	public int compareTo(Object p){
		Pair pa = (Pair)p;
		if(this.a==pa.a) return this.b - pa.b;
		return this.a - pa.a;
	} 
}
//Copyright Reserved - Mo Abjal.