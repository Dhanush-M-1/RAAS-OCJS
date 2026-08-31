//Author: Mo Abjal, MJP Rohilkhand University Bareilly, UP, India 2018.
///////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////********************//////////////////////////////////////////////
/////////////////////////////////////////*     S0LUT10N     *//////////////////////////////////////////////
/////////////////////////////////////////********************//////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////

//mahnazanwar
//mahnaz1641
// 743545
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
		Integer A[] = ai(N);
		Arrays.sort(A);
		int max = A[N-1];
		long sum=0;
		for(int i=0;i<N;i++){
			sum+=A[i];
		}
		while(true){
			long temp=0;
			for(int i=0;i<N;i++){
				temp+=max-A[i];
			}
			if(temp>sum){
				output.println(max); break;
			}
			max++;
		}
		output.close();
		/*int T = ni();
		for(int i=0;i<T;i++){
			int N = ni();
			int M = ni();
			char C[][] = new char[N][M];
			for(int j=0;j<N;j++){
				String s = ns();
				char S[] = s.toCharArray();
				for(int k=0;k<M;k++){
					C[j][k] = S[k];
				}
			}
			int count=0;
			for(int j=0;j<N;j++){
				for(int k=0;k<M;k++){
					if(C[j][k]=='.') count++;
				}
			}
			for(int j=0;j<N-1;j++){
				for(int k=0;k<M-1;k++){
					char a = C[j][k];
					char b = C[j][k+1];
					char c = C[j+1][k];
					char d = C[j+1][k+1];
					if((a=='.' || a=='c') && (b=='.' || b=='c') && (c=='.' || c=='c') && (d=='.' || d=='c')){
						C[j][k] = 'c';
						C[j][k+1] = 'c';
						C[j+1][k] = 'c';
						C[j+1][k+1] = 'c';
					}
				}
			}
			//output.println();
			int temp=0;
			for(int j=0;j<N;j++){
				for(int k=0;k<M;k++){
					if(C[j][k]=='c') temp++;
					//output.print(C[j][k]);
				}
				//output.println();
			}
			//output.println(count+" "+temp);
			if(temp==count) output.println("YES"); else output.println("NO");
		}
		output.close();*/
	}
	public static String pc(char c){
		return Character.toString(c);
	} 
	public static Integer pci(char c){
		return pi(Character.toString(c));
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
	public static Double nd() throws IOException{
		if(!token.hasMoreElements()){
			token = new StringTokenizer(br.readLine());
		}
		return Double.parseDouble(token.nextToken());
	}
	public static String ns() throws IOException{
		if(!token.hasMoreElements()){
			token = new StringTokenizer(br.readLine());
		}
		return token.nextToken();
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
	public static double ncr(int n, int r){
		if(n==r) return 1;
		else
		return (fact(n)/(fact(r)*fact(n-r)));
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
	public static long sod(long N){
		long sum = 0;
		while(N>0){
			long x = N%10;
			sum = sum + x;
			N = N/10;
		}
		return sum;
	}
	public static Integer cd(long N){
		int count=0;
		while(N>0){
			N = N/10; count++;
		}
		return count=0;
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
		//if(this.a==pa.a) return this.b - pa.b;
		return this.a - pa.a;
	} 
}class Pair3 implements Comparable{
	int a,b,c;
	public Pair3(int a,int b,int c){
		this.a = a;
		this.b = b;
		this.c = c;
	}
	public int compareTo(Object p){
		Pair pa = (Pair)p;
		//if(this.a==pa.a) return this.b - pa.b;
		return this.a - pa.a;
	} 
}
//Copyright Reserved - Mo Abjal.
